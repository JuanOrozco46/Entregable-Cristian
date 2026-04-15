package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import modelo.dto.PersonaDTO;
import controlador.Coordinador;

// Clase que representa la interfaz grafica para la entrada de datos inicial
// Ahora implementa ActionListener para gestionar sus propios eventos de usuario
public class VentanaRegistro extends JFrame implements ActionListener {
    public JTextField txtNombre, txtEdad, txtPeso, txtEstatura;
    public JButton btnGuardar, btnIrAConsulta, btnIrAAcercaDe;
    private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    public VentanaRegistro() {
        // Configuraciones principales de la ventana como titulo tamano y cierre
        setTitle("Formulario de Registro de Salud");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 5, 5));

        // Creacion y adicion de los componentes de entrada de datos
        add(new JLabel(" Nombre Completo:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel(" Edad del Paciente:"));
        txtEdad = new JTextField();
        add(txtEdad);

        add(new JLabel(" Peso en Kilogramos:"));
        txtPeso = new JTextField();
        add(txtPeso);

        add(new JLabel(" Estatura en Metros:"));
        txtEstatura = new JTextField();
        add(txtEstatura);

        // Inicializacion de los botones de accion y navegacion
        btnGuardar = new JButton("Guardar Informacion");
        btnGuardar.addActionListener(this);
        add(btnGuardar);

        btnIrAConsulta = new JButton("Consultar Resultados");
        btnIrAConsulta.addActionListener(this);
        add(btnIrAConsulta);

        btnIrAAcercaDe = new JButton("Acerca de nosotros");
        btnIrAAcercaDe.addActionListener(this);
        add(btnIrAAcercaDe);
    }

    // Gestion de eventos de los botones de la ventana
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
            recolectarYGuardar();
        } else if (e.getSource() == btnIrAConsulta) {
            miCoordinador.mostrarConsulta();
        } else if (e.getSource() == btnIrAAcercaDe) {
            miCoordinador.mostrarAcercaDe();
        }
    }

    // Tomar los datos de la interfaz de usuario, validarlos y enviarlos al coordinador
    private void recolectarYGuardar() {
        try {
            String nom = txtNombre.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            double peso = Double.parseDouble(txtPeso.getText());
            double est = Double.parseDouble(txtEstatura.getText());

            if (edad > 0 && peso > 0 && est > 0) {
                PersonaDTO dto = new PersonaDTO();
                dto.setNombre(nom);
                dto.setEdad(edad);
                dto.setPeso(peso);
                dto.setEstatura(est);
                
                miCoordinador.guardarPersona(dto);
                JOptionPane.showMessageDialog(null, "La informacion se ha guardado exitosamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Debes ingresar valores positivos mayores a cero");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Por favor verifica que la edad el peso y la estatura sean numeros");
        }
    }

    // Metodo auxiliar para limpiar los campos despues de un guardado exitoso
    public void limpiar() {
        txtNombre.setText("");
        txtEdad.setText("");
        txtPeso.setText("");
        txtEstatura.setText("");
    }
}
