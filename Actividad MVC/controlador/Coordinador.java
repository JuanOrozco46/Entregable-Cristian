package controlador;

import modelo.Procesos;
import modelo.dto.PersonaDTO;
import vista.VentanaAcercaDe;
import vista.VentanaConsulta;
import vista.VentanaRegistro;

// Controla el flujo de la aplicacion decidiendo que ventana mostrar y delegando procesos
public class Coordinador {
    private Procesos miProcesos;
    private VentanaRegistro miVentanaRegistro;
    private VentanaConsulta miVentanaConsulta;
    private VentanaAcercaDe miVentanaAcercaDe;

    public Coordinador() {
    }

    //recibir y guardar las referencias de los demas componentes del sistema
    public void setRelaciones(Procesos p, VentanaRegistro vr, VentanaConsulta vc, VentanaAcercaDe va) {
        this.miProcesos = p;
        this.miVentanaRegistro = vr;
        this.miVentanaConsulta = vc;
        this.miVentanaAcercaDe = va;
    }

    public VentanaRegistro getVentanaRegistro() { return miVentanaRegistro; }
    public VentanaConsulta getVentanaConsulta() { return miVentanaConsulta; }
    public VentanaAcercaDe getVentanaAcercaDe() { return miVentanaAcercaDe; }

    //oculta las demas ventanas y deja visible el formulario de registro
    public void mostrarRegistro() {
        miVentanaConsulta.setVisible(false);
        miVentanaAcercaDe.setVisible(false);
        miVentanaRegistro.setVisible(true);
    }

    //recupera la informacion guardada para presentarla en la pantalla de consulta
    //realiza los calculos necesarios mediante la clase Procesos
    public void mostrarConsulta() {
        PersonaDTO datos = miProcesos.consultarUltimaPersona();
        if (datos != null) {
            miVentanaRegistro.setVisible(false);
            miVentanaConsulta.mostrarDatos(datos, miProcesos.calcularIMC(datos), miProcesos.obtenerEstado(datos));
            miVentanaConsulta.setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Todavia no se han registrado datos de ninguna persona");
        }
    }

    //muestra la ventana con la informacion de los desarrolladores
    public void mostrarAcercaDe() {
        miVentanaRegistro.setVisible(false);
        miVentanaAcercaDe.setVisible(true);
    }

    // Metodo para delegar el guardado de la informacion a la clase Procesos
    public void guardarPersona(PersonaDTO dto) {
        miProcesos.registrarPersona(dto);
    }
}
