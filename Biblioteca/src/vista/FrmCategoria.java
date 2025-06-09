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
import utilidades.ConexionDB;

/**
 *
 * @author hecto
 */
public class FrmCategoria extends javax.swing.JFrame {

   
    /**
     * Creates new form FrmCategoria
     */
    public FrmCategoria() {
        initComponents();
       cargarCategoriaEnTabla();
    }

    private void eventoTabla(){
     int filaSeleccionada = tblCategoria.getSelectedRow();
            if (filaSeleccionada != -1) {
                String nombre = tblCategoria.getValueAt(filaSeleccionada, 0).toString();
                txtNombreCategoria.setText(nombre);
     }
    }
    
    
    public void cargarCategoriaEnTabla() {
    DefaultTableModel modelo = new DefaultTableModel(
    new Object[][] {},
    new String[] { "Nombres"}
);
tblCategoria.setModel(modelo);

    modelo.setRowCount(0); // Limpiar tabla
    

    try {
        Connection conexion = ConexionDB.getConexion();
        ControladorACE ace = new ControladorACE(conexion);

        for (Categoria c : ace.buscarTodosCategoria()) {
            modelo.addRow(new Object[] {
                c.getNombre()
                
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
        tblCategoria = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCategoria = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelAutor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 142, 142), 2));
        panelAutor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 142, 142));
        jLabel1.setText("Nueva categoria");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelAutor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 140, -1));

        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategoria);

        panelAutor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 260, 250));

        jLabel2.setText("Nombre de la categoria");
        panelAutor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        panelAutor.add(txtNombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 250, -1));

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
                .addComponent(panelAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        String nombre= txtNombreCategoria.getText().trim();
        if (!Validacion.validarNoVacio(txtNombreCategoria.getText()) ||
            !Validacion.validarSoloLetras(txtNombreCategoria.getText())) {
            JOptionPane.showMessageDialog(this, "Rellena le campo nombre y unicamente que sea con letras.");
            return;
        }

        Categoria categoria = new Categoria(nombre);

        try {
            Connection conexion = ConexionDB.getConexion(); // tu clase de conexión
            ControladorACE ace = new ControladorACE(conexion);

            boolean exito = ace.insertarCategoria(categoria);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Categoria insertada correctamente.");
                txtNombreCategoria.setText(""); // Limpiar el campo
                cargarCategoriaEnTabla();     // Opcional, si quieres refrescar la tabla
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo insertar la categoria.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al insertar autor: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       // TODO add your handling code here:
        int filaSeleccionada = tblCategoria.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una categoria en la tabla para eliminar.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar esta categoria?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            Connection conexion = ConexionDB.getConexion();
    ControladorACE ace = new ControladorACE(conexion);
            String nombre = (String) tblCategoria.getValueAt(filaSeleccionada, 0); 

            if (ace.eliminarPorNombreCat(nombre)) {
                DefaultTableModel modelo = (DefaultTableModel) tblCategoria.getModel();
                modelo.removeRow(filaSeleccionada);
                cargarCategoriaEnTabla();
                txtNombreCategoria.setText(""); // Limpiar el campo
                JOptionPane.showMessageDialog(this, "Categoria eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar la categoria.");
            }

        } catch (Exception e) { 
            JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriaMouseClicked
        // TODO add your handling code here:
        eventoTabla();
    }//GEN-LAST:event_tblCategoriaMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int fila = tblCategoria.getSelectedRow();

    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione una categoria para editar.");
        return;
    }

    String nombreNuevo = txtNombreCategoria.getText().trim();
    if (!Validacion.validarNoVacio(txtNombreCategoria.getText()) ||
        !Validacion.validarSoloLetras(txtNombreCategoria.getText())) {
        JOptionPane.showMessageDialog(this, "Rellena le campo nombre y unicamente que sea con letras.");
        return;     
    }
    
    try {
        Connection conexion = ConexionDB.getConexion();
        ControladorACE ace = new ControladorACE(conexion);

       
        String nombreAnterior = tblCategoria.getValueAt(fila, 0).toString();
       

        Categoria categoriaEditada = new Categoria(nombreNuevo);

        boolean exito = ace.actualizarCategoria(nombreAnterior, categoriaEditada);
        if (exito) {
            JOptionPane.showMessageDialog(this, "Categoria actualizada.");
            cargarCategoriaEnTabla();
            txtNombreCategoria.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar la categoria.");
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al editar categoria: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCategoria().setVisible(true);
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
    private javax.swing.JTable tblCategoria;
    private javax.swing.JTextField txtNombreCategoria;
    // End of variables declaration//GEN-END:variables
}
