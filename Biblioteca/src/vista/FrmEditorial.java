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
import modelo.Categoria;
import modelo.Editorial;
import utilidades.ConexionDB;

/**
 *
 * @author hecto
 */
public class FrmEditorial extends javax.swing.JFrame {
    FrmLibro lib=new FrmLibro();

    /**
     * Creates new form FrmEditorial
     */
    public FrmEditorial() {
        initComponents();
        cargarEditorialEnTabla();
    }


    private void eventoTabla(){
     int filaSeleccionada = tblEditorial.getSelectedRow();
            if (filaSeleccionada != -1) {
                String nombre = tblEditorial.getValueAt(filaSeleccionada, 0).toString();
                txtNombreEditorial.setText(nombre);
     }
    }
    
    
    public void cargarEditorialEnTabla() {
    DefaultTableModel modelo = new DefaultTableModel(
    new Object[][] {},
    new String[] { "Nombres"}
);
tblEditorial.setModel(modelo);

    modelo.setRowCount(0); // Limpiar tabla
    

    try {
        Connection conexion = ConexionDB.getConexion();
        ControladorACE ace = new ControladorACE(conexion);

        for (Editorial e : ace.buscarTodosEditorial()) {
            modelo.addRow(new Object[] {
                e.getNombre()
                
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEditorial = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNombreEditorial = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelAutor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 142, 142), 2));
        panelAutor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 142, 142));
        jLabel1.setText("Nueva Editorial");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelAutor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 140, -1));

        tblEditorial.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEditorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEditorialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEditorial);

        panelAutor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 260, 250));

        jLabel2.setText("Nombre de la Editorial");
        panelAutor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        panelAutor.add(txtNombreEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 250, -1));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panelAutor.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        panelAutor.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 100, 30));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelAutor.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelAutor.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblEditorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEditorialMouseClicked
        // TODO add your handling code here:
        eventoTabla();
    }//GEN-LAST:event_tblEditorialMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        String nombre= txtNombreEditorial.getText().trim();
        if (!Validacion.validarNoVacio(txtNombreEditorial.getText()) ||
            !Validacion.validarSoloLetras(txtNombreEditorial.getText())) {
            JOptionPane.showMessageDialog(this, "Rellena le campo nombre y unicamente que sea con letras.");
            return;
        }

        Editorial editora = new Editorial(nombre);

        try {
            Connection conexion = ConexionDB.getConexion(); // tu clase de conexión
            ControladorACE ace = new ControladorACE(conexion);

            boolean exito = ace.insertarEditorial(editora);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Editorial insertada correctamente.");
                txtNombreEditorial.setText(""); // Limpiar el campo
                cargarEditorialEnTabla();     // Opcional, si quieres refrescar la tabla
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo insertar la editorial.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al insertar la editorial: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int fila = tblEditorial.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una editorial para editar.");
            return;
        }

        String nombreNuevo = txtNombreEditorial.getText().trim();
        if (!Validacion.validarNoVacio(txtNombreEditorial.getText()) ||
            !Validacion.validarSoloLetras(txtNombreEditorial.getText())) {
            JOptionPane.showMessageDialog(this, "Rellena le campo nombre y unicamente que sea con letras.");
            return;
        }

        try {
            Connection conexion = ConexionDB.getConexion();
            ControladorACE ace = new ControladorACE(conexion);

            String nombreAnterior = tblEditorial.getValueAt(fila, 0).toString();

            Editorial editorialEditada = new Editorial(nombreNuevo);

            boolean exito = ace.actualizarEditorial(nombreAnterior, editorialEditada);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Editorial actualizada.");
                cargarEditorialEnTabla();
                txtNombreEditorial.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar la editorial.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al editar editorial: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tblEditorial.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una editorial en la tabla para eliminar.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar esta editorial?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            Connection conexion = ConexionDB.getConexion();
            ControladorACE ace = new ControladorACE(conexion);
            String nombre = (String) tblEditorial.getValueAt(filaSeleccionada, 0);

            if (ace.eliminarPorNombreEd(nombre)) {
                DefaultTableModel modelo = (DefaultTableModel) tblEditorial.getModel();
                modelo.removeRow(filaSeleccionada);
                cargarEditorialEnTabla();
                txtNombreEditorial.setText(""); // Limpiar el campo
                JOptionPane.showMessageDialog(this, "Editorial eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar la editorial.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        lib.cargarComboEditoriales();
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEditorial().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelAutor;
    private javax.swing.JTable tblEditorial;
    private javax.swing.JTextField txtNombreEditorial;
    // End of variables declaration//GEN-END:variables
}
