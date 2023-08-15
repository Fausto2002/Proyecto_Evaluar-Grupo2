package Controlador;

import static Controlador.CtrlCliente.validarCedulatelefono;
import Modelo.*;
import Vista.frmReserva;
import Vista.frmModReservas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pc
 */
public class CtrlReservas implements ActionListener {

    //Variables
    private final Reserva r;
    private final ConsultasReservas cr;
    private final frmReserva frmR;
    private final frmModReservas frmMR;
 
  /**
   *
   * @param r
   * @param cr
   * @param frmR
   * @param frmMR
   */
  public CtrlReservas(Reserva r, ConsultasReservas cr, frmReserva frmR,frmModReservas frmMR) {
        this.r = r;
        this.cr = cr;
        this.frmR = frmR;
        this.frmMR = frmMR;

        this.frmR.btnReservar.addActionListener(this);
        this.frmMR.btnActualizar.addActionListener(this);

    }

  /**
   * inserta en el formulario el titulo
   */
  public void iniciar() {
        frmR.setTitle("Reservas");
        frmR.setLocationRelativeTo(null);
    }

   
    private boolean verificarCamposCompletos(JTextField[] campos) {
        for (JTextField campo : campos) {
            if (campo.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

  /**
   *
   * @param fechaSeleccionada
   * @return
   */
  public boolean validarFecha(Date fechaSeleccionada) {
        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Comparar las fechas
        if (fechaSeleccionada.after(fechaActual)) {
            // La fecha seleccionada es a futuro
            return true;
        } else {
            // La fecha seleccionada es anterior o igual a la fecha actual
            return false;
        }
    }

  /**
   * se han extraído los bloques de código relacionados a la validación de campos vacíos 
   * y fechas a métodos separados para mejorar la legibilidad y reutilización del código. 
   * @param e
   */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmR.btnReservar) {
            if (camposVacios() || !validarFechas()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos correctamente antes de Reservar.");
            } else {
                try {
                    r.setFechaInicio(frmR.dateFechaInicio.getDate());
                    r.setFechaFin(frmR.dateFechaFin.getDate());
                    r.setHotel((String) frmR.combohoteles.getSelectedItem());
                    r.setHabitaciones(Integer.parseInt(frmR.txtHabitaciones.getText()));
                    r.setPersonas(Integer.parseInt(frmR.txtPersonas.getText()));
                    r.setCliente(frmR.txtCliente.getText());
                    r.setCedula(frmR.txtcedula.getText());
                    r.setPrecioTotal(Double.parseDouble(frmR.txtPreciototal.getText()));
                    r.setEstado((String) frmR.txtEstado.getSelectedItem());

                    if (validarCedulatelefono(r.getCedula())) {
                        if (cr.registrar(r)) {
                            JOptionPane.showMessageDialog(null, "Reserva Realizada. ¡Tenga un buen día!");
                            limpiar();
                            Listar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al realizar la Reserva");
                        }
                    } else {
                        throw new CedulaInvalidaException();
                    }
                } catch (CedulaInvalidaException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if (e.getSource() == frmMR.btnActualizar) {
            if (camposCompletos() || !validarFechas()) {
                JOptionPane.showMessageDialog(null, "Por favor complete todos los campos antes de Reservar.");
            } else {
                try {
                    r.setIdReserva(Integer.parseInt(frmMR.txtIdReserva.getText()));
                    r.setFechaInicio(frmMR.dateFechaInicio.getDate());
                    r.setFechaFin(frmMR.dateFechaFin.getDate());
                    r.setHotel((String) frmMR.combohoteles.getSelectedItem());
                    r.setHabitaciones(Integer.parseInt(frmMR.txtHabitaciones.getText()));
                    r.setPersonas(Integer.parseInt(frmMR.txtPersonas.getText()));
                    r.setCliente(frmMR.txtCliente.getText());
                    r.setCedula(frmMR.txtcedula.getText());
                    r.setPrecioTotal(Double.parseDouble(frmMR.txtPreciototal.getText()));
                    r.setEstado(frmMR.txtEstado.getText());

                    if (cr.modificar(r)) {
                        JOptionPane.showMessageDialog(null, "Reserva Actualizada");
                        frmMR.setVisible(false);
                        Listar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al actualizar");
                    }
                } catch (NumberFormatException ex) {
                    try {
                        throw new ValorNoNumericoException();
                    } catch (ValorNoNumericoException ex1) {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }
            }
        }
    }

    private boolean camposVacios() {
        return frmR.dateFechaInicio.getDate() == null ||
                frmR.dateFechaFin.getDate() == null ||
                frmR.combohoteles.getSelectedItem().equals("Seleccione") ||
                frmR.txtHabitaciones.getText().isEmpty() ||
                frmR.txtPersonas.getText().isEmpty() ||
                frmR.txtCliente.getText().isEmpty() ||
                frmR.txtcedula.getText().isEmpty() ||
                frmR.txtPreciototal.getText().isEmpty();
    }

    private boolean camposCompletos() {
        return verificarCamposCompletos(new JTextField[]{frmMR.txtIdReserva, frmMR.txtHabitaciones,
                frmMR.txtPersonas, frmMR.txtCliente, frmMR.txtcedula,
                frmMR.txtPreciototal, frmMR.txtEstado}) ||
                frmMR.dateFechaInicio.getDate() == null ||
                frmMR.dateFechaFin.getDate() == null ||
                frmMR.combohoteles.getSelectedItem().equals("Sleccione");
    }

    private boolean validarFechas() {
        return validarFecha(frmR.dateFechaInicio.getDate()) && validarFecha(frmR.dateFechaFin.getDate());
    }

  /**
   * limpiar el formulario
   */
  public void limpiar() {
        frmR.combohoteles.setSelectedItem("Seleccione");
        frmR.txtHabitaciones.setText("");
        frmR.txtPersonas.setText("");
        frmR.txtCliente.setText("");
        frmR.txtcedula.setText("");
        frmR.txtPreciototal.setText("");
        frmR.dateFechaInicio.setDate(null);
        frmR.dateFechaFin.setDate(null);

    }

     //Listar 

  /**
   * Listar las reservas del bd
   */
    public void Listar() {
        frmR.tblReservas.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel md = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        frmR.tblReservas.setRowHeight(20);
        JButton BOTONModificar = new JButton("Modificar");
        BOTONModificar.setName("m");
        JButton BOTONEliminar = new JButton("Eliminar");
        BOTONEliminar.setName("e");

        ResultSet rs = ConsultasCliente.ListarTabla("select * from RESERVAS ORDER BY IDRESERVA");
        md.setColumnIdentifiers(new Object[]{"IdReserva", "Cliente", "Cedula", "Hotel", "Habitaciones", "Personas", "Fecha Inicio", "Fecha Fin", "Precio Total", "Estado", "", ""});
        try {
            while (rs.next()) {
                md.addRow(new Object[]{rs.getInt("IdReserva"), rs.getString("Cliente"), rs.getString("Cedula"), rs.getString("Hotel"),
                    rs.getInt("Habitaciones"), rs.getInt("Personas"), rs.getDate("FechaInicio"), rs.getDate("FechaFin"), rs.getDouble("PrecioTotal"), rs.getString("Estado"), BOTONModificar, BOTONEliminar});
                frmR.tblReservas.setModel(md);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
