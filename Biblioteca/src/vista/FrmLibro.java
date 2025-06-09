/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import VALIDACION.Validacion;
import com.mysql.cj.jdbc.Blob;
import controlador.LibroControlador;
import utilidades.DimencionImagen;
import controlador.UsuarioControlador;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.*;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JFrame;
import modelo.Libro;
import utilidades.ConexionDB;

/**
 *
 * @author Sarai
 */
public class FrmLibro extends javax.swing.JFrame {
    private Connection conexion;
    private LibroControlador controlador;
    private VerLibros verLibro = new VerLibros();
    private boolean modoEdicion = false;
    private String tituloOriginal; // Para saber qué libro se está editando
    
    


    /**
     * Creates new form IUsuario
     */
    public FrmLibro() {
        initComponents();
        conexion = ConexionDB.getConexion();
        controlador = new LibroControlador(conexion);
        cargarComboAutores();
        cargarComboEditoriales();
        cargarComboCategorias();

    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;

        if (modoEdicion) {
            btnAceptar.setText("Guardar"); // Cambiar texto del botón
            btnLimpiar.setEnabled(false);
        } else {
            btnAceptar.setText("Agregar");
        }
    }

    public void cargarComboAutores() {
        try {
            List<String> autores = controlador.obtenerNombres("autor");
            cmbAutor.removeAllItems();
            for (String nombre : autores) {
                cmbAutor.addItem(nombre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar autores: " + e.getMessage());
        }
    }

    public void cargarComboEditoriales() {
        try {
            List<String> editoriales = controlador.obtenerNombres("editorial");
            cmbEditorial.removeAllItems();
            for (String nombre : editoriales) {
                cmbEditorial.addItem(nombre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar editoriales: " + e.getMessage());
        }
    }

    public void setDatosLibro(String titulo, String autor, String editorial,
            String categoria, int cantidad, int anio) {
        txtTitulo.setText(titulo);
        cmbAutor.setSelectedItem(autor);
        cmbEditorial.setSelectedItem(editorial);
        cmbCategoria.setSelectedItem(categoria);
        txtCantidad.setText(String.valueOf(cantidad));
        txtAnio.setText(String.valueOf(anio));

        this.tituloOriginal = titulo;
    }

    public void cargarComboCategorias() {
        try {
            List<String> categorias = controlador.obtenerNombres("categoria");
            cmbCategoria.removeAllItems();
            for (String nombre : categorias) {
                cmbCategoria.addItem(nombre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar categorías: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtTitulo.setText("");
        txtCantidad.setText("");
        cmbAutor.setSelectedIndex(0);
        cmbEditorial.setSelectedIndex(0);
        cmbCategoria.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUser = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JTextField();
        lblLibro = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        cmbCategoria = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbAutor = new javax.swing.JComboBox<>();
        cmbEditorial = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();
        btnAgregarAutores = new javax.swing.JButton();
        btnEditorial = new javax.swing.JButton();
        txtAnio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 142, 142), 2));
        panelUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });
        panelUser.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 257, -1));

        lblLibro.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        lblLibro.setForeground(new java.awt.Color(0, 142, 142));
        lblLibro.setText("NUEVO LIBRO");
        lblLibro.setToolTipText("");
        lblLibro.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelUser.add(lblLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 190, -1));

        jLabel2.setText("Titulo de libro");
        panelUser.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel3.setText("Cantidad");
        panelUser.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        jLabel4.setText("Año de edicion");
        panelUser.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));
        panelUser.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 257, -1));

        jLabel7.setText("Autor");
        panelUser.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        btnAceptar.setText("Agregar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelUser.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, -1, -1));

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });
        panelUser.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 260, 30));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelUser.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, -1, -1));

        jLabel6.setText("Categoria");
        panelUser.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel8.setText("Editorial");
        panelUser.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        cmbAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAutorActionPerformed(evt);
            }
        });
        panelUser.add(cmbAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 260, 30));

        cmbEditorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEditorialActionPerformed(evt);
            }
        });
        panelUser.add(cmbEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 260, 30));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        panelUser.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, -1, -1));

        btnCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });
        panelUser.add(btnCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, -1, 30));

        btnAgregarAutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        btnAgregarAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAutoresActionPerformed(evt);
            }
        });
        panelUser.add(btnAgregarAutores, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, -1, 30));

        btnEditorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        btnEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditorialActionPerformed(evt);
            }
        });
        panelUser.add(btnEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, 30));
        panelUser.add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 260, -1));

        getContentPane().add(panelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        verLibro.cargarLibrosEnTabla();
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void cmbAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAutorActionPerformed

    private void cmbEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEditorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEditorialActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAutoresActionPerformed
        // TODO add your handling code here:
        FrmAutor frmAutor = new FrmAutor();
        frmAutor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmAutor.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // recarga combos después de cerrar
                cargarComboAutores();     // recarga autores
            }
        });
        frmAutor.setVisible(true);
    }//GEN-LAST:event_btnAgregarAutoresActionPerformed

    private void btnEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditorialActionPerformed
        // TODO add your handling code here:
        FrmEditorial frmEditorial = new FrmEditorial();
        frmEditorial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmEditorial.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // recarga combos después de cerrar FrmAutor
                cargarComboEditoriales();     // recarga editorial
            }
        });
        frmEditorial.setVisible(true);

    }//GEN-LAST:event_btnEditorialActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        // TODO add your handling code here:
        FrmCategoria frmCategoria = new FrmCategoria();
        frmCategoria.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmCategoria.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // recarga combos después de cerrar 
                cargarComboCategorias();     // recarga categoria
            }
        });
        frmCategoria.setVisible(true);
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        if (!Validacion.validarNoVacio(txtTitulo.getText())
                || !Validacion.validarNoVacio((String) cmbAutor.getSelectedItem())
                || !Validacion.validarNoVacio((String) cmbEditorial.getSelectedItem())
                || !Validacion.validarNoVacio(txtCantidad.getText())
                || !Validacion.validarNoVacio(txtAnio.getText())
                || !Validacion.validarNoVacio((String) cmbCategoria.getSelectedItem())) {
            JOptionPane.showMessageDialog(this, "Rellena tods los campos.");
            return;
        }

        if (!Validacion.validarSoloLetras(txtTitulo.getText())) {
            JOptionPane.showMessageDialog(this, "Ingrese unicamnete letras en campo Titulo.");
            return;
        }

        if (!Validacion.validarSoloNumeros(txtCantidad.getText())
                || !Validacion.validarSoloNumeros(txtAnio.getText())) {
            JOptionPane.showMessageDialog(this, "Ingrese unicamnete numero es el campo Telefono.");
            return;
        }

        try {
            String titulo = txtTitulo.getText();
            String autor = cmbAutor.getSelectedItem().toString();
            String editorial = cmbEditorial.getSelectedItem().toString();
            String categoria = cmbCategoria.getSelectedItem().toString();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            int anio = Integer.parseInt(txtAnio.getText());

            Libro libro = new Libro(titulo, autor, editorial, categoria, cantidad, anio);

            if (modoEdicion) {
                if (controlador.editar(libro)) {
                    JOptionPane.showMessageDialog(this, "Libro actualizado correctamente.");
                    this.dispose(); // Cerrar formulario
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar el libro.");
                }
            } else {
                if (controlador.insertar(libro)) {
                    JOptionPane.showMessageDialog(this, "Libro agregado correctamente.");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo agregar el libro.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
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
            java.util.logging.Logger.getLogger(FrmLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLibro().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarAutores;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnEditorial;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbAutor;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEditorial;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblLibro;
    private javax.swing.JPanel panelUser;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
