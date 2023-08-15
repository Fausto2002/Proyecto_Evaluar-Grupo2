package Modelo;

import static Modelo.Conexion.getConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Pc
 */
public class ConsultasReservas {

    //METODO REGISTRAR RESERVAS

  /**
   *
   * @param r
   * @return
   */
    public boolean registrar(Reserva r) {

        String sql = "{CALL REGISTRAR_RESERVA(UNO.NEXTVAL,?,?,?,?,?,?,?,?,?)}";//Insertando datos en la tabla CLIENTE
        try (Connection con = getConnection();
            CallableStatement ps = con.prepareCall(sql)){
            ps.setDate(1, new java.sql.Date(r.getFechaInicio().getTime()));
            ps.setDate(2, new java.sql.Date(r.getFechaFin().getTime()));
            ps.setString(3, r.getCliente());
            ps.setString(4, r.getCedula());
            ps.setString(5, r.getHotel());
            ps.setInt(6, r.getHabitaciones());
            ps.setInt(7, r.getPersonas());
            ps.setDouble(8, r.getPrecioTotal());
            ps.setString(9, r.getEstado());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

  /**
   * METODO MODIFICAR RESERVA
   * @param r
   * @return
   */
    public boolean modificar(Reserva r) {
        String sql = "{CALL ACTUALIZAR_RESERVA(?,?,?,?,?,?,?,?,?,?)}";
        try (Connection con = getConnection();
            CallableStatement ps = con.prepareCall(sql)){
            ps.setInt(1, r.getIdReserva());
            ps.setDate(2, new java.sql.Date(r.getFechaInicio().getTime()));
            ps.setDate(3, new java.sql.Date(r.getFechaFin().getTime()));
            ps.setString(4, r.getCliente());
            ps.setString(5, r.getCedula());
            ps.setString(6, r.getHotel());
            ps.setInt(7, r.getHabitaciones());
            ps.setInt(8, r.getPersonas());
            ps.setDouble(9, r.getPrecioTotal());
            ps.setString(10, r.getEstado());
            //Envia la sentencia de Actualizar
            ps.executeUpdate();
            con.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

  /**
   *
   * @param id
   * @return
   */
  public static boolean Eliminar(String id) {
        int idR = Integer.parseInt(id);
        String sql = "{CALL ELIMINAR_RESERVA(?)}";
        try (Connection con = getConnection();
            CallableStatement ps = con.prepareCall(sql)){
            ps.setInt(1, idR);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

  /**
   * Nombres de los hoteles
   * @return
   * Se eliminó el bloque try anidado innecesario y se utilizó un solo bloque try para manejar la conexión, 
   * la llamada al procedimiento almacenado y el resultado del cursor.
   */ 
  public DefaultComboBoxModel obtenerNombresHoteles() {
        DefaultComboBoxModel<String> listadoHoteles = new DefaultComboBoxModel<>();
        listadoHoteles.addElement("Seleccione");

        try (Connection con = getConnection();
             CallableStatement stmt = con.prepareCall("{call SP_OBTENER_HOTELES_DISPONIBLES(?)}")) {

             stmt.registerOutParameter(1, OracleTypes.CURSOR);
             stmt.execute();

             ResultSet rs = (ResultSet) stmt.getObject(1);
             while (rs.next()) {
                 listadoHoteles.addElement(rs.getString("NOMBRE"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    return listadoHoteles;
    }

  /**
   * METODO LISTAR RESERVAS
   * @param consulta
   * @return
   * Se eliminaron las variables sql y con innecesarias al utilizar los objetos directamente en el bloque try.
   */
    public static ResultSet ListarTabla(String consulta) {
        try {
        Connection con = getConnection();
        Statement sql = con.createStatement();
        return sql.executeQuery(consulta);
          } catch (SQLException e) {
            System.out.println(e);
        }
    return null;
    }
}
