
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.junit.Test;

/**
 *
 * @author staly
 */
public class ConexionTest {
    Connection conn;

  /**
   * vista
   */
  public ConexionTest() {
        
    }

  /**
   *
   * @throws SQLException
   */
  @Test
    public void testGetConnection() throws SQLException{
        try {
            //Driver jdbc para establecer la conexion
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","Proyecto","123456");
            conn.setAutoCommit(false);
            
            if(conn!=null){
                System.out.println("Conexion Exitosa");
            }else{
                System.out.println("Conexion Erronea");
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Conexion Erronea" + e.getMessage());
        }
    }
}
