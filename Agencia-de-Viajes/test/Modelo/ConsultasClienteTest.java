
package Modelo;

import static Modelo.Conexion.getConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

public class ConsultasClienteTest {
    Cliente c = new Cliente();
    String consulta, id = "1";

    public ConsultasClienteTest() {
    }

    @Test
    public void testRegistrar() {
        try (Connection con = getConnection()) {
            String sql = "{CALL REGISTRAR_CLIENTE(INCREMENTADOIDCLIENTE.NEXTVAL,?,?,?,?,?,?)}";
            try (CallableStatement ps = con.prepareCall(sql)) {
                ps.setString(1, "0954310736");
                ps.setString(2, "Maximiliano Stalin");
                ps.setString(3, "Cabrera Gamboa");
                ps.setString(4, "0962712966");
                ps.setString(5, "Samborondon-Guayas");
                ps.setString(6, "maximilianocabrera885@gmail.com");
                ps.execute();
            } catch (SQLException e) {
                Logger.getLogger(ConsultasClienteTest.class.getName()).log(Level.SEVERE, "Error en testRegistrar", e);
            }
        } catch (SQLException e) {
            Logger.getLogger(ConsultasClienteTest.class.getName()).log(Level.SEVERE, "Error en testRegistrar", e);
        }
    }

    @Test
    public void testModificar() {
        try (Connection con = getConnection()) {
            String sql = "{CALL ACTUALIZAR_CLIENTE(?,?,?,?,?,?,?)}";
            try (CallableStatement ps = con.prepareCall(sql)) {
                ps.setInt(1, 1);
                ps.setString(2, "0954310736");
                ps.setString(3, "Maximiliano");
                ps.setString(4, "Cabrera ");
                ps.setString(5, "0962712966");
                ps.setString(6, "Guayaquil");
                ps.setString(7, "maximilianocabrera885@gmail.com");
                ps.executeUpdate();
            } catch (SQLException e) {
                Logger.getLogger(ConsultasClienteTest.class.getName()).log(Level.SEVERE, "Error en testModificar", e);
            }
        } catch (SQLException e) {
            Logger.getLogger(ConsultasClienteTest.class.getName()).log(Level.SEVERE, "Error en testModificar", e);
        }
    }

    @Test
    public void testListarTabla() {
        try (Connection con = getConnection()) {
            try (Statement sql = con.createStatement()) {
                ResultSet rs = sql.executeQuery(consulta);
            } catch (Exception e) {
                Logger.getLogger(ConsultasClienteTest.class.getName()).log(Level.SEVERE, "Error en testListarTabla", e);
            }
        } catch (SQLException e) {
            Logger.getLogger(ConsultasClienteTest.class.getName()).log(Level.SEVERE, "Error en testListarTabla", e);
        }
    }

    @Test
    public void testEliminar() {
        try (Connection con = getConnection()) {
            String sql = "{CALL ELIMINAR_CLIENTE(?)}";
            try (CallableStatement ps = con.prepareCall(sql)) {
                ps.setInt(1, 1);
                ps.execute();
            } catch (SQLException e) {
                Logger.getLogger(ConsultasClienteTest.class.getName()).log(Level.SEVERE, "Error en testEliminar", e);
            }
        } catch (SQLException e) {
            Logger.getLogger(ConsultasClienteTest.class.getName()).log(Level.SEVERE, "Error en testEliminar", e);
        }
    }
}
