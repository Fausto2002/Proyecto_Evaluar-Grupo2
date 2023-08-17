package Vista;

import Controlador.*;
import Controlador.Render;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */

public class frmVuelo extends javax.swing.JFrame {

    String buscar_box;

    /**
     * obtener datos de vuelo
     */
    public frmVuelo() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVuelo = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        cb_buscar = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEscala = new javax.swing.JTextField();
        txtOrigen = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtaerolinea = new javax.swing.JComboBox<>();
        txtDisponibilidad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        tblVuelo.setBackground(new java.awt.Color(255, 255, 255));
        tblVuelo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tblVuelo.setForeground(new java.awt.Color(0, 0, 0));
        tblVuelo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblVuelo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVueloMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblVuelo);

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        txtBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        txtBusqueda.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtBusqueda.setBorder(null);
        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });

        cb_buscar.setBackground(new java.awt.Color(255, 255, 255));
        cb_buscar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cb_buscar.setForeground(new java.awt.Color(0, 0, 0));
        cb_buscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Aerolinea", "Origen", "Destino" }));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 0, 710, 640));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Aerolinea:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 60, 20));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Destino:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 50, 20));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Disponibilidad:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 80, 20));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Origen:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 50, 20));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Escala:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 50, 20));

        txtEscala.setBackground(new java.awt.Color(204, 204, 204));
        txtEscala.setBorder(null);
        txtEscala.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEscalaKeyTyped(evt);
            }
        });
        jPanel2.add(txtEscala, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 250, 20));

        txtOrigen.setBackground(new java.awt.Color(204, 204, 204));
        txtOrigen.setBorder(null);
        txtOrigen.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOrigenKeyTyped(evt);
            }
        });
        jPanel2.add(txtOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 250, 20));

        txtDestino.setBackground(new java.awt.Color(204, 204, 204));
        txtDestino.setBorder(null);
        txtDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinoActionPerformed(evt);
            }
        });
        txtDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDestinoKeyTyped(evt);
            }
        });
        jPanel2.add(txtDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 250, 20));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 102, 102));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N
        btnGuardar.setText("REGISTRAR");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 130, 34));

        btnback.setBackground(new java.awt.Color(255, 255, 255));
        btnback.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        btnback.setBorder(null);
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel2.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("VUELOS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        txtaerolinea.setBackground(new java.awt.Color(204, 204, 204));
        txtaerolinea.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtaerolinea.setForeground(new java.awt.Color(0, 0, 0));
        txtaerolinea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aeroméxico", "Air Europa", "American Airlines", "Avianca", "Avianca Ecuador Internacional", "Conviasa", "COPA", "Delta Airlines" }));
        jPanel2.add(txtaerolinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        txtDisponibilidad.setBackground(new java.awt.Color(204, 204, 204));
        txtDisponibilidad.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDisponibilidad.setForeground(new java.awt.Color(0, 0, 0));
        txtDisponibilidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        jPanel2.add(txtDisponibilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        MenuPrincipal men= new MenuPrincipal();
        this.setVisible(false);
        men.setVisible(true);
    }//GEN-LAST:event_btnbackActionPerformed

    private void tblVueloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVueloMouseClicked
        Vuelo h = new Vuelo();
        ConsultasVuelo modV = new ConsultasVuelo();
        frmModVuelo frmMod= new frmModVuelo();
        CtrlVuelo ctrcl = new CtrlVuelo(h, modV, this, frmMod);
        int column=tblVuelo.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblVuelo.getRowHeight();
        if (row<tblVuelo.getRowCount() && row>= 0 && column<tblVuelo.getColumnCount() && column>=0) {
            Object value=tblVuelo.getValueAt(row, column);
            if (value instanceof JButton boton) {
                
                if (boton.getName().equals("m")) {
                    int seleccion=this.tblVuelo.getSelectedRow();
                    frmMod.txtIdVuelo.setText(tblVuelo.getValueAt(seleccion, 0).toString());
                    frmMod.txtAerolinea.setText(tblVuelo.getValueAt(seleccion, 1).toString());
                    frmMod.txtOrigen.setText(tblVuelo.getValueAt(seleccion,2).toString());
                    frmMod.txtDestino.setText(tblVuelo.getValueAt(seleccion,3).toString());
                    frmMod.txtEscala.setText(tblVuelo.getValueAt(seleccion, 4).toString());
                    frmMod.txtDisponibilidad.setText(tblVuelo.getValueAt(seleccion, 5).toString());
                    frmMod.setVisible(true);
                }
                if (boton.getName().equals("e")) {
                    int fila =this.tblVuelo.getSelectedRow();
                    String codigo=tblVuelo.getValueAt(fila, 0).toString();
                    if(fila<0){
                        JOptionPane.showMessageDialog(null, "Debe de seleccionar un registro de la tabla ","AVISO",JOptionPane.INFORMATION_MESSAGE);
                    }else{//caso contrario eliminar registro
                        ConsultasVuelo.Eliminar(codigo);
                        JOptionPane.showMessageDialog(null, "Registro Eliminado!");
                            ctrcl.Listar();
                        }
                    }
                }
            }
    }//GEN-LAST:event_tblVueloMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtOrigenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrigenKeyTyped
                textInput(evt, txtOrigen.getText(), 30);
    }//GEN-LAST:event_txtOrigenKeyTyped

    private void txtDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinoActionPerformed
    }//GEN-LAST:event_txtDestinoActionPerformed

    private void txtDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDestinoKeyTyped
        textInput(evt, txtDestino.getText(), 30);
    }//GEN-LAST:event_txtDestinoKeyTyped

    private void txtEscalaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEscalaKeyTyped
                textInput(evt, txtEscala.getText(), 30);
    }//GEN-LAST:event_txtEscalaKeyTyped

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        BuscarVuelo(txtBusqueda.getText());//llamando al metodo buscar
    }//GEN-LAST:event_txtBusquedaKeyReleased
  
    private void vacio(java.awt.event.KeyEvent evt, String txt, int maxLength) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txt.length() > 0 || !Character.isLetter(c)) {
            evt.consume();
        }
    }
  
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
    
    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        buscar_box = (String) cb_buscar.getSelectedItem();
        String txt = txtBusqueda.getText().trim();
        int maxLength = 80;

        switch (buscar_box) {
            case "Seleccione" -> vacio(evt, txt, maxLength); // 
            case "Aerolinea" -> textInput(evt, buscar_box, maxLength);
            case "Origen" -> textInput(evt, txt, maxLength);
            case "Destino" -> textInput(evt, txt, maxLength);
            default -> System.out.println("Error");
        }

        if (txtBusqueda.getText().length() >= maxLength) {
            evt.consume();
        }

        // Agregar ActionListener al JComboBox para limpiar el JTextField
        cb_buscar.addActionListener((ActionEvent e) -> {
          // Limpiar el contenido del JTextField
          txtBusqueda.setText("");
        });
    }//GEN-LAST:event_txtBusquedaKeyTyped
    


