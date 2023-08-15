package Modelo;

import java.sql.*;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author staly
 */
public class ConsultasVuelo extends Conexion {
    
  /**
   * METODO REGISTRAR CLIENTE
   * @param v
   * @return
   */
    public boolean registrar(Vuelo v) {

        String sql = "{CALL REGISTRAR_VUELO(INCREMENTADOIDVUELO.NEXTVAL,?,?,?,?,?)}";//Insertando datos en la tabla VUELO
        try (Connection con = getConnection();
            CallableStatement ps = con.prepareCall(sql)){
            ps.setString(1, v.getNombreAerolinea());
            ps.setString(2, v.getOrigen());
            ps.setString(3, v.getDestino());
            ps.setString(4, v.getEscala());
            ps.setString(5, v.getDisponibilidad());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
   
  /**
   * METODO MODIFICAR CLIENTE
   * @param v
   * @return
   */
     public boolean modificar(Vuelo v) {
       
        String sql = "{CALL ACTUALIZAR_VUELO(?,?,?,?,?,?)}";
        try (Connection con = getConnection();
            CallableStatement ps = con.prepareCall(sql)){
            ps.setInt(1, v.getIdVuelo());
            ps.setString(2, v.getNombreAerolinea());
            ps.setString(3, v.getOrigen());
            ps.setString(4, v.getDestino());
            ps.setString(5, v.getEscala());
            ps.setString(6, v.getDisponibilidad());
            //Envia la sentencia de Actualizar
            ps.executeUpdate();
            con.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
        } return false;
    }
       

  /**
   * METODO LISTAR vuelo
   * @param consulta
   * @return
   */
    public static ResultSet ListarTabla(String consulta){
        try {
        Connection con = getConnection();
        Statement sql = con.createStatement();
        return sql.executeQuery(consulta);
    } catch (SQLException e) {
        System.out.println(e);
    }
    return null;
}
    
  /**
   * METODO ELIMINAR vuelo
   * @param id
   * @return
   */
    public static boolean Eliminar(String id) {
        int idH=Integer.parseInt(id);
        String sql = "{CALL ELIMINAR_VUELO(?)}";

        try (Connection con = getConnection();
            CallableStatement ps = con.prepareCall(sql)){
             ps.setInt(1, idH);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
           return false;
        }
    }
}
