package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import modelo.dto.PersonaDTO;
import controlador.Coordinador;

// Clase que visualiza la informacion procesada y los resultados finales
// Implementa ActionListener para gestionar el retorno al menu principal
public class VentanaConsulta extends JFrame implements ActionListener {
    public JLabel lblNombre, lblEdad, lblPeso, lblEstatura, lblIMC, lblEstado;
    public JButton btnRegresar;
    private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    public VentanaConsulta() {
        //visual de la pantalla de consulta de resultados
        setTitle("Resultados del Analisis Corporal");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 5, 5));

        //etiquetas
        add(new JLabel(" Nombre Registrado:"));
        lblNombre = new JLabel("-");
        add(lblNombre);

        add(new JLabel(" Edad Ingresada:"));
        lblEdad = new JLabel("-");
        add(lblEdad);

        add(new JLabel(" Peso Actual:"));
        lblPeso = new JLabel("-");
        add(lblPeso);

        add(new JLabel(" Estatura Actual:"));
        lblEstatura = new JLabel("-");
        add(lblEstatura);

        add(new JLabel(" Indice de Masa Corporal:"));
        lblIMC = new JLabel("-");
        add(lblIMC);

        add(new JLabel(" Estado de Salud:"));
        lblEstado = new JLabel("-");
        add(lblEstado);

        btnRegresar = new JButton("Regresar al Menu");
        btnRegresar.addActionListener(this);
        add(btnRegresar);
    }

    // Gestion de eventos para la navegacion de regreso
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegresar) {
            miCoordinador.mostrarRegistro();
        }
    }

    //encargado de actualizar el contenido de la ventana con la informacion real
    public void mostrarDatos(PersonaDTO persona, double imc, String estado) {
        lblNombre.setText(persona.getNombre());
        lblEdad.setText(String.valueOf(persona.getEdad()));
        lblPeso.setText(persona.getPeso() + " kg");
        lblEstatura.setText(persona.getEstatura() + " m");
        lblIMC.setText(String.format("%.2f", imc));
        lblEstado.setText(estado);
    }
}
