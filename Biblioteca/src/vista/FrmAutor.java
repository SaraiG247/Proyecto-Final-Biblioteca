/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import VALIDACION.Validacion;
import controlador.ControladorACE;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Autor;
import utilidades.ConexionDB;

/**
 *
 * @author sarai
 */
public class FrmAutor extends javax.swing.JFrame {

    
    /**
     * Creates new form FrmAutor
     */
    public FrmAutor() {
        initComponents();
        cargarAutoresEnTabla();
    }
    
    
    
     private void eventoTabla(){
     int filaSeleccionada = tblAutor.getSelectedRow();
            if (filaSeleccionada != -1) {
                String nombre = tblAutor.getValueAt(filaSeleccionada, 0).toString();
                txtNombreAutor.setText(nombre);
     }
    }
     

    public void cargarAutoresEnTabla() {
    DefaultTableModel modelo = new DefaultTableModel(
    new Object[][] {},
    new String[] { "Nombres"}
);
tblAutor.setModel(modelo);

    modelo.setRowCount(0); // Limpiar tabla
    

    try {
        Connection conexion = ConexionDB.getConexion();
        ControladorACE ace = new ControladorACE(conexion);

        for (Autor a : ace.buscarTodosAutores()) {
            modelo.addRow(new Object[] {
                a.getNombre()
                
            });
        }
        
        eventoTabla();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar autores: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAutor = new javax.swing.JPanel();
        lblAutor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAutor = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNombreAutor = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelAutor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 142, 142), 2));
        panelAutor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAutor.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        lblAutor.setForeground(new java.awt.Color(0, 142, 142));
        lblAutor.setText("Nuevo autor");
        lblAutor.setToolTipText("");
        lblAutor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelAutor.add(lblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 110, -1));

        tblAutor.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAutorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAutor);

        panelAutor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 360, 260));

        jLabel2.setText("Nombre del autor");
        panelAutor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        panelAutor.add(txtNombreAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 330, -1));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        btnAgregar.setText("Aceptar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panelAutor.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        panelAutor.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 100, 30));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelAutor.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, -1, -1));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelAutor.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        String nombre= txtNombreAutor.getText().trim();
         if (!Validacion.validarNoVacio(txtNombreAutor.getText()) ||
        !Validacion.validarSoloLetras(txtNombreAutor.getText())) {
        JOptionPane.showMessageDialog(this, "Rellena le campo nombre y unicamente que sea con letras.");
        return;     
    }
         
         Autor autor = new Autor(nombre);

    try {
        Connection conexion = ConexionDB.getConexion(); // tu clase de conexión
        ControladorACE ace = new ControladorACE(conexion);

        boolean exito = ace.insertar(autor);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Autor insertado correctamente.");
            txtNombreAutor.setText(""); // Limpiar el campo
            cargarAutoresEnTabla();     // Opcional, si quieres refrescar la tabla

        } else {
            JOptionPane.showMessageDialog(this, "No se pudo insertar el autor.");
        }



    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al insertar autor: " + ex.getMessage());
        ex.printStackTrace();
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tblAutor.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un Autor en la tabla para eliminar.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este Autor?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            Connection conexion = ConexionDB.getConexion();
    ControladorACE ace = new ControladorACE(conexion);
            String nombre = (String) tblAutor.getValueAt(filaSeleccionada, 0); 

            if (ace.eliminarPorNombre(nombre)) {
                DefaultTableModel modelo = (DefaultTableModel) tblAutor.getModel();
                modelo.removeRow(filaSeleccionada);
                cargarAutoresEnTabla();
                txtNombreAutor.setText(""); // Limpiar el campo

                JOptionPane.showMessageDialog(this, "Autor eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el autor.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int fila = tblAutor.getSelectedRow();

    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un autor para editar.");
        return;
    }

    String nombreNuevo = txtNombreAutor.getText().trim();
    if (!Validacion.validarNoVacio(txtNombreAutor.getText()) ||
        !Validacion.validarSoloLetras(txtNombreAutor.getText())) {
        JOptionPane.showMessageDialog(this, "Rellena le campo nombre y unicamente que sea con letras.");
        return;     
    }
    
    try {
        Connection conexion = ConexionDB.getConexion();
        ControladorACE ace = new ControladorACE(conexion);

       
        String nombreAnterior = tblAutor.getValueAt(fila, 0).toString();
       

        Autor autorEditado = new Autor(nombreNuevo);

        boolean exito = ace.actualizar(nombreAnterior, autorEditado);
        if (exito) {
            JOptionPane.showMessageDialog(this, "Autor actualizado.");

            cargarAutoresEnTabla();
            txtNombreAutor.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar el autor.");
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al editar autor: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void tblAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAutorMouseClicked
        // TODO add your handling code here:
        eventoTabla();
    }//GEN-LAST:event_tblAutorMouseClicked

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
            java.util.logging.Logger.getLogger(FrmAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAutor().setVisible(true);
            }
        });
    }
       
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JPanel panelAutor;
    private javax.swing.JTable tblAutor;
    private javax.swing.JTextField txtNombreAutor;
    // End of variables declaration//GEN-END:variables
}