//Buscar solo con el txtfield sin usar boton

    /**
     *
     * @param buscar
     */
   
   public void BuscarVuelo(String buscar) {
        this.tblVuelo.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel md = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                                return false;
                            }
        };
        this.tblVuelo.setRowHeight(20);
        JButton BOTONModificar= new JButton("Modificar");
        BOTONModificar.setName("m");
        JButton BOTONEliminar= new JButton("Eliminar");
        BOTONEliminar.setName("e");
        
        
        String sql = "";
        buscar_box=(String)cb_buscar.getSelectedItem();
        switch (buscar_box) {
            case "Aerolinea" -> sql = "Select*from VUELO where NOMBREAEROLINEA like'" + buscar + "%'ORDER BY IDVUELO";
            case "Origen" -> sql = "Select*from VUELO where ORIGEN like'%" + buscar + "%' ORDER BY IDVUELO";
            case "Destino" -> sql = "Select*from VUELO where DESTINO like'%" + buscar + "%' ORDER BY IDVUELO";
            default -> {
            }
        }
        ResultSet rs = ConsultasCliente.ListarTabla(sql);
        md.setColumnIdentifiers(new Object[]{"ID", "Aerolinea", "Origen", "Destino", "Escala", "Disponibilidad","",""});
        try {
            while (rs.next()) {
                md.addRow(new Object[]{rs.getInt("IDVUELO"), rs.getString("NOMBREAEROLINEA"), rs.getString("ORIGEN"), rs.getString("DESTINO"),
                    rs.getString("ESCALA"), rs.getString("Disponibilidad"),BOTONModificar,BOTONEliminar});
                this.tblVuelo.setModel(md);
            }
        } catch (Exception e) {
            System.out.println(e);
        }   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnback;
    private javax.swing.JComboBox<String> cb_buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable tblVuelo;
    public javax.swing.JTextField txtBusqueda;
    public javax.swing.JTextField txtDestino;
    public javax.swing.JComboBox<String> txtDisponibilidad;
    public javax.swing.JTextField txtEscala;
    public javax.swing.JTextField txtOrigen;
    public javax.swing.JComboBox<String> txtaerolinea;
    // End of variables declaration//GEN-END:variables
}
