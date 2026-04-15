package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controlador.Coordinador;

// Ventana de informacion sobre los desarrolladores
public class VentanaAcercaDe extends JFrame implements ActionListener {
    public JButton btnRegresar;
    private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    public VentanaAcercaDe() {
        setTitle("Acerca de");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblInfo = new JLabel("<html><center>Calculadora IMC<br>Desarrollado por: Juan Manuel Orozco<br>Analisis y desarrollo de software<br>12 Abril del 2026</center></html>", SwingConstants.CENTER);
        add(lblInfo, BorderLayout.CENTER);

        btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(this);
        add(btnRegresar, BorderLayout.SOUTH);
    }

    // Gestion de eventos para regresar al menu principal
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegresar) {
            miCoordinador.mostrarRegistro();
        }
    }
}