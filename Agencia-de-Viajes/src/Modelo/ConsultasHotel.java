package Modelo;

import java.sql.*;
import java.sql.SQLException;
import java.sql.ResultSet;


public class ConsultasHotel extends Conexion {
  /**
   * METODO REGISTRAR hotel
   * @param h
   * @return
   */
    public boolean registrar(Hotel h) {
        String sql = "{CALL REGISTRAR_HOTEL(INCREMENTADOIDHOTEL.NEXTVAL,?,?,?,?,?)}";//Insertando datos en la tabla HOTEL
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
          System.out.println(e);
        }
        return false;
    }

  /**
   * METODO MODIFICAR hotel
   * @param h
   * @return
   */
     public boolean modificar(Hotel h) {
        String sql = "{CALL ACTUALIZAR_HOTEL(?,?,?,?,?,?)}";
        try (Connection con = getConnection();
            CallableStatement ps = con.prepareCall(sql);) {
          
            ps.setInt(1, h.getIdHotel());
            ps.setString(2, h.getNombre());
            ps.setString(3, h.getUbicacion());
            ps.setString(4, h.getTelefono());
            ps.setString(5, h.getDisponibilidad());
            ps.setString(6, h.getServicios());
            //Envia la sentencia de Actualizar
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
        } 
        return false;
    }

  /**
   * METODO LISTAR hotel
   * @param consulta
   * @return 
   * Se agregó un `return null` al final del método en caso de que se produzca una excepción,
   * para evitar devolver un objeto `ResultSet` nulo en ese caso.
   * al final del método en caso de que se produzca una excepción, para evitar devolver un objeto `ResultSet` nulo en ese caso.
   */
    public static ResultSet ListarTabla(String consulta){
        Connection con = getConnection();
        try {
              Statement sql = con.createStatement();
              return sql.executeQuery(consulta);
            } catch (Exception e) {
        System.out.println(e);
        }
        return null;
    }
    
  /**
   * METODO ELIMINAR HOTEL
   * @param id
   * @return
   */
    public static boolean Eliminar(String id) {
        int idH = Integer.parseInt(id);
         String sql = "{CALL ELIMINAR_HOTEL(?)}";

        try (Connection con = getConnection()){
            CallableStatement ps = con.prepareCall(sql);
            ps.setInt(1, idH);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
