package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultasCliente extends Conexion {
  /**
   * METODO REGISTRAR CLIENTE
   * 
   * @param c
   * @return
   *         Se utiliza un bloque try-with-resources para asegurar el cierre
   *         automático,
   *         se evita la necesidad de usar el bloque finally para cerrar la
   *         conexión manualmente.
   */
  public boolean registrar(Cliente c) {
    String sql = "{CALL REGISTRAR_CLIENTE(INCREMENTADOIDCLIENTE.NEXTVAL,?,?,?,?,?,?)}";
    try (Connection con = getConnection();
        CallableStatement ps = con.prepareCall(sql)) {

      ps.setString(1, c.getCedula());
      ps.setString(2, c.getNombres());
      ps.setString(3, c.getApellidos());
      ps.setString(4, c.getTelefono());
      ps.setString(5, c.getDireccion());
      ps.setString(6, c.getEmail());
      ps.execute();
      return true;
    } catch (SQLException e) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al registrar cliente: " + e.getMessage(), e);
    }
    return false;
  }

  /**
   * METODO MODIFICAR CLIENTE
   * 
   * @param c
   * @return
   */
  public boolean modificar(Cliente c) {
    String sql = "{CALL ACTUALIZAR_CLIENTE(?,?,?,?,?,?,?)}";
    try (Connection con = getConnection();
        CallableStatement ps = con.prepareCall(sql)) {

      ps.setInt(1, c.getIdCliente());
      ps.setString(2, c.getCedula());
      ps.setString(3, c.getNombres());
      ps.setString(4, c.getApellidos());
      ps.setString(5, c.getTelefono());
      ps.setString(6, c.getDireccion());
      ps.setString(7, c.getEmail());
      ps.executeUpdate();
      return true;
    } catch (SQLException e) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al modificar cliente: " + e.getMessage(), e);
    }
    return false;
  }

  /**
   * METODO LISTAR CLIENTES
   * 
   * @param consulta
   * @return
   *         Se agregó un `return null` al final del método en caso de que se
   *         produzca una excepción,
   *         para evitar devolver un objeto `ResultSet` nulo en ese caso.
   *         al final del método en caso de que se produzca una excepción, para
   *         evitar devolver un objeto `ResultSet` nulo en ese caso.
   */
  public static ResultSet ListarTabla(String consulta) {
    try (Connection con = getConnection();
        Statement sql = con.createStatement()) {

      return sql.executeQuery(consulta);
    } catch (Exception e) {
      Logger.getLogger(ConsultasCliente.class.getName()).log(Level.SEVERE, "Error al listar tabla: " + e.getMessage(),
          e);
    }
    return null;
  }

  /**
   * METODO ELIMINAR CLIENTE
   * 
   * @param id
   * @return
   *         La creación del objeto CallableStatement se movió dentro del bloque
   *         try para garantizar su cierre adecuado en caso de excepción.
   */
  public static boolean Eliminar(String id) {
    try {
      int idC = Integer.parseInt(id);
      String sql = "{CALL ELIMINAR_CLIENTE(?)}";
      try (Connection con = getConnection();
          CallableStatement ps = con.prepareCall(sql)) {

        ps.setInt(1, idC);
        ps.execute();

        return true;
      } catch (SQLException e) {
        Logger.getLogger(ConsultasCliente.class.getName()).log(Level.SEVERE,
            "Error al eliminar cliente: " + e.getMessage(), e);
        return false;
      }
    } catch (NumberFormatException e) {
      Logger.getLogger(ConsultasCliente.class.getName()).log(Level.WARNING,
          "Error al convertir ID a entero: " + e.getMessage(), e);
      return false;
    }
  }
}
