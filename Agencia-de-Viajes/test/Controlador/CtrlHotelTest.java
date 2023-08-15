
package Controlador;

import Modelo.ConsultasCliente;
import Modelo.ConsultasHotel;
import Modelo.Hotel;
import Vista.frmHotel;
import Vista.frmModHotel;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import org.junit.Test;

/**
 *
 * @author staly
 */
public class CtrlHotelTest {
     Hotel mod= new Hotel();
     ConsultasHotel modH = new ConsultasHotel();
     frmHotel frmH= new frmHotel();
     frmModHotel frmMod= new frmModHotel();
     ActionEvent e;

  /**
   * vista
   */
  public CtrlHotelTest() {
    }

  /**
   * consulta de hotel
   */
  @Test
    public void testListar() {
        frmH.tblHotel.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel md = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                                return false;
                            }
        };
        frmH.tblHotel.setRowHeight(20);
        JButton BOTONModificar= new JButton("Modificar");
        BOTONModificar.setName("m");
        JButton BOTONEliminar= new JButton("Eliminar");
        BOTONEliminar.setName("e");
        ResultSet rs = ConsultasCliente.ListarTabla("select * from HOTEL ORDER BY IDHOTEL");
        md.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Ubicacion", "Telefono", "Disponibilidad", "Servicios","",""});
        try {
            while (rs.next()) {
                md.addRow(new Object[]{rs.getInt("IDHOTEL"), rs.getString("Nombre"), rs.getString("Ubicacion"), rs.getString("Telefono"),
                    rs.getString("Disponibilidad"), rs.getString("Servicios"),BOTONModificar,BOTONEliminar});
                frmH.tblHotel.setModel(md);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
}
