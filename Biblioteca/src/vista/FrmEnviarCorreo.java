/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import utilidades.EnviarCorreo;

/**
 *
 * @author sarai
 */
public class FrmEnviarCorreo extends javax.swing.JFrame {

    private File pdfCredenciales;
    private List<File> archivosAdjuntos;
    private DefaultListModel<String> modeloArchivos;

    /**
     * Creates new form FrmAutor
     */
    public FrmEnviarCorreo() {
        initComponents();
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        archivosAdjuntos = new ArrayList<>();
    modeloArchivos = new DefaultListModel<>();

    // Texto predeterminado (pero editable)
    txtAsunto.setText("Credenciales de acceso - Sistema Raíces y Letra");
    txtMensaje.setText(
        "Estimado usuario,\n\n" +
        "Adjunto encontrará sus credenciales de acceso al sistema\n" +
        "de gestión de biblioteca Raíces y Letra.\n\n" +
        "Por favor conserve esta información."
    );

    // Editar los mensajes
    txtMensaje.setEditable(true); 
    txtMensaje.setLineWrap(true);
    txtMensaje.setWrapStyleWord(true);
    
    // Listener para validar en tiempo real
    txtDestinatario.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) { validarFormulario(); }
        public void removeUpdate(DocumentEvent e) { validarFormulario(); }
        public void insertUpdate(DocumentEvent e) { validarFormulario(); }
    });
    
    txtAsunto.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) { validarFormulario(); }
        public void removeUpdate(DocumentEvent e) { validarFormulario(); }
        public void insertUpdate(DocumentEvent e) { validarFormulario(); }
    });
    }


    public void setCorreoDestinatario(String correo) {
        txtDestinatario.setText(correo);
        txtDestinatario.setEditable(false);
        validarFormulario();
    }

    public void setPdfCredenciales(File pdf) {
        this.pdfCredenciales = pdf;
        if (pdf != null && !archivosAdjuntos.contains(pdf)) {
            archivosAdjuntos.add(pdf);
        }
    }

    private void validarFormulario() {
        boolean esValido = true;
        StringBuilder errores = new StringBuilder();

        // Validar destinatario
        String email = txtDestinatario.getText().trim();
        if (email.isEmpty()) {
            esValido = false;
            errores.append("- El destinatario es obligatorio\n");
        } else if (!EnviarCorreo.validarEmail(email)) {
            esValido = false;
            errores.append("- El formato del email no es válido\n");
        }

        // Validar asunto
        if (txtAsunto.getText().trim().isEmpty()) {
            esValido = false;
            errores.append("- El asunto es obligatorio\n");
        }

        // Validar mensaje
        if (txtMensaje.getText().trim().isEmpty()) {
            esValido = false;
            errores.append("- El mensaje es obligatorio\n");
        }

        // Actualizar estado de botones
        btnEnviar.setEnabled(esValido);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAutor = new javax.swing.JPanel();
        lblEnvioCorreo = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtDestinatario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAsunto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelAutor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 142, 142), 2));
        panelAutor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEnvioCorreo.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        lblEnvioCorreo.setForeground(new java.awt.Color(0, 142, 142));
        lblEnvioCorreo.setText("Envío de Correo");
        lblEnvioCorreo.setToolTipText("");
        lblEnvioCorreo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelAutor.add(lblEnvioCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 150, -1));

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/enviarcorreo.png"))); // NOI18N
        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        panelAutor.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 100, -1));

        jLabel1.setText("Destinatario");
        panelAutor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        panelAutor.add(txtDestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 280, -1));

        jLabel3.setText("Asunto");
        panelAutor.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));
        panelAutor.add(txtAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 92, 280, 30));

        txtMensaje.setColumns(20);
        txtMensaje.setRows(5);
        jScrollPane1.setViewportView(txtMensaje);

        panelAutor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 350, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        try {
            // Validar campos
            if (txtDestinatario.getText().trim().isEmpty()
                    || txtAsunto.getText().trim().isEmpty()
                    || txtMensaje.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos");
                return;
            }

            if (pdfCredenciales == null) {
                JOptionPane.showMessageDialog(this, "No hay archivo PDF adjunto");
                return;
            }

            // Enviar correo
            EnviarCorreo.enviarConAdjunto(
                    txtDestinatario.getText().trim(),
                    txtAsunto.getText().trim(),
                    txtMensaje.getText().trim(),
                    pdfCredenciales
            );

            JOptionPane.showMessageDialog(this,
                    "Correo enviado exitosamente a: " + txtDestinatario.getText());
            dispose(); // Cerrar ventana

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al enviar: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmEnviarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEnviarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEnviarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEnviarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEnviarCorreo().setVisible(true);
            }
        });
    }
       
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEnvioCorreo;
    private javax.swing.JPanel panelAutor;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextField txtDestinatario;
    private javax.swing.JTextArea txtMensaje;
    // End of variables declaration//GEN-END:variables
}
