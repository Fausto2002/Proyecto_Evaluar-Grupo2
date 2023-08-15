
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
 * @author hp
 */
public class ConsultasClienteTest {
    Cliente c= new Cliente();
    String consulta,id="1";
  
  /**
   * vista
   */
  public ConsultasClienteTest() {
    }

  /**
   * Insertando datos en la tabla CLIENTE
   */
  @Test
    public void testRegistrar() {
        //ESTABLECE LA CONEXION A LA BASE DE DATOS
        CallableStatement ps = null;
        Connection con = getConnection();
        
        //SENTENCIA SQL
        String sql = "{CALL REGISTRAR_CLIENTE(INCREMENTADOIDCLIENTE.NEXTVAL,?,?,?,?,?,?)}";//Insertando datos en la tabla CLIENTE

        try {
            ps = (CallableStatement) con.prepareCall(sql);
            //NUMERO DE CEDULA DEL CLIENTE
            ps.setString(1, "0954310736");
            //NOMBRES DEL CLIENTE
            ps.setString(2, "Maximiliano Stalin");
            //APELLIDOS DEL CLIENTE
            ps.setString(3, "Cabrera Gamboa");
            //NUMERO DE TELEFONO DEL CLIENTE
            ps.setString(4, "0962712966");
            //DIRECCION DOMICILIARIA DEL CLIENTE
            ps.setString(5, "Samborondon-Guayas");
            //EMAIL DEL CLIENTE
            ps.setString(6, "maximilianocabrera885@gmail.com");
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
   * ESTABLECE LA CONEXION A LA BASE DE DATOS
   */
  @Test
    public void testModificar() {
        //ESTABLECE LA CONEXION A LA BASE DE DATOS
        CallableStatement ps = null;
        Connection con = getConnection();
        
        //SENTENCIA SQL
        String sql = "{CALL ACTUALIZAR_CLIENTE(?,?,?,?,?,?,?)}";
   
        try {
            
            ps = con.prepareCall(sql);
            //ID DEL CLIENTE
            ps.setInt(1, 1);
            //NUMERO DE CEDULA DEL CLIENTE
            ps.setString(2, "0954310736");
            //NOMBRES DEL CLIENTE
            ps.setString(3, "Maximiliano");
            //APELLIDOS DEL CLIENTE
            ps.setString(4, "Cabrera ");
            //NUMERO DE TELEFONO DEL CLIENTE
            ps.setString(5, "0962712966");
            //DIRECCION DEL DOMICILIO DEL CLIENTE
            ps.setString(6, "Guayaquil");
            //EMAIL DEL CLIENTE
            ps.setString(7, "maximilianocabrera885@gmail.com");
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
   * coneccion
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
   * elimina un cliente
   */
  @Test
    public void testEliminar() {
        //ESTABLECE LA CONEXION A LA BASE DE DATOS
        CallableStatement ps = null;
        Connection con = getConnection();
        
        //SENTENCIA SQL
        String sql = "{CALL ELIMINAR_CLIENTE(?)}";

        try {
            ps = con.prepareCall(sql);
            
            //SE PASA EL ID_CLIENTE PARA PROCEDER A LA ELIMINACION DEL REGISTRO 
            ps.setInt(1, 1);
            ps.execute();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
