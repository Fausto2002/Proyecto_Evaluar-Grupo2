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
 * @Grupo E
 */
public class CtrlVuelo implements ActionListener {

    //Variables
    private final Vuelo mod;
    private final ConsultasVuelo modV;
    private final frmVuelo frmV;
    private final frmModVuelo frmMod;

    //metodo constructor

  /**
   *
   * @param mod
   * @param modV
   * @param frmV
   * @param frmMod
   */
    public CtrlVuelo(Vuelo mod, ConsultasVuelo modV, frmVuelo frmV, frmModVuelo frmMod) {
        this.mod = mod;
        this.modV = modV;
        this.frmV = frmV;
        this.frmMod = frmMod;

        this.frmV.btnGuardar.addActionListener(this);
        this.frmMod.btnActualizar.addActionListener(this);
    }

  /**
   * inserta en el formulario el titulo
   */
  public void iniciar() {
        frmV.setTitle("Hoteles");
        frmV.setLocationRelativeTo(null);
    }

  /**
   *
   * @param texto
   * @return
   */
  public static boolean validarTexto(String texto) {
        String regex = "^[a-zA-Z]+$";
        return texto.matches(regex);
    }



  /**
   * BOTONES frmReserva
   * @param e
   * se han creado métodos auxiliares para verificar los campos incompletos 
   * y se han extraído las acciones de guardar y actualizar en métodos separados. 
   */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmV.btnGuardar) {
            if (areVueloFieldsIncomplete()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos antes de guardar.");
            } else {
                guardarVuelo();
            }
        }

        if (e.getSource() == frmMod.btnActualizar) {
            actualizarVuelo();
        }
    }

    private boolean areVueloFieldsIncomplete() {
        return frmV.txtOrigen.getText().isEmpty() || frmV.txtDestino.getText().isEmpty() || frmV.txtEscala.getText().isEmpty();
    }

    private void guardarVuelo() {
        mod.setNombreAerolinea((String) frmV.txtaerolinea.getSelectedItem());
        mod.setOrigen(frmV.txtOrigen.getText());
        mod.setDestino(frmV.txtDestino.getText());
        mod.setEscala(frmV.txtEscala.getText());
        mod.setDisponibilidad((String) frmV.txtDisponibilidad.getSelectedItem());

        try {
            if (modV.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
                Listar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex.getMessage());
        }
    }

    private void actualizarVuelo() {
        mod.setIdVuelo(Integer.parseInt(frmMod.txtIdVuelo.getText()));
        mod.setNombreAerolinea(frmMod.txtAerolinea.getText());
        mod.setOrigen(frmMod.txtOrigen.getText());
        mod.setDestino(frmMod.txtDestino.getText());
        mod.setEscala(frmMod.txtEscala.getText());
        mod.setDisponibilidad(frmMod.txtDisponibilidad.getText());

        if (modV.modificar(mod)) {
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
        frmV.txtOrigen.setText("");
        frmV.txtDestino.setText("");
        frmV.txtEscala.setText("");
    }

  /**
   * LISTAR en la interfaz de LISTAR VUELOS
   */
  public void Listar() {
        frmV.tblVuelo.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel md = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        frmV.tblVuelo.setRowHeight(20);
        JButton BOTONModificar = new JButton("Modificar");
        BOTONModificar.setName("m");
        JButton BOTONEliminar = new JButton("Eliminar");
        BOTONEliminar.setName("e");
//        BOTONEliminar.b
        ResultSet rs = ConsultasCliente.ListarTabla("select * from VUELO ORDER BY IDVUELO");
        md.setColumnIdentifiers(new Object[]{"ID", "Aerolinea", "Origen", "Destino", "Escala", "Disponibilidad", "", ""});
        try {
            while (rs.next()) {
                md.addRow(new Object[]{rs.getInt("IDVUELO"), rs.getString("NOMBREAEROLINEA"), rs.getString("ORIGEN"), rs.getString("DESTINO"),
                    rs.getString("ESCALA"), rs.getString("Disponibilidad"), BOTONModificar, BOTONEliminar});
                frmV.tblVuelo.setModel(md);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
