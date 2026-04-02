import javax.swing.*;        // Librería principal de Java Swing para crear ventanas
import java.awt.*;           // Para manejar colores, fuentes y layouts
import java.awt.event.*;     // Para escuchar eventos de los botones

// Clase principal que extiende JFrame (herencia de POO)
// Al extender JFrame, esta clase ES una ventana de Swing
public class TiendaApp extends JFrame {

    // ── Campos del formulario del CLIENTE ──────────────────────────────────
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEdad;
    private JTextField txtTelefono;
    // JComboBox permite seleccionar una opción de una lista desplegable
    private JComboBox<String> cmbTipo;

    // ── Campos del formulario del PRODUCTO ─────────────────────────────────
    private JTextField txtProducto;
    private JTextField txtValorUnitario;
    private JTextField txtCantidad;

    // ── Etiquetas de resultados (se muestran al hacer la compra) ───────────
    private JLabel lblResultNombre;
    private JLabel lblResultTipo;
    private JLabel lblResultTotalBruto;
    private JLabel lblResultDescuento;
    private JLabel lblResultTotalFinal;

    // Panel que agrupa los resultados (para ocultarlos/mostrarlos fácilmente)
    private JPanel panelResultados;

    // ── Constructor: aquí se construye toda la interfaz gráfica ───────────
    public TiendaApp() {
        // Configuración básica de la ventana
        setTitle("Tienda DON APARATO");
        setSize(520, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la app al cerrar la ventana
        setLocationRelativeTo(null);                    // Centra la ventana en la pantalla
        setResizable(false);                            // La ventana no se puede redimensionar

        // Panel principal con margen interno
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS)); // Apila componentes verticalmente
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        panelPrincipal.setBackground(new Color(245, 245, 245));

