/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;


import VALIDACION.Validacion;
import controlador.ControladorRC;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Rol;
import utilidades.ConexionDB;

/**
 *
 * @author hecto
 */
public class FrmRoles extends javax.swing.JFrame {

    /**
     * Creates new form FrmRoles
     */
    public FrmRoles() {
        initComponents();
        cargarRolesEnTabla();
    }

    
    
    private void eventoTabla(){
     int filaSeleccionada = tblRol.getSelectedRow();
            if (filaSeleccionada != -1) {
                String nombre = tblRol.getValueAt(filaSeleccionada, 0).toString();
                txtNombre.setText(nombre);
     }
    }
     

    public void cargarRolesEnTabla() {
    DefaultTableModel modelo = new DefaultTableModel(
    new Object[][] {},
    new String[] { "nombre de rol"}
);
tblRol.setModel(modelo);

    modelo.setRowCount(0); // Limpiar tabla
    

    try {
        Connection conexion = ConexionDB.getConexion();
        ControladorRC rc = new ControladorRC(conexion);

        for (Rol r : rc.buscarTodosRoles()){

            modelo.addRow(new Object[] {
            
                  r.getNombre()
            });
        }
       
        
        eventoTabla();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar Roles: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRol = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 142, 142));
        jLabel1.setText("NUEVO ROL");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 120, -1));

        tblRol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRol);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 240));

        jLabel2.setText("Nombre del rol");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 250, -1));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 100, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
         String nombre= txtNombre.getText().trim();
         if (!Validacion.validarNoVacio(txtNombre.getText()) ||
        !Validacion.validarSoloLetras(txtNombre.getText())) {
        JOptionPane.showMessageDialog(this, "Rellena le campo nombre y unicamente que sea con letras.");
        return;     
    }
         
         Rol rol = new Rol(nombre);

    try {
        Connection conexion = ConexionDB.getConexion(); // tu clase de conexión
        ControladorRC rc = new ControladorRC(conexion);

        boolean exito = rc.insertar(rol);

        if (exito) {
            JOptionPane.showMessageDialog(this, "rol insertado correctamente.");
            txtNombre.setText(""); // Limpiar el campo
            cargarRolesEnTabla();     // Opcional, si quieres refrescar la tabla

        } else {
            JOptionPane.showMessageDialog(this, "No se pudo insertar el rol.");
        }



    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al insertar roles: " + ex.getMessage());
        ex.printStackTrace();
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
         int fila = tblRol.getSelectedRow();

    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un rol para editar.");
        return;
    }

    String nombreNuevo = txtNombre.getText().trim();
    if (!Validacion.validarNoVacio(txtNombre.getText()) ||
        !Validacion.validarSoloLetras(txtNombre.getText())) {
        JOptionPane.showMessageDialog(this, "Rellena le campo nombre y unicamente que sea con letras.");
        return;     
    }
    
    try {
        Connection conexion = ConexionDB.getConexion();
        ControladorRC rc = new ControladorRC(conexion);

       
        String nombreAnterior = tblRol.getValueAt(fila, 0).toString();
       

        Rol rolEditado = new Rol(nombreNuevo);

        boolean exito = rc.actualizar(nombreAnterior, rolEditado);
        if (exito) {
            JOptionPane.showMessageDialog(this, "Rol actualizado.");

            cargarRolesEnTabla();
            txtNombre.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar el rol.");
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al editar rol: " + ex.getMessage());
    }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int filaSeleccionada = tblRol.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un rol en la tabla para eliminar.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este rol?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            Connection conexion = ConexionDB.getConexion();
    ControladorRC rc = new ControladorRC(conexion);
            String nombre = (String) tblRol.getValueAt(filaSeleccionada, 0); 

            if (rc.eliminarPorNombre(nombre)) {
                DefaultTableModel modelo = (DefaultTableModel) tblRol.getModel();
                modelo.removeRow(filaSeleccionada);
                cargarRolesEnTabla();
                txtNombre.setText(""); // Limpiar el campo

                JOptionPane.showMessageDialog(this, "Rol eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el rol.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRolMouseClicked
        // TODO add your handling code here:
        eventoTabla();
    }//GEN-LAST:event_tblRolMouseClicked

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
            java.util.logging.Logger.getLogger(FrmRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRoles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRol;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
