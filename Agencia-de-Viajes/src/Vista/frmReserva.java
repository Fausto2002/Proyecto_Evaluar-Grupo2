package Vista;

import Controlador.*;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author staly
 */
public class frmReserva extends javax.swing.JFrame {

    String buscar_box;
    ConsultasReservas cr = new ConsultasReservas();

    /**
     * obtener el formulario reserva
     */
    public frmReserva() {
        initComponents();
        this.combohoteles.setModel(cr.obtenerNombresHoteles());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        cb_buscar = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnReservar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtPreciototal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dateFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        dateFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        txtPersonas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtHabitaciones = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        txtEstado = new javax.swing.JComboBox<>();
        combohoteles = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblReservas.setBackground(new java.awt.Color(255, 255, 255));
        tblReservas.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tblReservas.setForeground(new java.awt.Color(0, 0, 0));
        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReservasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblReservas);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 104, 751, 215));

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Busqueda ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        txtBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        txtBusqueda.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        txtBusqueda.setBorder(null);
        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });

        cb_buscar.setBackground(new java.awt.Color(255, 255, 255));
        cb_buscar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cb_buscar.setForeground(new java.awt.Color(0, 0, 0));
        cb_buscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Cedula", "Hotel" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(cb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 15, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 0, 780, 640));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReservar.setBackground(new java.awt.Color(255, 255, 255));
        btnReservar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnReservar.setForeground(new java.awt.Color(0, 102, 102));
        btnReservar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N
        btnReservar.setText("RESERVAR");
        btnReservar.setBorder(null);
        btnReservar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });
        jPanel2.add(btnReservar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 130, 34));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Estado :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 50, 20));

        txtPreciototal.setBackground(new java.awt.Color(204, 204, 204));
        txtPreciototal.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtPreciototal.setBorder(null);
        txtPreciototal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPreciototalActionPerformed(evt);
            }
        });
        txtPreciototal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPreciototalKeyTyped(evt);
            }
        });
        jPanel2.add(txtPreciototal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 250, 20));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Precio Total :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 80, 20));

        dateFechaFin.setBackground(new java.awt.Color(204, 204, 204));
        dateFechaFin.setForeground(new java.awt.Color(0, 0, 0));
        dateFechaFin.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel2.add(dateFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 150, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Fecha de Fin :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 80, 20));

        dateFechaInicio.setBackground(new java.awt.Color(204, 204, 204));
        dateFechaInicio.setForeground(new java.awt.Color(0, 0, 0));
        dateFechaInicio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel2.add(dateFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 150, -1));

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Fecha de Inicio :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 90, 20));

        txtPersonas.setBackground(new java.awt.Color(204, 204, 204));
        txtPersonas.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtPersonas.setBorder(null);
        txtPersonas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPersonasKeyTyped(evt);
            }
        });
        jPanel2.add(txtPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 250, 20));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Personas :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 60, 20));

        txtHabitaciones.setBackground(new java.awt.Color(204, 204, 204));
        txtHabitaciones.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtHabitaciones.setBorder(null);
        txtHabitaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHabitacionesKeyTyped(evt);
            }
        });
        jPanel2.add(txtHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 250, 20));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Habitaciones :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 80, 20));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Hotel :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 40, 20));

        txtcedula.setBackground(new java.awt.Color(204, 204, 204));
        txtcedula.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtcedula.setBorder(null);
        txtcedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaActionPerformed(evt);
            }
        });
        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });
        jPanel2.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 250, 20));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Cedula :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 50, 20));

        txtCliente.setBackground(new java.awt.Color(204, 204, 204));
        txtCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCliente.setBorder(null);
        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteKeyTyped(evt);
            }
        });
        jPanel2.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 250, 20));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Cliente :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 50, 20));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("RESERVAS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 195, -1));

        btnback.setBackground(new java.awt.Color(255, 255, 255));
        btnback.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        btnback.setBorder(null);
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel2.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        txtEstado.setBackground(new java.awt.Color(204, 204, 204));
        txtEstado.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtEstado.setForeground(new java.awt.Color(0, 0, 0));
        txtEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRE-APROBADA", "ACEPTADA" }));
        jPanel2.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, -1));

        combohoteles.setMaximumRowCount(10);
        combohoteles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jPanel2.add(combohoteles, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyTyped
        textInput(evt, txtCliente.getText(), 30);
    }//GEN-LAST:event_txtClienteKeyTyped

    private void txtcedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaActionPerformed

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
        cedulaInput(evt, txtcedula.getText(), 10);
    }//GEN-LAST:event_txtcedulaKeyTyped

    private void txtPreciototalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPreciototalKeyTyped
        char c = evt.getKeyChar();
        String telefono = txtPreciototal.getText().trim();
        if (!Character.isDigit(c) || telefono.length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPreciototalKeyTyped

    private void txtPersonasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonasKeyTyped
        char c = evt.getKeyChar();
        String telefono = txtPreciototal.getText().trim();
        if (!Character.isDigit(c) || telefono.length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPersonasKeyTyped


    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed

    }//GEN-LAST:event_btnReservarActionPerformed

    private void txtHabitacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHabitacionesKeyTyped
        char c = evt.getKeyChar();
        String telefono = txtPreciototal.getText().trim();
        if (!Character.isDigit(c) || telefono.length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txtHabitacionesKeyTyped

    private void tblReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReservasMouseClicked
        Reserva r = new Reserva();
        ConsultasReservas modR = new ConsultasReservas();
        frmModReservas frmMod = new frmModReservas();
        CtrlReservas ctrlR = new CtrlReservas(r, modR, this, frmMod);
        int column = tblReservas.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblReservas.getRowHeight();
        if (row < tblReservas.getRowCount() && row >= 0 && column < tblReservas.getColumnCount() && column >= 0) {
            Object value = tblReservas.getValueAt(row, column);
            if (value instanceof JButton boton) {

                if (boton.getName().equals("m")) {
                    int seleccion = this.tblReservas.getSelectedRow();
                    frmMod.txtIdReserva.setText(tblReservas.getValueAt(seleccion, 0).toString());
                    frmMod.txtCliente.setText(tblReservas.getValueAt(seleccion, 1).toString());
                    frmMod.txtcedula.setText(tblReservas.getValueAt(seleccion, 2).toString());
                    frmMod.combohoteles.setSelectedItem(tblReservas.getValueAt(seleccion, 3).toString());
                    frmMod.txtHabitaciones.setText(tblReservas.getValueAt(seleccion, 4).toString());
                    frmMod.txtPersonas.setText(tblReservas.getValueAt(seleccion, 5).toString());

                    // Obtener el valor de la tabla como un objeto
                    Object valorTabla = tblReservas.getValueAt(seleccion, 6);
                    Object valorTabla1 = tblReservas.getValueAt(seleccion, 7);
                    // Convertir el valor de la tabla a un objeto Date
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    Date fecha = null;
                    Date fecha1 = null;
                    try {
                        fecha = formatoFecha.parse(valorTabla.toString());
                        fecha1 = formatoFecha.parse(valorTabla1.toString());
                    } catch (ParseException ex) {
                        // Manejo de excepción en caso de que la conversión falle
                        ex.printStackTrace();
                    }
                    // Establecer la fecha en el JDateChooser
                    frmMod.dateFechaInicio.setDate(fecha);
                    frmMod.dateFechaFin.setDate(fecha1);
                    frmMod.txtPreciototal.setText(tblReservas.getValueAt(seleccion, 8).toString());
                    frmMod.txtEstado.setText(tblReservas.getValueAt(seleccion, 9).toString());
                    frmMod.setVisible(true);
                }
                if (boton.getName().equals("e")) {
                    int fila = this.tblReservas.getSelectedRow();
                    String codigo = tblReservas.getValueAt(fila, 0).toString();
                    if (fila < 0) {
                        JOptionPane.showMessageDialog(null, "Debe de seleccionar un registro de la tabla ", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                    } else {//caso contrario eliminar registro
                        ConsultasReservas.Eliminar(codigo);
                        JOptionPane.showMessageDialog(null, "Registro Eliminado!");
                        ctrlR.Listar();
                    }
                }
            }
        }
    }//GEN-LAST:event_tblReservasMouseClicked

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        BuscarNuevo(txtBusqueda.getText());//llamando al metodo buscar
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void vacio(java.awt.event.KeyEvent evt, String txt, int maxLength) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txt.length() > 0 || !Character.isLetter(c)) {
            evt.consume();
        }
    }
    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped

        buscar_box = (String) cb_buscar.getSelectedItem();
        String txt = txtBusqueda.getText().trim();
        int maxLength = 80;

        switch (buscar_box) {
            case "Seleccione" ->
                vacio(evt, txt, maxLength); // Limpiar el valor del campo de entrada
            case "Cedula" ->
                cedulaInput(evt, txt, 10);
            case "Hotel" ->
                textInput(evt, txt, maxLength);
            default ->
                System.out.println("Error");
        }

        // Agregar ActionListener al JComboBox para limpiar el JTextField
        cb_buscar.addActionListener((ActionEvent e) -> {
          // Limpiar el contenido del JTextField
          txtBusqueda.setText("");
        });
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        MenuPrincipal men = new MenuPrincipal();
        this.setVisible(false);
        men.setVisible(true);
    }//GEN-LAST:event_btnbackActionPerformed

    private void txtPreciototalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPreciototalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPreciototalActionPerformed
    private void cedulaInput(java.awt.event.KeyEvent evt, String txt, int maxLength) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txt.length() >= 10) {
            evt.consume();
        }
        if (txt.length() >= 10) {
            evt.consume();
        }
    }

    private void textInput(java.awt.event.KeyEvent evt, String txt, int maxLength) {
        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
        if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
            evt.consume();
        }
        if (txt.length() >= maxLength) {
            evt.consume();
        }
    }//buscar solo con el txtfield sin usar boton

    /**
     *
     * @param buscar
     */
    public void BuscarNuevo(String buscar) {
        this.tblReservas.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel md = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tblReservas.setRowHeight(20);
        JButton BOTONModificar = new JButton("Modificar");
        BOTONModificar.setName("m");
        JButton BOTONEliminar = new JButton("Eliminar");
        BOTONEliminar.setName("e");

        String sql = "";
        buscar_box = (String) cb_buscar.getSelectedItem();
        if (buscar_box.equals("Cedula")) {
            sql = "Select*from RESERVAS where CEDULA like'" + buscar + "%'ORDER BY IDRESERVA";
        } else if (buscar_box.equals("Hotel")) {
            sql = "Select*from RESERVAS where HOTEL like'%" + buscar + "%' ORDER BY IDRESERVA";
        }
        ResultSet rs = ConsultasCliente.ListarTabla(sql);
        md.setColumnIdentifiers(new Object[]{"IdReserva", "Cliente", "Cedula", "Hotel", "Habitaciones", "Personas", "Fecha Inicio", "Fecha Fin", "Precio Total", "Estado", "", ""});
        try {
            while (rs.next()) {
                md.addRow(new Object[]{rs.getInt("IdReserva"), rs.getString("Cliente"), rs.getString("Cedula"), rs.getString("Hotel"),
                    rs.getInt("Habitaciones"), rs.getInt("Personas"), rs.getDate("FechaInicio"), rs.getDate("FechaFin"), rs.getDouble("PrecioTotal"), rs.getString("Estado"), BOTONModificar, BOTONEliminar});
                this.tblReservas.setModel(md);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnReservar;
    private javax.swing.JButton btnback;
    public javax.swing.JComboBox<String> cb_buscar;
    public javax.swing.JComboBox<String> combohoteles;
    public com.toedter.calendar.JDateChooser dateFechaFin;
    public com.toedter.calendar.JDateChooser dateFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable tblReservas;
    public javax.swing.JTextField txtBusqueda;
    public javax.swing.JTextField txtCliente;
    public javax.swing.JComboBox<String> txtEstado;
    public javax.swing.JTextField txtHabitaciones;
    public javax.swing.JTextField txtPersonas;
    public javax.swing.JTextField txtPreciototal;
    public javax.swing.JTextField txtcedula;
    // End of variables declaration//GEN-END:variables
}
