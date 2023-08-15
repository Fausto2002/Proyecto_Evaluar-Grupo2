
package Controlador;

import Modelo.ConsultasCliente;
import Vista.frmCliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import org.junit.Test;

/**
 *
 * @author staly
 */
public class CtrlClienteTest {
    frmCliente frmC= new frmCliente();

  /**
   * vista
   */
  public CtrlClienteTest() {
    }

  /**
   * consulta de clientes
   */
  @Test
    public void testListar() {
        frmC.tblCliente.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel md = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                                return false;
                            }
        };
        frmC.tblCliente.setRowHeight(20);
        JButton BOTONModificar= new JButton("Modificar");
        BOTONModificar.setName("m");
        JButton BOTONEliminar= new JButton("Eliminar");
        BOTONEliminar.setName("e");
        ResultSet rs = ConsultasCliente.ListarTabla("select * from CLIENTE");
        md.setColumnIdentifiers(new Object[]{"Id", "Cedula", "Nombres", "Apellidos", "Telefono", "Direccion", "Email", "",""});
        try {
            while (rs.next()) {
                md.addRow(new Object[]{rs.getInt("id"), rs.getString("Cedula"), rs.getString("Nombres"), rs.getString("Apellidos"),
                    rs.getString("Telefono"), rs.getString("Direccion"), rs.getString("Email"),BOTONModificar,BOTONEliminar});
                frmC.tblCliente.setModel(md);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    }
