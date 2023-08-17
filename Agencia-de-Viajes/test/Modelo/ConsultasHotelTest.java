
package Modelo;


import static Modelo.Conexion.getConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

public class ConsultasHotelTest {
    String consulta;

    public ConsultasHotelTest() {
    }

    @Test
    public void testRegistrar() {
        try (Connection con = getConnection()) {
            String sql = "{CALL REGISTRAR_HOTEL(INCREMENTADOIDHOTEL.NEXTVAL,?,?,?,?,?)}";
            try (CallableStatement ps = con.prepareCall(sql)) {
                ps.setString(1, "Boston Hotel");
                ps.setString(2, "Padre Vicente Solano Vargas, Guayaquil 090312");
                ps.setString(3, "04230-8015");
                ps.setString(4, "si");
                ps.setString(5, "Estacionamiento, WIFI, Desayuno");
                ps.execute();
            } catch (SQLException e) {
                Logger.getLogger(ConsultasHotelTest.class.getName()).log(Level.SEVERE, "Error en testRegistrar", e);
            }
        } catch (SQLException e) {
            Logger.getLogger(ConsultasHotelTest.class.getName()).log(Level.SEVERE, "Error en testRegistrar", e);
        }
    }

    @Test
    public void testModificar() {
        try (Connection con = getConnection()) {
            String sql = "{CALL ACTUALIZAR_HOTEL(?,?,?,?,?,?)}";
            try (CallableStatement ps = con.prepareCall(sql)) {
                ps.setInt(1, 1);
                ps.setString(2, "Boston Hotel");
                ps.setString(3, "Padre Vicente Solano Vargas, Guayaquil 090312");
                ps.setString(4, "04230-8015");
                ps.setString(5, "No");
                ps.setString(6, "Estacionamiento, WIFI, Desayuno, Jacuzzi");
                ps.executeUpdate();
            } catch (SQLException e) {
                Logger.getLogger(ConsultasHotelTest.class.getName()).log(Level.SEVERE, "Error en testModificar", e);
            }
        } catch (SQLException e) {
            Logger.getLogger(ConsultasHotelTest.class.getName()).log(Level.SEVERE, "Error en testModificar", e);
        }
    }

    @Test
    public void testListarTabla() {
        try (Connection con = getConnection()) {
            try (Statement sql = con.createStatement()) {
                sql.executeQuery(consulta);
            } catch (Exception e) {
                Logger.getLogger(ConsultasHotelTest.class.getName()).log(Level.SEVERE, "Error en testListarTabla", e);
            }
        } catch (SQLException e) {
            Logger.getLogger(ConsultasHotelTest.class.getName()).log(Level.SEVERE, "Error en testListarTabla", e);
        }
    }

    @Test
    public void testEliminar() {
        try (Connection con = getConnection()) {
            String sql = "{CALL ELIMINAR_HOTEL(?)}";
            try (CallableStatement ps = con.prepareCall(sql)) {
                ps.setInt(1, 1);
                ps.execute();
            } catch (SQLException e) {
                Logger.getLogger(ConsultasHotelTest.class.getName()).log(Level.SEVERE, "Error en testEliminar", e);
            }
        } catch (SQLException e) {
            Logger.getLogger(ConsultasHotelTest.class.getName()).log(Level.SEVERE, "Error en testEliminar", e);
        }
    }
}