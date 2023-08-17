package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo E
 */
public class Conexion {
    private static Connection conn = null;
    private static final String login = "Proyecto";// Usuario de la Base de Datos
    private static final String password = "123456";// Contraseña de la Base de Datos
    private static final String url = "jdbc:oracle:thin:@//localhost:1521/xe";// url conexion a la base de Datos llamada
                                                                              // "Proyecto"
    // jdbc:oracle:thin:@//localhost:1522/XE

    /**
     *
     * @return
     */
    public static Connection getConnection() {

        try {
            conn = DriverManager.getConnection(url, login, password);
            conn.setAutoCommit(false);

            Logger.getLogger(Conexion.class.getName()).log(Level.INFO, "Conexión Exitosa");

        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error de conexión: {0}", e.getMessage());
        }

        return conn;
    }

    /**
     * mensaje si ocurre error de coneccion
     */
    public void desconexion() {
        try {
            conn.close();
        } catch (Exception e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al desconectar", e);
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Conexion.getConnection();
    }
}
