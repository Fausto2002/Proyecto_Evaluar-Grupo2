package Modelo;
import static Modelo.Conexion.getConnection;
import java.sql.*;
import java.sql.SQLException;

/**
 *
 * @author staly
 */
public class ConsultasLogin {

  /**
   *
   * @param usuario
   * @param clave
   * @return
   * @throws SQLException
   * Se elimina la variable valido y se retorna directamente el resultado de la comparación resultado == 1.
   * No es necesario cerrar explícitamente los objetos ps y con en el bloque finally cuando se utilizan en un bloque try-with-resources.
   */
  public boolean validarUsuario(String usuario, String clave) throws SQLException {
      String sql = "{ call VALIDAR_USUARIO(?,?,?) }";
      try (Connection con = getConnection();
           CallableStatement ps = con.prepareCall(sql)) {

          ps.setString(1, usuario);
          ps.setString(2, clave);
          ps.registerOutParameter(3, Types.NUMERIC);
          ps.execute();
          int resultado = ps.getInt(3);

          return resultado == 1;
      }
    }
}