/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import VALIDACION.Validacion;
import controlador.PrestamoControlador;
import java.awt.Color;
import java.sql.Connection;
import java.sql.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.DetallePrestamo;
import java.util.Date;
import modelo.Prestamo;
import utilidades.ConexionDB;

/**
 *
 * @author sarai
 */
public class HacerPrestamo extends javax.swing.JFrame {
    

    /**
     * Creates new form VerPrestamos
     */
    public HacerPrestamo() {
        initComponents();
        cargarLibrosEnCombo();
        cargarClientesEnCombo();
        configurarEstadoInicial();

        DefaultTableModel modelo = new DefaultTableModel(
    new Object[][]{},
    new String[]{"Libro", "Autor", "Categoría", "Cantidad"}
);
tblLibrosPrestamo.setModel(modelo);


       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void cargarClientesEnCombo() {
    try {
        Connection conexion = ConexionDB.getConexion();
        String sql = "SELECT nombre, apellidos FROM cliente ORDER BY nombre";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            cmbClientes.removeAllItems();
            while (rs.next()) {
                String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellidos");
                cmbClientes.addItem(nombreCompleto);
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar clientes: " + e.getMessage());
    }
}

    public void cargarLibrosEnCombo() {
    try {
        Connection conexion = ConexionDB.getConexion();
        String sql = "SELECT titulo FROM libro ORDER BY titulo";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            cmbLibros.removeAllItems();
            while (rs.next()) {
                cmbLibros.addItem(rs.getString("titulo"));
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar libros: " + e.getMessage());
    }
}

    private void configurarEstadoInicial() {
    cmbClientes.setEnabled(true);
    btnAceptarCliente.setEnabled(true);

    cmbLibros.setEnabled(false);
    txtCantidad.setEnabled(false);
    btnAgregarLibro.setEnabled(false);
    btnAceptarPrestamo.setEnabled(false);
    btnCancelar.setEnabled(false);
    btnQuitar.setEnabled(false);
}

    
    private void limpiarFormularioPrestamo() {
    // Habilitar selección de cliente
    cmbClientes.setEnabled(true);
    btnAceptarCliente.setEnabled(true);

    // Deshabilitar demás campos
    cmbLibros.setEnabled(false);
    txtCantidad.setEnabled(false);
    btnAgregarLibro.setEnabled(false);
    btnAceptarPrestamo.setEnabled(false);
    btnCancelar.setEnabled(false);
    btnQuitar.setEnabled(false);

    // Limpiar campos
    txtCantidad.setText("");
    txtTotal.setText("");
    lblError.setVisible(false);
    dateInicio.setDate(null);
    dateDevolucion.setDate(null);

    // Limpiar tabla
    DefaultTableModel modelo = (DefaultTableModel) tblLibrosPrestamo.getModel();
    modelo.setRowCount(0);
}


private int obtenerStockDisponible(String tituloLibro) {
    try {
        Connection conexion = ConexionDB.getConexion();
        String sql = "SELECT cantidad FROM libro WHERE titulo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, tituloLibro);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("cantidad");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al consultar stock: " + e.getMessage());
    }
    return 0; // Si no se encontró el libro o hay error
}

    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrestamos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibrosPrestamo = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbClientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbLibros = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAceptarCliente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        dateInicio = new com.toedter.calendar.JDateChooser();
        dateDevolucion = new com.toedter.calendar.JDateChooser();
        txtTotal = new javax.swing.JTextField();
        btnAceptarPrestamo = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAgregarLibro = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnAgregarAutores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrestamos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 142, 142), 2));
        panelPrestamos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Cliente");
        panelPrestamos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        tblLibrosPrestamo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblLibrosPrestamo);

        panelPrestamos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 760, 520));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        panelPrestamos.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelPrestamos.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));

        cmbClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelPrestamos.add(cmbClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 370, 30));

        jLabel2.setText("Libro");
        panelPrestamos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 30, -1));

        cmbLibros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelPrestamos.add(cmbLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 370, 30));
        panelPrestamos.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 220, 30));

        jLabel3.setText("Cantidad llevados");
        panelPrestamos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        btnAceptarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pulgar.png"))); // NOI18N
        btnAceptarCliente.setText("Aceptar");
        btnAceptarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarClienteActionPerformed(evt);
            }
        });
        panelPrestamos.add(btnAceptarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 142, 142));
        jLabel1.setText("Prestamo de libros Resumen");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 240, -1));

        jLabel5.setText("Cliente");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel7.setText("Cantidad total de libros");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel8.setText("Fecha de prestamo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel9.setText("Fecha de devolucion limite");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtCliente.setEnabled(false);
        jPanel1.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 380, -1));

        dateInicio.setEnabled(false);
        jPanel1.add(dateInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 340, -1));

        dateDevolucion.setEnabled(false);
        jPanel1.add(dateDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 300, -1));

        txtTotal.setEnabled(false);
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 320, -1));

        btnAceptarPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        btnAceptarPrestamo.setText("Aceptar prestamo");
        btnAceptarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarPrestamoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptarPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, -1));

        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 240, 450, 30));

        panelPrestamos.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 520, 330));

        jLabel4.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 142, 142));
        jLabel4.setText("Prestamos");
        jLabel4.setToolTipText("");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelPrestamos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 100, -1));

        btnAgregarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libroPrestado.png"))); // NOI18N
        btnAgregarLibro.setText("Agregar libro a prestamo");
        btnAgregarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLibroActionPerformed(evt);
            }
        });
        panelPrestamos.add(btnAgregarLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menos.png"))); // NOI18N
        btnQuitar.setText("Quitar libro");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        panelPrestamos.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/verPres.png"))); // NOI18N
        jButton1.setText("Ver Prestamos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelPrestamos.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        btnAgregarAutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        btnAgregarAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAutoresActionPerformed(evt);
            }
        });
        panelPrestamos.add(btnAgregarAutores, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 1461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLibroActionPerformed
       String libroSeleccionado = (String) cmbLibros.getSelectedItem();
    String cantidadTexto = txtCantidad.getText().trim();

    if (libroSeleccionado == null || libroSeleccionado.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Selecciona un libro.");
        return;
    }

    if (!Validacion.validarSoloNumeros(cantidadTexto)) {
        JOptionPane.showMessageDialog(this, "Ingresa una cantidad válida.");
        return;
    }

    int cantidad = Integer.parseInt(cantidadTexto);
    if (cantidad <= 0 || cantidad > 10) {
        JOptionPane.showMessageDialog(this, "La cantidad debe estar entre 1 y 10.");
        return;
    }

    // Verificar el total actual + lo que se quiere agregar
    int totalActual = Integer.parseInt(txtTotal.getText().isEmpty() ? "0" : txtTotal.getText());
    int nuevoTotal = totalActual + cantidad;

    if (nuevoTotal > 10) {
        lblError.setText("Agregar este libro haría un total de " + nuevoTotal + " libros. Máximo permitido: 10.");
        lblError.setForeground(Color.RED);
        lblError.setVisible(true);
        return; // Aquí evitamos agregar
    }

    int stockDisponible = obtenerStockDisponible(libroSeleccionado);
if (cantidad > stockDisponible) {
    JOptionPane.showMessageDialog(this, "Stock insuficiente. Solo hay " + stockDisponible + " unidades disponibles.");
    return;
}

    // Consultar libro con JOIN
    try {
        Connection conexion = ConexionDB.getConexion();
        String sql = "SELECT l.titulo, a.nombre AS autor, c.nombre AS categoria " +
                     "FROM libro l " +
                     "JOIN autor a ON l.idAutor = a.idAutor " +
                     "JOIN categoria c ON l.idCategoria = c.idCategoria " +
                     "WHERE l.titulo = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, libroSeleccionado);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String categoria = rs.getString("categoria");

                DefaultTableModel modelo = (DefaultTableModel) tblLibrosPrestamo.getModel();
                modelo.addRow(new Object[]{titulo, autor, categoria, cantidad});

                // Actualizar total y limpiar campos
                txtTotal.setText(String.valueOf(nuevoTotal));
                txtCantidad.setText("");
                lblError.setVisible(false);
                
                // ⚠️ Nuevo bloque para límite exacto
if (nuevoTotal == 10) {
    lblError.setText("Has alcanzado el máximo de 10 libros permitidos.");
    lblError.setForeground(Color.BLUE);
    lblError.setVisible(true);

    // Deshabilitar componentes de entrada
    cmbLibros.setEnabled(false);
    txtCantidad.setEnabled(false);
    btnAgregarLibro.setEnabled(false);
}
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo encontrar información del libro.");
            }
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al agregar libro: " + e.getMessage());
    }
    
    }//GEN-LAST:event_btnAgregarLibroActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAceptarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarClienteActionPerformed
        // TODO add your handling code here:
        if (cmbClientes.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Seleccione un cliente para continuar.");
        return;
    }

    // Habilitar controles de préstamo
    cmbLibros.setEnabled(true);
    txtCantidad.setEnabled(true);
    btnAgregarLibro.setEnabled(true);
    btnAceptarPrestamo.setEnabled(true);
    btnCancelar.setEnabled(true);
    btnQuitar.setEnabled(true);

    // Bloquear selección de cliente
    cmbClientes.setEnabled(false);
    btnAceptarCliente.setEnabled(false);
    
    if (cmbClientes.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Seleccione un cliente para continuar.");
        return;
    }

    // Habilitar controles
    cmbLibros.setEnabled(true);
    txtCantidad.setEnabled(true);
    btnAgregarLibro.setEnabled(true);
    btnAceptarPrestamo.setEnabled(true);
    btnCancelar.setEnabled(true);


    // Bloquear selección de cliente
    cmbClientes.setEnabled(false);
    btnAceptarCliente.setEnabled(false);

    // Establecer fechas
    Date hoy = new Date();
    dateInicio.setDate(hoy);

    Calendar cal = Calendar.getInstance();
    cal.setTime(hoy);
    cal.add(Calendar.MONTH, 1);
    dateDevolucion.setDate(cal.getTime());
    }//GEN-LAST:event_btnAceptarClienteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
          // Habilitar cliente
    cmbClientes.setEnabled(true);
    btnAceptarCliente.setEnabled(true);

    // Deshabilitar todos los controles de préstamo
    cmbLibros.setEnabled(false);
    txtCantidad.setEnabled(false);
    btnAgregarLibro.setEnabled(false);
    btnAceptarPrestamo.setEnabled(false);
    btnCancelar.setEnabled(false);
    btnQuitar.setEnabled(false);

    // Limpiar campos visuales si es necesario
    txtCantidad.setText("");
    txtTotal.setText("");
    lblError.setVisible(false);

    // Limpiar tabla de libros agregados
    DefaultTableModel modelo = (DefaultTableModel) tblLibrosPrestamo.getModel();
    modelo.setRowCount(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tblLibrosPrestamo.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona una fila para quitar.");
        return;
    }

    DefaultTableModel modelo = (DefaultTableModel) tblLibrosPrestamo.getModel();
    int cantidad = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 3).toString());
    modelo.removeRow(filaSeleccionada);

    // Actualizar total
    int totalActual = Integer.parseInt(txtTotal.getText());
    int nuevoTotal = totalActual - cantidad;
    txtTotal.setText(String.valueOf(nuevoTotal));

    // Si estaba bloqueado por exceso, desbloqueamos
    if (nuevoTotal < 10) {
        lblError.setVisible(false);
        cmbLibros.setEnabled(true);
        txtCantidad.setEnabled(true);
        btnAgregarLibro.setEnabled(true);
    }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnAceptarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarPrestamoActionPerformed
        // TODO add your handling code here:
        int totalLibros = Integer.parseInt(txtTotal.getText().isEmpty() ? "0" : txtTotal.getText());

    if (totalLibros == 0) {
        JOptionPane.showMessageDialog(this, "Debes agregar al menos un libro al préstamo.");
        return;
    }

    String clienteNombre = (String) cmbClientes.getSelectedItem();
    Date fechaInicio = (Date) dateInicio.getDate();
    Date fechaFin = (Date) dateDevolucion.getDate();

    if (clienteNombre == null || fechaInicio == null || fechaFin == null) {
        JOptionPane.showMessageDialog(this, "Datos incompletos del préstamo.");
        return;
    }

    // Crear objeto Prestamo
    Prestamo prestamo = new Prestamo(totalLibros, fechaInicio, fechaFin, "Pendiente");

    // Construir lista de detalle
    List<DetallePrestamo> listaDetalles = new ArrayList<>();
    DefaultTableModel modelo = (DefaultTableModel) tblLibrosPrestamo.getModel();

    for (int i = 0; i < modelo.getRowCount(); i++) {
        String tituloLibro = modelo.getValueAt(i, 0).toString();
        int cantidad = Integer.parseInt(modelo.getValueAt(i, 3).toString());

        listaDetalles.add(new DetallePrestamo(clienteNombre, tituloLibro, cantidad));
    }

    // Registrar en base de datos
    try {
        Connection conn = ConexionDB.getConexion();
        PrestamoControlador pc = new PrestamoControlador(conn);

        boolean registrado = pc.registrarPrestamo(prestamo, listaDetalles);
        if (registrado) {
            JOptionPane.showMessageDialog(this, "Préstamo registrado exitosamente.");
            limpiarFormularioPrestamo();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo registrar el préstamo.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_btnAceptarPrestamoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         HistorialPrestamo verPrestamo= new HistorialPrestamo();
        verPrestamo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        verPrestamo.addWindowListener(new WindowAdapter() {
        });
        
        verPrestamo.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAgregarAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAutoresActionPerformed
        // TODO add your handling code here:
        FrmCliente frmC = new FrmCliente();
        frmC.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmC.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // recarga combos después de cerrar
                cargarClientesEnCombo();    // recarga autores
            }
        });
        frmC.setVisible(true);
    }//GEN-LAST:event_btnAgregarAutoresActionPerformed

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
            java.util.logging.Logger.getLogger(HacerPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HacerPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HacerPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HacerPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HacerPrestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarCliente;
    private javax.swing.JButton btnAceptarPrestamo;
    private javax.swing.JButton btnAgregarAutores;
    private javax.swing.JButton btnAgregarLibro;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JComboBox<String> cmbLibros;
    private com.toedter.calendar.JDateChooser dateDevolucion;
    private com.toedter.calendar.JDateChooser dateInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JPanel panelPrestamos;
    private javax.swing.JTable tblLibrosPrestamo;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