        // ── Título ─────────────────────────────────────────────────────────
        JLabel titulo = new JLabel("🛒 Tienda DON APARATO", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(new Color(30, 90, 160));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(titulo);
        panelPrincipal.add(Box.createVerticalStrut(15)); // Espacio vertical

        // ── Sección DATOS DEL CLIENTE ──────────────────────────────────────
        panelPrincipal.add(crearEncabezado("Datos del Cliente"));

        // Se crean los campos de texto y se agregan al panel
        txtNombre    = new JTextField();
        txtApellido  = new JTextField();
        txtEdad      = new JTextField();
        txtTelefono  = new JTextField();
        // Opciones del ComboBox: "Sin tipo" y los tipos A, B, C
        cmbTipo = new JComboBox<>(new String[]{"Sin tipo", "A", "B", "C"});

        panelPrincipal.add(crearFila("Nombre:",     txtNombre));
        panelPrincipal.add(crearFila("Apellido:",   txtApellido));
        panelPrincipal.add(crearFila("Edad:",       txtEdad));
        panelPrincipal.add(crearFila("Teléfono:",   txtTelefono));
        panelPrincipal.add(crearFila("Tipo:",       cmbTipo));
        panelPrincipal.add(Box.createVerticalStrut(10));

        // ── Sección DATOS DEL PRODUCTO ─────────────────────────────────────
        panelPrincipal.add(crearEncabezado("Datos del Producto"));

        txtProducto      = new JTextField();
        txtValorUnitario = new JTextField();
        txtCantidad      = new JTextField();

        panelPrincipal.add(crearFila("Producto:",       txtProducto));
        panelPrincipal.add(crearFila("Valor unitario:", txtValorUnitario));
        panelPrincipal.add(crearFila("Cantidad:",       txtCantidad));
        panelPrincipal.add(Box.createVerticalStrut(12));

        // ── Panel de BOTONES ───────────────────────────────────────────────
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.setBackground(new Color(245, 245, 245));

        JButton btnComprar  = crearBoton("Realizar Compra",       new Color(30, 120, 60));
        JButton btnMostrar  = crearBoton("Mostrar Datos Usuario", new Color(30, 90, 160));
        JButton btnLimpiar  = crearBoton("Limpiar",               new Color(180, 50, 50));

        panelBotones.add(btnComprar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnLimpiar);
        panelPrincipal.add(panelBotones);
        panelPrincipal.add(Box.createVerticalStrut(15));

        // ── Panel de RESULTADOS ────────────────────────────────────────────
        panelResultados = new JPanel();
        panelResultados.setLayout(new GridLayout(5, 1, 0, 4)); // 5 filas, 1 columna
        panelResultados.setBorder(BorderFactory.createTitledBorder("Resultado de la Compra"));
        panelResultados.setBackground(Color.WHITE);

        lblResultNombre     = new JLabel();
        lblResultTipo       = new JLabel();
        lblResultTotalBruto = new JLabel();
        lblResultDescuento  = new JLabel();
        lblResultTotalFinal = new JLabel();

        // Estilo uniforme para todas las etiquetas de resultado
        for (JLabel lbl : new JLabel[]{lblResultNombre, lblResultTipo,
                lblResultTotalBruto, lblResultDescuento, lblResultTotalFinal}) {
            lbl.setFont(new Font("Arial", Font.PLAIN, 13));
            panelResultados.add(lbl);
        }

        // El panel de resultados comienza oculto
        panelResultados.setVisible(false);
        panelPrincipal.add(panelResultados);

        // Agregamos el panel principal a la ventana con scroll por si el contenido es largo
        add(new JScrollPane(panelPrincipal));

        // ── EVENTOS de los botones ─────────────────────────────────────────

        // Botón REALIZAR COMPRA
        btnComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarCompra();
            }
        });

        // Botón MOSTRAR DATOS DEL USUARIO
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarDatosUsuario();
            }
        });

        // Botón LIMPIAR
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });
    }

    // ── Método que procesa la compra ───────────────────────────────────────
    private void realizarCompra() {
        // Validar que los campos no estén vacíos
        if (txtNombre.getText().trim().isEmpty() || txtApellido.getText().trim().isEmpty()
                || txtProducto.getText().trim().isEmpty()
                || txtValorUnitario.getText().trim().isEmpty()
                || txtCantidad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor complete todos los campos antes de realizar la compra.",
                    "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return; // Se detiene si hay campos vacíos
        }

        try {
            // Leer datos del formulario y crear los objetos de POO
            String nombre    = txtNombre.getText().trim();
            String apellido  = txtApellido.getText().trim();
            int    edad      = Integer.parseInt(txtEdad.getText().trim());
            String telefono  = txtTelefono.getText().trim();
            String tipo      = cmbTipo.getSelectedItem().toString();
            // Si seleccionó "Sin tipo", se guarda como cadena vacía
            if (tipo.equals("Sin tipo")) tipo = "";

            // Crear objeto Cliente usando la clase Cliente (POO)
            Cliente cliente = new Cliente(nombre, apellido, edad, telefono, tipo);

            String productoNombre = txtProducto.getText().trim();
            double valorUnitario  = Double.parseDouble(txtValorUnitario.getText().trim());
            int    cantidad       = Integer.parseInt(txtCantidad.getText().trim());

            // Crear objeto Producto usando la clase Producto (POO)
            Producto producto = new Producto(productoNombre, valorUnitario, cantidad);

            // Calcular valores usando los métodos de las clases
            double totalBruto  = producto.getTotalBruto();
            double porcDesc    = cliente.getPorcentajeDescuento();
            double valorDesc   = totalBruto * porcDesc;
            double totalFinal  = totalBruto - valorDesc;

            // Preparar el texto del descuento
            String textoDescuento;
            if (porcDesc == 0) {
                textoDescuento = "No se le realiza descuento";
            } else {
                textoDescuento = String.format("$ %.2f  (%.0f%%)", valorDesc, porcDesc * 100);
            }

            // Mostrar los resultados actualizando las etiquetas
            lblResultNombre.setText("👤 Cliente: " + cliente.getNombreCompleto());
            lblResultTipo.setText("🏷 Tipo: " + cliente.getTipo());
            lblResultTotalBruto.setText(String.format("💰 Total bruto: $ %.2f", totalBruto));
            lblResultDescuento.setText("🔖 Descuento: " + textoDescuento);
            lblResultTotalFinal.setText(String.format("✅ Total a pagar: $ %.2f", totalFinal));

            // Hacer visible el panel de resultados
            panelResultados.setVisible(true);

        } catch (NumberFormatException ex) {
            // Si el usuario escribe texto donde debería ir un número
            JOptionPane.showMessageDialog(this,
                    "Edad, valor unitario y cantidad deben ser números válidos.",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ── Método que muestra los datos básicos del usuario ───────────────────
    private void mostrarDatosUsuario() {
        // Si el nombre está vacío, se asume que no se han ingresado datos
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Los campos se encuentran vacíos.",
                    "Sin datos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Construir el mensaje con los datos actuales del formulario
        String tipo = cmbTipo.getSelectedItem().toString();
        String mensaje =
                "Nombre:    " + txtNombre.getText().trim() + "\n" +
                "Apellido:  " + txtApellido.getText().trim() + "\n" +
                "Edad:      " + txtEdad.getText().trim() + "\n" +
                "Teléfono:  " + txtTelefono.getText().trim() + "\n" +
                "Tipo:      " + tipo;

        JOptionPane.showMessageDialog(this, mensaje, "Datos del Usuario",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // ── Método que limpia el formulario y oculta los resultados ───────────
    private void limpiarFormulario() {
        // Limpiar todos los campos de texto
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        txtProducto.setText("");
        txtValorUnitario.setText("");
        txtCantidad.setText("");

        // Resetear el combo a la primera opción
        cmbTipo.setSelectedIndex(0);

        // Ocultar el panel de resultados
        panelResultados.setVisible(false);
    }

    // ── Método auxiliar: crea una fila de etiqueta + campo ─────────────────
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

    // ── Método auxiliar: crea un encabezado de sección ─────────────────────
    private JLabel crearEncabezado(String texto) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("Arial", Font.BOLD, 14));
        lbl.setForeground(new Color(30, 90, 160));
        lbl.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(180, 200, 230)));
        lbl.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        return lbl;
    }

    // ── Método auxiliar: crea un botón con color personalizado ─────────────
    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // El cursor cambia al pasar el mouse
        return boton;
    }

    // ── Método main: punto de entrada de la aplicación ─────────────────────
    public static void main(String[] args) {
        // SwingUtilities.invokeLater garantiza que la ventana se cree en el hilo correcto
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TiendaApp().setVisible(true); // Crear la ventana y hacerla visible
            }
        });
    }
}
