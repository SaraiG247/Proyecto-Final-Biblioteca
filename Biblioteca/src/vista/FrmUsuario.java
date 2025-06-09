/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import VALIDACION.Validacion;
import utilidades.DimencionImagen;
import controlador.UsuarioControlador;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import modelo.Usuario;
import java.sql.Connection;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import utilidades.ConexionDB;
import utilidades.EnviarCorreo;
import utilidades.GeneradorPDF;

/**
 *
 * @author Sarai
 */
public class FrmUsuario extends javax.swing.JFrame {

    VerUsuarios usuarios = new VerUsuarios();
    private boolean modoEdicion = false;
    private String correoOriginal; // Para saber qué libro se está editando

    /**
     * CONSTRUCTOR DE FRMUSUARIO
     */
    public FrmUsuario() {
        initComponents();
        inicializarComboTipoUsuario(comboTipoU);

    }

    //METODOS PARA LA CLASE
    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;

        if (modoEdicion) {
            btnAceptar.setText("Guardar");
            txtCorreo.setEnabled(false);// Cambiar texto del botón
        } else {
            btnAceptar.setText("Agregar");
        }
    }

    public void setDatosUsuario(String nombres, String apellidos, String telefono,
            String correo, String tipoUsuario) {
        txtNom.setText(nombres);
        txtAp.setText(apellidos);
        txtTel.setText(telefono);
        txtCorreo.setText(String.valueOf(correo));
        comboTipoU.setSelectedItem(tipoUsuario);

        this.correoOriginal = correo;
    }

    private void limpiarCampos() {
        txtNom.setText("");
        txtAp.setText("");
        txtTel.setText("");
        txtCorreo.setText("");
        comboTipoU.setSelectedIndex(0);
    }

    public static void inicializarComboTipoUsuario(JComboBox<String> combo) {
        combo.removeAllItems();
        try {
            Connection conexion = ConexionDB.getConexion();
            UsuarioControlador controlador = new UsuarioControlador(conexion);
            for (String rol : controlador.obtenerNombresRoles()) {
                combo.addItem(rol);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar roles: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUser = new javax.swing.JPanel();
        txtNom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        comboTipoU = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 142, 142), 2));
        panelUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });
        panelUser.add(txtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 257, -1));

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 142, 142));
        jLabel1.setText("NUEVO USUARIO");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelUser.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 24, 165, -1));

        jLabel2.setText("Nombres");
        panelUser.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel3.setText("Apellidos");
        panelUser.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));
        panelUser.add(txtAp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 257, -1));

        jLabel4.setText("Telefono");
        panelUser.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));
        panelUser.add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 257, -1));

        jLabel5.setText("Correo");
        panelUser.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, -1));
        panelUser.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 257, -1));

        jLabel7.setText("Rol");
        panelUser.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        btnAceptar.setText("Agregar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelUser.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        comboTipoU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTipoU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoUActionPerformed(evt);
            }
        });
        panelUser.add(comboTipoU, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 257, 30));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.setToolTipText("");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelUser.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, -1, -1));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        panelUser.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelUser.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, -1, -1));

        getContentPane().add(panelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboTipoUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoUActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        System.out.println("Boton Agregar");

        if (!Validacion.validarNoVacio(txtNom.getText())
                || !Validacion.validarNoVacio(txtAp.getText())
                || !Validacion.validarNoVacio(txtCorreo.getText())
                || !Validacion.validarNoVacio(txtTel.getText())) {
            JOptionPane.showMessageDialog(this, "Rellena todos los campos.");
            return;
        }

        if (!Validacion.validarSoloLetras(txtNom.getText())
                || !Validacion.validarSoloLetras(txtAp.getText())) {
            JOptionPane.showMessageDialog(this, "Ingrese únicamente letras en campos Nombre y Apellidos.");
            return;
        }

        if (!Validacion.validarSoloNumeros(txtTel.getText())) {
            JOptionPane.showMessageDialog(this, "Ingrese únicamente números en el campo Teléfono.");
            return;
        }

        if (!Validacion.validacionCorreo(txtCorreo.getText())) {
            JOptionPane.showMessageDialog(this, "Formato de Correo incorrecto.");
            return;
        }

        try {
            Connection conexion = ConexionDB.getConexion();
            UsuarioControlador controlador = new UsuarioControlador(conexion);

            Usuario usuario = new Usuario();
            usuario.setNombre(txtNom.getText());
            usuario.setApellidos(txtAp.getText());
            usuario.setTelefono(txtTel.getText());
            usuario.setCorreo(txtCorreo.getText());
            usuario.setRol(comboTipoU.getSelectedItem().toString());

            if (modoEdicion) {
                if (controlador.actualizar(usuario)) {
                    JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.");
                    usuarios.cargarUsuariosEnTabla();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar el usuario.");
                }
            } else {
                String contrasenaGenerada = controlador.insertar(usuario);
                if (contrasenaGenerada != null) {
                    // Mostrar credenciales con JOptionPane
                    String mensaje = "Usuario agregado correctamente.\n\n"
                            + "Credenciales generadas:\n"
                            + "Correo: " + usuario.getCorreo() + "\n"
                            + "Contraseña: " + contrasenaGenerada + "\n\n"
                            + "¿Desea enviar las credenciales por correo electrónico?";

                    int opcion = JOptionPane.showConfirmDialog(
                            this,
                            mensaje,
                            "Credenciales Generadas",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );

                    if (opcion == JOptionPane.YES_OPTION) {
                        // Generar el PDF con las credenciales
                        try {
                            File pdf = GeneradorPDF.generarCredencialesPDF(usuario.getCorreo(), contrasenaGenerada);

                            // Abrir FrmEnviarCorreo con el correo del usuario ya establecido
                            FrmEnviarCorreo frmEnviarCorreo = new FrmEnviarCorreo();
                            frmEnviarCorreo.setCorreoDestinatario(usuario.getCorreo());
                            frmEnviarCorreo.setPdfCredenciales(pdf);
                            frmEnviarCorreo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frmEnviarCorreo.setVisible(true);

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(this, "Error al generar el PDF: " + ex.getMessage());
                        }
                    }

                    usuarios.cargarUsuariosEnTabla();
                    limpiarCampos();

                } else {
                    JOptionPane.showMessageDialog(this, "Error al agregar el usuario.");
                }
            }

        } catch (Exception ex) {
            String errorCorreo = ex.getMessage();
            if (errorCorreo != null && errorCorreo.contains("Duplicate entry") && errorCorreo.contains("correo")) {
                JOptionPane.showMessageDialog(this, "El correo ya está registrado. Intente con otro correo.");
            } else {
                JOptionPane.showMessageDialog(this, "Error: " + errorCorreo);
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FrmRoles frmRoles = new FrmRoles();
        frmRoles.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmRoles.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // recarga combos después de cerrar
                inicializarComboTipoUsuario(comboTipoU);    // recarga autores
            }
        });
        frmRoles.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUsuario().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> comboTipoU;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel panelUser;
    private javax.swing.JTextField txtAp;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
