package Vista;

import Controlador.*;
import Modelo.*;
import Modelo.ConsultasCliente;
import Modelo.Cliente;
import javax.swing.JOptionPane;
import java.sql.*;
import static Modelo.Conexion.getConnection;
import Modelo.ConsultasCliente;

/**
 *
 * @author hp
 */
public class MenuPrincipal extends javax.swing.JFrame {

    FrmLogin frml = new FrmLogin();
    ConsultasCliente ccl = new ConsultasCliente();
    Connection con = getConnection();
    Usuario user = new Usuario();

    /**
     * inica menu principal
     */
    public MenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        menuHoteles = new javax.swing.JButton();
        menuReservas = new javax.swing.JButton();
        menuCliente = new javax.swing.JButton();
        menuVuelos1 = new javax.swing.JButton();
        buttonPagos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "OPCIONES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        menuHoteles.setBackground(new java.awt.Color(91, 133, 162));
        menuHoteles.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        menuHoteles.setForeground(new java.awt.Color(255, 255, 255));
        menuHoteles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/hotel.png"))); // NOI18N
        menuHoteles.setText("HOTELES");
        menuHoteles.setBorder(null);
        menuHoteles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuHoteles.setIconTextGap(20);
        menuHoteles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHotelesActionPerformed(evt);
            }
        });

        menuReservas.setBackground(new java.awt.Color(91, 133, 162));
        menuReservas.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        menuReservas.setForeground(new java.awt.Color(255, 255, 255));
        menuReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reserva.png"))); // NOI18N
        menuReservas.setText("RESERVAS");
        menuReservas.setBorder(null);
        menuReservas.setIconTextGap(20);
        menuReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReservasActionPerformed(evt);
            }
        });

        menuCliente.setBackground(new java.awt.Color(91, 133, 162));
        menuCliente.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        menuCliente.setForeground(new java.awt.Color(255, 255, 255));
        menuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clientes.png"))); // NOI18N
        menuCliente.setText("CLIENTES");
        menuCliente.setBorder(null);
        menuCliente.setIconTextGap(20);
        menuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClienteActionPerformed(evt);
            }
        });

        menuVuelos1.setBackground(new java.awt.Color(91, 133, 162));
        menuVuelos1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        menuVuelos1.setForeground(new java.awt.Color(255, 255, 255));
        menuVuelos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vuelo.png"))); // NOI18N
        menuVuelos1.setText("VUELOS");
        menuVuelos1.setBorder(null);
        menuVuelos1.setIconTextGap(20);
        menuVuelos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVuelos1ActionPerformed(evt);
            }
        });

        buttonPagos.setBackground(new java.awt.Color(91, 133, 162));
        buttonPagos.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        buttonPagos.setForeground(new java.awt.Color(255, 255, 255));
        buttonPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pago.png"))); // NOI18N
        buttonPagos.setText("PAGOS");
        buttonPagos.setBorder(null);
        buttonPagos.setIconTextGap(20);
        buttonPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPagosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(194, 194, 194)
                            .addComponent(menuCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(menuHoteles, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(menuVuelos1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(menuCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menuHoteles, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menuVuelos1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menuReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        lbluser.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbluser.setForeground(new java.awt.Color(0, 0, 0));
        lbluser.setText("Administrador");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jButton1)))
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbluser)
                .addGap(71, 71, 71))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbluser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void menuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClienteActionPerformed
        Cliente c = new Cliente();
        ConsultasCliente modC = new ConsultasCliente();
        frmCliente frmC = new frmCliente();
        frmModCliente frmMod = new frmModCliente();
        CtrlCliente ctrlc = new CtrlCliente(c, modC, frmC, frmMod);
        ctrlc.iniciar();
        this.setVisible(false);
        frmC.setVisible(true);
        ctrlc.Listar();
    }//GEN-LAST:event_menuClienteActionPerformed

    private void menuHotelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHotelesActionPerformed
        Hotel h = new Hotel();
        ConsultasHotel modH = new ConsultasHotel();
        frmHotel frmH = new frmHotel();
        frmModHotel frmMod = new frmModHotel();
        CtrlHotel ctrlc = new CtrlHotel(h, modH, frmH, frmMod);
        ctrlc.iniciar();
        this.setVisible(false);
        frmH.setVisible(true);
        ctrlc.Listar();
    }//GEN-LAST:event_menuHotelesActionPerformed

    private void menuReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReservasActionPerformed
        Reserva r = new Reserva();
        ConsultasReservas modR = new ConsultasReservas();
        frmReserva frmR = new frmReserva();
        frmModReservas frmMod = new frmModReservas();
        CtrlReservas ctrlR = new CtrlReservas(r, modR, frmR, frmMod);
        ctrlR.iniciar();
        this.setVisible(false);
        frmR.setVisible(true);
        ctrlR.Listar();
    }//GEN-LAST:event_menuReservasActionPerformed

    private void menuVuelos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVuelos1ActionPerformed
        Vuelo v = new Vuelo();
        ConsultasVuelo modV = new ConsultasVuelo();
        frmVuelo frmV = new frmVuelo();
        frmModVuelo frmVuelo = new frmModVuelo();
        CtrlVuelo ctrlV = new CtrlVuelo(v, modV, frmV, frmVuelo);

        ctrlV.iniciar();
        this.setVisible(false);
        frmV.setVisible(true);
        ctrlV.Listar();
    }//GEN-LAST:event_menuVuelos1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmLogin log = new FrmLogin();
        this.setVisible(false);
        log.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPagosActionPerformed
        frmPagos frmp = new frmPagos();
        Pagar p = new Pagar();
        CtrlPagos pa = new CtrlPagos(frmp,p);
        this.setVisible(false);
        frmp.setVisible(true);
        pa.Listar();
    }//GEN-LAST:event_buttonPagosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPagos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lbluser;
    private javax.swing.JButton menuCliente;
    private javax.swing.JButton menuHoteles;
    private javax.swing.JButton menuReservas;
    private javax.swing.JButton menuVuelos1;
    // End of variables declaration//GEN-END:variables
}
