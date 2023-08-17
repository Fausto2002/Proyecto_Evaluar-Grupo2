
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
            // Driver jdbc para establecer la conexión
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "Proyecto", "123456");
            conn.setAutoCommit(false);
    
            System.out.println("Conexión Exitosa");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Conexión Erronea" + e.getMessage());
        }
    }
}
