import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Ventana principal de la aplicación. Extiende JFrame (herencia de POO)
public class TiendaApp extends JFrame {

    // Campos del formulario - cliente
    private JTextField txtNombre, txtApellido, txtEdad, txtTelefono;
    private JComboBox<String> cmbTipo; // Lista desplegable con los tipos A, B, C

    // Campos del formulario - producto
    private JTextField txtProducto, txtValorUnitario, txtCantidad;

    // Etiquetas donde se muestran los resultados de la compra
    private JLabel lblResultNombre, lblResultTipo, lblResultTotalBruto;
    private JLabel lblResultDescuento, lblResultTotalFinal;

    private JPanel panelResultados; // Panel de resultados (se muestra/oculta)

    public TiendaApp() {
        setTitle("Tienda DON APARATO");
        setSize(520, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        panelPrincipal.setBackground(new Color(245, 245, 245));

        // Título
        JLabel titulo = new JLabel("Tienda DON APARATO", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(new Color(30, 90, 160));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(titulo);
        panelPrincipal.add(Box.createVerticalStrut(15));

        // Sección: datos del cliente
        panelPrincipal.add(crearEncabezado("Datos del Cliente"));
        txtNombre   = new JTextField();
        txtApellido = new JTextField();
        txtEdad     = new JTextField();
        txtTelefono = new JTextField();
        cmbTipo     = new JComboBox<>(new String[]{"Sin tipo", "A", "B", "C"});
        panelPrincipal.add(crearFila("Nombre:",    txtNombre));
        panelPrincipal.add(crearFila("Apellido:",  txtApellido));
        panelPrincipal.add(crearFila("Edad:",      txtEdad));
        panelPrincipal.add(crearFila("Teléfono:",  txtTelefono));
        panelPrincipal.add(crearFila("Tipo:",      cmbTipo));
        panelPrincipal.add(Box.createVerticalStrut(10));

        // Sección: datos del producto
        panelPrincipal.add(crearEncabezado("Datos del Producto"));
        txtProducto      = new JTextField();
        txtValorUnitario = new JTextField();
        txtCantidad      = new JTextField();
        panelPrincipal.add(crearFila("Producto:",       txtProducto));
        panelPrincipal.add(crearFila("Valor unitario:", txtValorUnitario));
        panelPrincipal.add(crearFila("Cantidad:",       txtCantidad));
        panelPrincipal.add(Box.createVerticalStrut(12));

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.setBackground(new Color(245, 245, 245));
        JButton btnComprar = crearBoton("Realizar Compra",       new Color(30, 120, 60));
        JButton btnMostrar = crearBoton("Mostrar Datos Usuario", new Color(30, 90, 160));
        JButton btnLimpiar = crearBoton("Limpiar",               new Color(180, 50, 50));
        panelBotones.add(btnComprar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnLimpiar);
        panelPrincipal.add(panelBotones);
        panelPrincipal.add(Box.createVerticalStrut(15));

        // Panel de resultados (empieza oculto)
        panelResultados = new JPanel(new GridLayout(5, 1, 0, 4));
        panelResultados.setBorder(BorderFactory.createTitledBorder("Resultado de la Compra"));
        panelResultados.setBackground(Color.WHITE);
        lblResultNombre     = new JLabel();
        lblResultTipo       = new JLabel();
        lblResultTotalBruto = new JLabel();
        lblResultDescuento  = new JLabel();
        lblResultTotalFinal = new JLabel();
        for (JLabel lbl : new JLabel[]{lblResultNombre, lblResultTipo,
                lblResultTotalBruto, lblResultDescuento, lblResultTotalFinal}) {
            lbl.setFont(new Font("Arial", Font.PLAIN, 13));
            panelResultados.add(lbl);
        }
        panelResultados.setVisible(false);
        panelPrincipal.add(panelResultados);

        add(new JScrollPane(panelPrincipal));

        // Eventos de los botones
        btnComprar.addActionListener(e -> realizarCompra());
        btnMostrar.addActionListener(e -> mostrarDatosUsuario());
        btnLimpiar.addActionListener(e -> limpiarFormulario());
    }

    // Valida campos, crea los objetos Cliente y Producto, y muestra los resultados
    private void realizarCompra() {
        if (txtNombre.getText().trim().isEmpty() || txtProducto.getText().trim().isEmpty()
                || txtValorUnitario.getText().trim().isEmpty() || txtCantidad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            String tipo = cmbTipo.getSelectedItem().toString().equals("Sin tipo") ? "" : cmbTipo.getSelectedItem().toString();

            // Se crean los objetos usando las clases Cliente y Producto (POO)
            Cliente  cliente  = new Cliente(txtNombre.getText().trim(), txtApellido.getText().trim(),
                                            Integer.parseInt(txtEdad.getText().trim()),
                                            txtTelefono.getText().trim(), tipo);
            Producto producto = new Producto(txtProducto.getText().trim(),
                                             Double.parseDouble(txtValorUnitario.getText().trim()),
                                             Integer.parseInt(txtCantidad.getText().trim()));

            double totalBruto  = producto.getTotalBruto();
            double porcDesc    = cliente.getPorcentajeDescuento();
            double valorDesc   = totalBruto * porcDesc;
            double totalFinal  = totalBruto - valorDesc;

            String textoDesc = (porcDesc == 0) ? "No se le realiza descuento"
                    : String.format("$ %.2f  (%.0f%%)", valorDesc, porcDesc * 100);

            lblResultNombre.setText("Cliente: "       + cliente.getNombreCompleto());
            lblResultTipo.setText("Tipo: "            + cliente.getTipo());
            lblResultTotalBruto.setText(String.format("Total bruto: $ %.2f", totalBruto));
            lblResultDescuento.setText("Descuento: "  + textoDesc);
            lblResultTotalFinal.setText(String.format("Total a pagar: $ %.2f", totalFinal));
            panelResultados.setVisible(true);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad, valor unitario y cantidad deben ser números.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Muestra los datos básicos ingresados en un cuadro de diálogo
    private void mostrarDatosUsuario() {
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Los campos se encuentran vacíos.", "Sin datos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String msg = "Nombre:   " + txtNombre.getText().trim() + "\n"
                   + "Apellido: " + txtApellido.getText().trim() + "\n"
                   + "Edad:     " + txtEdad.getText().trim() + "\n"
                   + "Teléfono: " + txtTelefono.getText().trim() + "\n"
                   + "Tipo:     " + cmbTipo.getSelectedItem();
        JOptionPane.showMessageDialog(this, msg, "Datos del Usuario", JOptionPane.INFORMATION_MESSAGE);
    }

    // Limpia todos los campos y oculta el panel de resultados
    private void limpiarFormulario() {
        for (JTextField tf : new JTextField[]{txtNombre, txtApellido, txtEdad,
                txtTelefono, txtProducto, txtValorUnitario, txtCantidad}) {
            tf.setText("");
        }
        cmbTipo.setSelectedIndex(0);
        panelResultados.setVisible(false);
    }

    // Crea una fila: etiqueta a la izquierda + campo a la derecha
    private JPanel crearFila(String etiqueta, JComponent campo) {
        JPanel fila = new JPanel(new BorderLayout(8, 0));
        fila.setBackground(new Color(245, 245, 245));
        fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        JLabel lbl = new JLabel(etiqueta);
        lbl.setPreferredSize(new Dimension(130, 25));
        lbl.setFont(new Font("Arial", Font.PLAIN, 13));
        fila.add(lbl, BorderLayout.WEST);
        fila.add(campo, BorderLayout.CENTER);
        return fila;
    }

    private JLabel crearEncabezado(String texto) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("Arial", Font.BOLD, 14));
        lbl.setForeground(new Color(30, 90, 160));
        lbl.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(180, 200, 230)));
        lbl.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        return lbl;
    }

    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return boton;
    }

    // Punto de entrada: lanza la ventana en el hilo de Swing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TiendaApp().setVisible(true));
    }
}
