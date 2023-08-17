package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultasHotel extends Conexion {

    /**
     * METODO REGISTRAR hotel
     *
     * @param h
     * @return
     */
    public boolean registrar(Hotel h) {
        String sql = "{CALL REGISTRAR_HOTEL(INCREMENTADOIDHOTEL.NEXTVAL,?,?,?,?,?)}";
        try (Connection con = getConnection();
             CallableStatement ps = con.prepareCall(sql)) {
           
            ps.setString(1, h.getNombre());
            ps.setString(2, h.getUbicacion());
            ps.setString(3, h.getTelefono());
            ps.setString(4, h.getDisponibilidad());
            ps.setString(5, h.getServicios());
            ps.execute();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(ConsultasHotel.class.getName()).log(Level.SEVERE, "Error al registrar hotel: " + e.getMessage(), e);
        }
        return false;
    }

    /**
     * METODO MODIFICAR hotel
     *
     * @param h
     * @return
     */
    public boolean modificar(Hotel h) {
        String sql = "{CALL ACTUALIZAR_HOTEL(?,?,?,?,?,?)}";
        try (Connection con = getConnection();
            CallableStatement ps = con.prepareCall(sql)) {
          
            ps.setInt(1, h.getIdHotel());
            ps.setString(2, h.getNombre());
            ps.setString(3, h.getUbicacion());
            ps.setString(4, h.getTelefono());
            ps.setString(5, h.getDisponibilidad());
            ps.setString(6, h.getServicios());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(ConsultasHotel.class.getName()).log(Level.SEVERE, "Error al modificar hotel: " + e.getMessage(), e);
        } 
        return false;
    }

    /**
     * METODO LISTAR hotel
     *
     * @param consulta
     * @return
     * Se agregó un `return null` al final del método en caso de que se produzca una excepción,
     * para evitar devolver un objeto `ResultSet` nulo en ese caso.
     */
    public static ResultSet ListarTabla(String consulta){
        Connection con = getConnection();
        try (Statement sql = con.createStatement()) {
            return sql.executeQuery(consulta);
        } catch (SQLException e) {
            Logger.getLogger(ConsultasHotel.class.getName()).log(Level.SEVERE, "Error al listar hoteles: " + e.getMessage(), e);
        }
        return null;
    }

    /**
     * METODO ELIMINAR HOTEL
     *
     * @param id
     * @return
     */
    public static boolean Eliminar(String id) {
        int idH = Integer.parseInt(id);
        String sql = "{CALL ELIMINAR_HOTEL(?)}";

        try (Connection con = getConnection();
             CallableStatement ps = con.prepareCall(sql)) {
            ps.setInt(1, idH);
            ps.execute();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(ConsultasHotel.class.getName()).log(Level.SEVERE, "Error al eliminar hotel: " + e.getMessage(), e);
        }
        return false;
    }
}