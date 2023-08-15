
package Modelo;

import static Modelo.Conexion.getConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;

/**
 *
 * @Grupo E
 */
public class ConsultasVueloTest {
    String consulta="";

  /**
   * vista
   */
  public ConsultasVueloTest() {
    }

  /**
   * insertar un registro de vuelo
   */
  @Test
    public void testRegistrar() {
        //ESTABLECE LA CONEXION A LA BASE DE DATOS
        CallableStatement ps = null;
        Connection con = getConnection();
        
        //SETENCIA SQL
        String sql = "{CALL REGISTRAR_VUELO(INCREMENTADOIDVUELO.NEXTVAL,?,?,?,?,?)}";//Insertando datos en la tabla VUELO

        try {
            ps = (CallableStatement) con.prepareCall(sql);
            //NOMBRE DE LA AEROLINEA
            ps.setString(1, "Airlines");
            //ORIGEN DEL VUELO
            ps.setString(2, "Guayaquil");
            //DESTINO DEL VUELO
            ps.setString(3, "Miami");
            //ESCALA DEL VUELO
            ps.setString(4, "Panama");
            //DISPONIBILIDAD DEL VUELO
            ps.setString(5, "si");
            ps.execute();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

  /**
   * modificar un vuelo
   */
  @Test
    public void testModificar() {
        //ESTABLECE LA CONEXION A LA BASE DE DATOS
         CallableStatement ps = null;
        Connection con = getConnection();
        
        //SETENCIA SQL
        String sql = "{CALL ACTUALIZAR_VUELO(?,?,?,?,?,?)}";
   
        try {
            
            ps = con.prepareCall(sql);
            //ID DEL VUELO
            ps.setInt(1, 1);
            //NOMBRE DE LA AEROLINEA DEL VUELO
            ps.setString(2, "Airlines");
            //ORIGEN DEL VUELO
            ps.setString(3, "Guayaquil");
            //DESTINO DEL VUELO
            ps.setString(4, "Miami");
            //ESCALA DEL VUELO
            ps.setString(5, "Ninguna");
            //DISPONIBILIDAD DEL VUELO
            ps.setString(6, "No");
            //Envia la sentencia de Actualizar
            ps.executeUpdate();
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

  /**
   * consultar un vuelo
   */
  @Test
    public void testListarTabla() {
        Statement sql;
        ResultSet rs=null;
        Connection con = getConnection();
        try {
            sql=con.createStatement();
            rs=sql.executeQuery(consulta);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

  /**
   * eliminar un vuelo
   */
  @Test
    public void testEliminar() {
        //ESTABLECE LA CONEXION A LA BASE DE DATOS
        CallableStatement ps = null;
        Connection con = getConnection();
        
        //SENTENCIA SQL
        String sql = "{CALL ELIMINAR_VUELO(?)}";

        try {
            ps = con.prepareCall(sql);
            
            //SE PASA EL ID_VUELO PARA PROCEDER A LA ELIMINACION DEL REGISTRO 
            ps.setInt(1, 1);
            ps.execute();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
