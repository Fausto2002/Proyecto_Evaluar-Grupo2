package Controlador;

import java.sql.*;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author staly
 */
public class CtrlHotel implements ActionListener {
    //Variables
    private final Hotel mod;
    private final ConsultasHotel modH;
    private final frmHotel frmH;
    private final frmModHotel frmMod;
  /**
   * metodo constructor
   * @param mod
   * @param modH
   * @param frmH
   * @param frmMod
   */
    @SuppressWarnings("LeakingThisInConstructor")
    public CtrlHotel(Hotel mod, ConsultasHotel modH, frmHotel frmH, frmModHotel frmMod) {
        this.mod = mod;
        this.modH = modH;
        this.frmH = frmH;
        this.frmMod = frmMod;
        this.frmH.btnGuardar.addActionListener(this);
        this.frmMod.btnActualizar.addActionListener(this);
    }
  /**
   * busca el titulo del hotel
   */
  public void iniciar() {
        frmH.setTitle("Hoteles");
        frmH.setLocationRelativeTo(null);
    }
  /**
   * Validar numero de cedula
   * @param telefono
   * @return
   */
    public static boolean validarCedulatelefono(String telefono) {
        String regex = "^[0-9]{10}$";
        return telefono.matches(regex);
    }

  /**
   *Botones Hoteles
   * @param e
   */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmH.btnGuardar) {
            guardarHotel();
        }
        if (e.getSource() == frmMod.btnActualizar) {
            actualizarHotel();
        }
    }
    private void guardarHotel() {
        mod.setNombre(frmH.txtNombre.getText());
        mod.setUbicacion(frmH.txtUbicacion.getText());
        mod.setTelefono(frmH.txtTelefono.getText());
        mod.setDisponibilidad((String) frmH.txtDisponibilidad.getSelectedItem());
        mod.setServicios(frmH.txtServicios.getText());
        String telefono = frmH.txtTelefono.getText().trim();

        try {
            if (validarCedulatelefono(telefono)) {
                if (modH.registrar(mod)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                    Listar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Revise si los datos ingresados son correctos");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex.getMessage());
        }
    }

    private void actualizarHotel() {
        mod.setIdHotel(Integer.parseInt(frmMod.txtIdHotel.getText()));
        mod.setNombre(frmMod.txtNombre.getText());
        mod.setUbicacion(frmMod.txtUbicacion.getText());
        mod.setTelefono(frmMod.txtTelefono.getText());
        mod.setDisponibilidad(frmMod.txtDisponibilidad.getText());
        mod.setServicios(frmMod.txtServicios.getText());

        if (modH.modificar(mod)) {
            JOptionPane.showMessageDialog(null, "Registro Actualizado");
            frmMod.setVisible(false);
            Listar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
    }

  /**
   * Limpiar el formulario
   */
  public void limpiar() {
        frmH.txtNombre.setText("");
        frmH.txtUbicacion.setText("");
        frmH.txtTelefono.setText("");
        frmH.txtServicios.setText("");
    }
    
  /**
   * LISTAR los hoteles
   */
    public void Listar() {
        frmH.tblHotel.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel md = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        frmH.tblHotel.setRowHeight(20);
        JButton BOTONModificar = new JButton("Modificar");
        BOTONModificar.setName("m");
        JButton BOTONEliminar = new JButton("Eliminar");
        BOTONEliminar.setName("e");
        ResultSet rs = ConsultasCliente.ListarTabla("select * from HOTEL ORDER BY IDHOTEL");
        md.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Ubicacion", "Telefono", "Disponibilidad", "Servicios", "", ""});
        try {
            while (rs.next()) {
                md.addRow(new Object[]{rs.getInt("IDHOTEL"), rs.getString("Nombre"), rs.getString("Ubicacion"), rs.getString("Telefono"),
                    rs.getString("Disponibilidad"), rs.getString("Servicios"), BOTONModificar, BOTONEliminar});
                frmH.tblHotel.setModel(md);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
