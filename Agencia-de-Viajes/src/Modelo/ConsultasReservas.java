package Modelo;

import static Modelo.Conexion.getConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import oracle.jdbc.OracleTypes;

public class ConsultasReservas {

    private static final Logger logger = Logger.getLogger(ConsultasReservas.class.getName());

    public boolean registrar(Reserva r) {
        String sql = "{CALL REGISTRAR_RESERVA(UNO.NEXTVAL,?,?,?,?,?,?,?,?,?)}";
        try (Connection con = getConnection();
             CallableStatement ps = con.prepareCall(sql)) {
            ps.setDate(1, new java.sql.Date(r.getFechaInicio().getTime()));
            ps.setDate(2, new java.sql.Date(r.getFechaFin().getTime()));
            ps.setString(3, r.getCliente());
            ps.setString(4, r.getCedula());
            ps.setString(5, r.getHotel());
            ps.setInt(6, r.getHabitaciones());
            ps.setInt(7, r.getPersonas());
            ps.setDouble(8, r.getPrecioTotal());
            ps.setString(9, r.getEstado());
            ps.execute();
            return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al registrar reserva", e);
        }
        return false;
    }

    public boolean modificar(Reserva r) {
        String sql = "{CALL ACTUALIZAR_RESERVA(?,?,?,?,?,?,?,?,?,?)}";
        try (Connection con = getConnection();
             CallableStatement ps = con.prepareCall(sql)) {
            ps.setInt(1, r.getIdReserva());
            ps.setDate(2, new java.sql.Date(r.getFechaInicio().getTime()));
            ps.setDate(3, new java.sql.Date(r.getFechaFin().getTime()));
            ps.setString(4, r.getCliente());
            ps.setString(5, r.getCedula());
            ps.setString(6, r.getHotel());
            ps.setInt(7, r.getHabitaciones());
            ps.setInt(8, r.getPersonas());
            ps.setDouble(9, r.getPrecioTotal());
            ps.setString(10, r.getEstado());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al modificar reserva", e);
        }
        return false;
    }

    public static boolean Eliminar(String id) {
        int idR = Integer.parseInt(id);
        String sql = "{CALL ELIMINAR_RESERVA(?)}";
        try (Connection con = getConnection();
             CallableStatement ps = con.prepareCall(sql)) {
            ps.setInt(1, idR);
            ps.execute();
            return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar reserva", e);
            return false;
        }
    }

    public DefaultComboBoxModel<String> obtenerNombresHoteles() {
        DefaultComboBoxModel<String> listadoHoteles = new DefaultComboBoxModel<>();
        listadoHoteles.addElement("Seleccione");

        try (Connection con = getConnection();
             CallableStatement stmt = con.prepareCall("{call SP_OBTENER_HOTELES_DISPONIBLES(?)}")) {

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();

            ResultSet rs = (ResultSet) stmt.getObject(1);
            while (rs.next()) {
                listadoHoteles.addElement(rs.getString("NOMBRE"));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener nombres de hoteles", e);
        }
        return listadoHoteles;
    }

    public static ResultSet ListarTabla(String consulta) {
        try (Connection con = getConnection();
             Statement sql = con.createStatement()) {
            return sql.executeQuery(consulta);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al listar tabla", e);
        }
        return null;
    }
}
