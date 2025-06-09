/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.mysql.cj.jdbc.Blob;
import controlador.LibroControlador;
import java.awt.Desktop;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;
import utilidades.ConexionDB;
import utilidades.DimencionImagen;
import utilidades.EnviarCorreo;
import utilidades.GeneradorPDF;

/**
 *
 * @author sarai
 */
public class VerLibros extends javax.swing.JFrame {

    private Connection conexion;
    private LibroControlador controlador;
    private String tipoUsuario;
    /**
     * Creates new form VerLibros
     */
    
    public VerLibros() {
        initComponents();
        configurarPermisos();
        conexion = ConexionDB.getConexion();
        controlador = new LibroControlador(conexion);
        cargarLibrosEnTabla();
        DimencionImagen.ajustarImagenEnLabel(lblBuscarUser, "/imagenes/buscarUser.png", 30, 30);
        configurarBarraBusqueda();
    }
    
     public VerLibros(String tipoUsuario) {
        this();
        this.tipoUsuario = tipoUsuario;
        configurarPermisos();
    }

    private void configurarPermisos() {
        if ("Bibliotecario".equalsIgnoreCase(tipoUsuario)) {
            btnAgregarU.setVisible(false);
            btnEliminarU.setVisible(false);
        }
    }

    private void configurarBarraBusqueda() {
        // Configurar el listener para la barra de búsqueda
        barraBusqueda2.getCampoBusqueda().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarTablaLibros();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarTablaLibros();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarTablaLibros();
            }
        });
    }

 
    private void filtrarTablaLibros() {
    String textoBusqueda = barraBusqueda2.getCampoBusqueda().getText().toLowerCase();
    DefaultTableModel modelo = (DefaultTableModel) tblLibro.getModel();
    modelo.setRowCount(0);

    try {
        Connection conexion = ConexionDB.getConexion();
        LibroControlador controlador = new LibroControlador(conexion);

        for (Libro libro : controlador.buscarTodosLibros()) {
            if (textoBusqueda.isEmpty() ||
                libro.getTitulo().toLowerCase().contains(textoBusqueda) ||
                libro.getNombreAutor().toLowerCase().contains(textoBusqueda) ||
                libro.getNombreEditorial().toLowerCase().contains(textoBusqueda) ||
                libro.getNombreCategoria().toLowerCase().contains(textoBusqueda)) {

                modelo.addRow(new Object[]{
                    libro.getTitulo(),
                    libro.getNombreAutor(),
                    libro.getNombreEditorial(),
                    libro.getNombreCategoria(),
                    libro.getCantidad(),
                    libro.getAnioEdicion()
                });
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar libros: " + e.getMessage());
    }
}
    
    public void cargarLibrosEnTabla() {
    try {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Título");
        modelo.addColumn("Autor");
        modelo.addColumn("Editorial");
        modelo.addColumn("Categoría");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Año");

        List<Libro> lista = controlador.buscarTodosLibros();
        for (Libro libro : lista) {
            modelo.addRow(new Object[]{
                libro.getTitulo(),
                libro.getNombreAutor(),
                libro.getNombreEditorial(),
                libro.getNombreCategoria(),
                libro.getCantidad(),
                libro.getAnioEdicion()
            });
        }

        tblLibro.setModel(modelo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar libros: " + e.getMessage());
        e.printStackTrace();
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLibros = new javax.swing.JPanel();
        lblBuscarUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAgregarU = new javax.swing.JButton();
        btnEliminarU = new javax.swing.JButton();
        btnEditarU = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibro = new javax.swing.JTable();
        brnRegresar = new javax.swing.JButton();
        barraBusqueda2 = new barrabusqueda_actualizado.barraBusqueda();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelLibros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 142, 142), 2));
        panelLibros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBuscarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscarUser.png"))); // NOI18N
        panelLibros.add(lblBuscarUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 142, 142));
        jLabel1.setText("Libros");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelLibros.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 60, -1));

        btnAgregarU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libroAgregar.png"))); // NOI18N
        btnAgregarU.setText("Agregar");
        btnAgregarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUActionPerformed(evt);
            }
        });
        panelLibros.add(btnAgregarU, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, -1, -1));

        btnEliminarU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminarU.setText("Eliminar");
        btnEliminarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUActionPerformed(evt);
            }
        });
        panelLibros.add(btnEliminarU, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, -1, -1));

        btnEditarU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnEditarU.setText("Editar");
        btnEditarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUActionPerformed(evt);
            }
        });
        panelLibros.add(btnEditarU, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 101, -1));

        jLabel6.setText("Buscar Usuario");
        panelLibros.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 54, -1, -1));

        tblLibro.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLibroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLibro);

        panelLibros.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 910, 320));

        brnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        brnRegresar.setText("Regresar");
        brnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnRegresarActionPerformed(evt);
            }
        });
        panelLibros.add(brnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));
        panelLibros.add(barraBusqueda2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 440, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 942, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(panelLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUActionPerformed
        // TODO add your handling code here:
  
        FrmLibro frmLibros = new FrmLibro();
        frmLibros.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmLibros.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // recarga tabla después de
                cargarLibrosEnTabla();    
            }
        });
        frmLibros.setVisible(true);
    }//GEN-LAST:event_btnAgregarUActionPerformed

    private void btnEliminarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUActionPerformed
       int fila = tblLibro.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un libro.");
        return;
    }

    try {
        String titulo = tblLibro.getValueAt(fila, 0).toString();
        String autor = tblLibro.getValueAt(fila, 1).toString();
        String editorial = tblLibro.getValueAt(fila, 2).toString();

        boolean exito = controlador.eliminarLibro(titulo, autor, editorial);
        JOptionPane.showMessageDialog(this, "Estás seguro de eliminar el libro.");
        if (exito) {
            JOptionPane.showMessageDialog(this, "Libro eliminado.");
            cargarLibrosEnTabla();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
    }
    }//GEN-LAST:event_btnEliminarUActionPerformed

    private void btnEditarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUActionPerformed
       int filaSeleccionada = tblLibro.getSelectedRow();

    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Por favor selecciona un libro para editar.");
        return;
    }

    String titulo = tblLibro.getValueAt(filaSeleccionada, 0).toString();
    String autor = tblLibro.getValueAt(filaSeleccionada, 1).toString();
    String editorial = tblLibro.getValueAt(filaSeleccionada, 2).toString();
    String categoria = tblLibro.getValueAt(filaSeleccionada, 3).toString();
    int cantidad = Integer.parseInt(tblLibro.getValueAt(filaSeleccionada, 4).toString());
    int anio = Integer.parseInt(tblLibro.getValueAt(filaSeleccionada, 5).toString());

    // Crear y mostrar FrmLibros con los datos cargados
    FrmLibro formulario= new FrmLibro();
    formulario.setModoEdicion(true); // opcional, si quieres un flag para saber que es edición
    formulario.setDatosLibro(titulo, autor, editorial, categoria, cantidad, anio);
    
    formulario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        formulario.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // recarga combos después
                cargarLibrosEnTabla();    
            }
        });
    
    formulario.setVisible(true);
    }//GEN-LAST:event_btnEditarUActionPerformed

    private void tblLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLibroMouseClicked
    int fila = tblLibro.rowAtPoint(evt.getPoint());
    int columna = tblLibro.columnAtPoint(evt.getPoint());

    // Verificamos si se hizo clic en la última columna (PDF)
    if (columna == tblLibro.getColumnCount() - 1) {
        String titulo = tblLibro.getValueAt(fila, 0).toString();
    }
    }//GEN-LAST:event_tblLibroMouseClicked

    private void brnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnRegresarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_brnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(VerLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerLibros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private barrabusqueda_actualizado.barraBusqueda barraBusqueda2;
    private javax.swing.JButton brnRegresar;
    private javax.swing.JButton btnAgregarU;
    private javax.swing.JButton btnEditarU;
    private javax.swing.JButton btnEliminarU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscarUser;
    private javax.swing.JPanel panelLibros;
    private javax.swing.JTable tblLibro;
    // End of variables declaration//GEN-END:variables
}
