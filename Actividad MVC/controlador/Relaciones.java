package controlador;

import modelo.Procesos;
import vista.VentanaAcercaDe;
import vista.VentanaConsulta;
import vista.VentanaRegistro;

// Clase encargada de establecer las conexiones entre todas las partes del proyecto
public class Relaciones {
    public void iniciar() {
        // Creamos las instancias de cada clase necesaria para que el programa funcione
        Coordinador miCoordinador = new Coordinador();
        Procesos miProcesos = new Procesos();
        VentanaRegistro miVentanaRegistro = new VentanaRegistro();
        VentanaConsulta miVentanaConsulta = new VentanaConsulta();
        VentanaAcercaDe miVentanaAcercaDe = new VentanaAcercaDe();

        // Le entregamos al coordinador las referencias de las ventanas y del modelo procesador
        miCoordinador.setRelaciones(miProcesos, miVentanaRegistro, miVentanaConsulta, miVentanaAcercaDe);
        
        // Configuramos el coordinador en cada ventana para que puedan navegar y guardar datos
        miVentanaRegistro.setCoordinador(miCoordinador);
        miVentanaConsulta.setCoordinador(miCoordinador);
        miVentanaAcercaDe.setCoordinador(miCoordinador);

        // Iniciamos el programa mostrando la primera ventana de registro
        miCoordinador.mostrarRegistro();
    }
}
