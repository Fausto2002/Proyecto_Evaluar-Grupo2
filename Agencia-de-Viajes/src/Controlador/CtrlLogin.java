package Controlador;

import java.sql.*;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;

/**
 *
 * @author staly
 */
    public class CtrlLogin implements ActionListener {
        private final ConsultasLogin consultasLogin;
        private final FrmLogin frmLogin;

        public CtrlLogin(ConsultasLogin consultasLogin, FrmLogin frmLogin, Usuario usuario) {
            this.consultasLogin = consultasLogin;
            this.frmLogin = frmLogin;

            this.frmLogin.btnEntrar.addActionListener(this);
            this.frmLogin.btnCancelar.addActionListener(this);
        }

        public void iniciar() {
            frmLogin.setTitle("LOGIN");
            frmLogin.setLocationRelativeTo(null);
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == frmLogin.btnEntrar) {
                String usuario = frmLogin.txtUsuario.getText();
                String clave = frmLogin.txtContraseña.getText();

                try {
                    if (usuario.isEmpty() || clave.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Llene ambos campos");
                    } else {
                        boolean valido = consultasLogin.validarUsuario(usuario, clave);
                        if (valido) {
                            frmLogin.mostrarMensaje("¡Bienvenido " + usuario + "!");
                            frmLogin.cerrarVentana();
                        } else {
                            frmLogin.mostrarMensaje("Credenciales incorrectas");
                        }
                    }
                } catch (SQLException ex) {
                    frmLogin.mostrarMensaje("Error al conectar a la base de datos");
                }
            }
        }
    }
