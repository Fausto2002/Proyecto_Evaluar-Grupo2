package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo E
 */
public class Conexion 
{
    private static Connection conn =null;
    private static final String login = "Proyecto";//Usuario de la Base de Datos
    private static final String password = "123456";//Contraseña de la Base de Datos
    private static final String url = "jdbc:oracle:thin:@//localhost:1521/xe";//url conexion a la base de Datos llamada "Proyecto"
    //jdbc:oracle:thin:@//localhost:1522/XE

  /**
   *
   * @return
   */
    public static Connection getConnection(){
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//Driver jdbc para establecer la conexion
            conn = DriverManager.getConnection(url,login,password);
            conn.setAutoCommit(false);
            
            if(conn!=null){
                System.out.println("Conexion Exitosa");
            }else{
                System.out.println("Conexion Erronea");
            }
        } catch (ClassNotFoundException|SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexion Erronea" + e.getMessage());
        
        }
        return conn;
    }
    
  /**
   * mensaje si ocurre error de coneccion
   */
  public void desconexion(){
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar "+ e.getMessage());
        }
    }
    
  /**
   *
   * @param args
   */
  public static void main(String[] args) {
        Conexion c=new Conexion();
        Conexion.getConnection();
    }
}
