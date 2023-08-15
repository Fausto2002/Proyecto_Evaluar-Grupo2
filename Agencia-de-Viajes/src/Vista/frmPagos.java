package Vista;

import Controlador.*;
import static Modelo.Conexion.getConnection;
import Modelo.ConsultasReservas;
import Modelo.Reserva;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author staly
 */
public class frmPagos extends javax.swing.JFrame {

    String buscar_box;
    ConsultasReservas cr = new ConsultasReservas();

    /**
     * form pagos
     */
    public frmPagos() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        cb_buscar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 1010, 380));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 206, 1060, 460));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PAGOS ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        btnback.setBackground(new java.awt.Color(0, 102, 102));
        btnback.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        btnback.setBorder(null);
        btnback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel2.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        BuscarNuevo(txtBusqueda.getText());//llamando al metodo buscar
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped

        buscar_box = (String) cb_buscar.getSelectedItem();
        String txt = txtBusqueda.getText().trim();
        int maxLength = 80;

        switch (buscar_box) {
            case "Seleccione" ->
                vacio(evt, txt,0); // Limpiar el valor del campo de entrada
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
    }

    private void vacio(java.awt.event.KeyEvent evt, String txt, int maxLength) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txt.length() > 0 || !Character.isLetter(c)) {
            evt.consume();
        }
    }

    private CtrlPagos p;

    private void tblReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReservasMouseClicked
        Reserva reserva = new Reserva();
        ConsultasReservas consultasReservas = new ConsultasReservas();
        frmModReservas frmMod = new frmModReservas();
        Pagar pagar = new Pagar();

        int column = tblReservas.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblReservas.getRowHeight();
        if (row < tblReservas.getRowCount() && row >= 0 && column < tblReservas.getColumnCount() && column >= 0) {
            Object value = tblReservas.getValueAt(row, column);
            if (value instanceof JButton boton) {
                if (boton.getName().equals("p")) {
                    int seleccion = tblReservas.getSelectedRow();
                    pagar.lblmonto.setText(tblReservas.getValueAt(seleccion, 8).toString());
                    pagar.setVisible(true);
                }
                if (boton.getName().equals("e")) {
                    int fila = tblReservas.getSelectedRow();
                    String codigo = tblReservas.getValueAt(fila, 0).toString();
                    if (fila < 0) {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar un registro de la tabla", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        p.Listar();
                    }
                }
            }
        }
    }//GEN-LAST:event_tblReservasMouseClicked

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        MenuPrincipal men = new MenuPrincipal();
        this.setVisible(false);
        men.setVisible(true);
    }//GEN-LAST:event_btnbackActionPerformed

    /**
     *
     * @param buscar
     */
    public void BuscarNuevo(String buscar) {
        tblReservas.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblReservas.setRowHeight(20);
        JButton botonPagar = new JButton("Pagar");
        botonPagar.setName("p");

        String sql = "";
        String buscarBox = (String) cb_buscar.getSelectedItem();

        switch (buscarBox) {
            case "Cedula" -> sql = "{call listar_reservas_pre_aprobadas_cedula(?, ?)}";
            case "Hotel" -> sql = "{call listar_reservas_pre_aprobadas_hotel(?, ?)}";
            default -> throw new AssertionError();
        }

        model.setColumnIdentifiers(new Object[]{"IdReserva", "Cliente", "Cedula", "Hotel", "Habitaciones", "Personas", "Fecha Inicio", "Fecha Fin", "Precio Total", "Estado", "Boton"});
        Connection con = getConnection();
        try {
            CallableStatement stmt = con.prepareCall(sql);
            stmt.setString(1, buscar);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet rs = (ResultSet) stmt.getObject(2);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("IdReserva"), rs.getString("Cliente"), rs.getString("Cedula"), rs.getString("Hotel"),
                    rs.getInt("Habitaciones"), rs.getInt("Personas"), rs.getDate("FechaInicio"), rs.getDate("FechaFin"), rs.getDouble("PrecioTotal"), rs.getString("Estado"), botonPagar});
                tblReservas.setModel(model);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    public javax.swing.JComboBox<String> cb_buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable tblReservas;
    public javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
