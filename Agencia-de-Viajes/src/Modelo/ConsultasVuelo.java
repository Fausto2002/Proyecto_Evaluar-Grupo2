package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultasVuelo extends Conexion {

    private static final Logger logger = Logger.getLogger(ConsultasVuelo.class.getName());

    public boolean registrar(Vuelo v) {
        String sql = "{CALL REGISTRAR_VUELO(INCREMENTADOIDVUELO.NEXTVAL,?,?,?,?,?)}";
        try (Connection con = getConnection();
             CallableStatement ps = con.prepareCall(sql)) {
            ps.setString(1, v.getNombreAerolinea());
            ps.setString(2, v.getOrigen());
            ps.setString(3, v.getDestino());
            ps.setString(4, v.getEscala());
            ps.setString(5, v.getDisponibilidad());
            ps.execute();
            return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al registrar vuelo", e);
        }
        return false;
    }

    public boolean modificar(Vuelo v) {
        String sql = "{CALL ACTUALIZAR_VUELO(?,?,?,?,?,?)}";
        try (Connection con = getConnection();
             CallableStatement ps = con.prepareCall(sql)) {
            ps.setInt(1, v.getIdVuelo());
            ps.setString(2, v.getNombreAerolinea());
            ps.setString(3, v.getOrigen());
            ps.setString(4, v.getDestino());
            ps.setString(5, v.getEscala());
            ps.setString(6, v.getDisponibilidad());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al modificar vuelo", e);
        }
        return false;
    }

    public static ResultSet ListarTabla(String consulta) {
        try (Connection con = getConnection();
             Statement sql = con.createStatement()) {
            return sql.executeQuery(consulta);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al listar tabla de vuelo", e);
        }
        return null;
    }

    public static boolean Eliminar(String id) {
        int idH = Integer.parseInt(id);
        String sql = "{CALL ELIMINAR_VUELO(?)}";
        try (Connection con = getConnection();
             CallableStatement ps = con.prepareCall(sql)) {
            ps.setInt(1, idH);
            ps.execute();
            return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar vuelo", e);
            return false;
        }
    }
}
