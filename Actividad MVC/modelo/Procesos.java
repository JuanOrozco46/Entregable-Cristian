package modelo;

import modelo.dto.PersonaDTO;
import java.util.ArrayList;

// Clase encargada de realizar todos los calculos matematicos y logicos del sistema
// Ahora tambien gestiona el almacenamiento temporal de datos mediante un ArrayList
public class Procesos {

    private ArrayList<PersonaDTO> listaPersonas;

    public Procesos() {
        this.listaPersonas = new ArrayList<>();
    }

    // Metodo para guardar una nueva persona en la lista
    public void registrarPersona(PersonaDTO persona) {
        listaPersonas.add(persona);
    }

    // Metodo para obtener la ultima persona registrada
    public PersonaDTO consultarUltimaPersona() {
        if (listaPersonas.isEmpty()) return null;
        return listaPersonas.get(listaPersonas.size() - 1);
    }

    // Metodo que recibe un objeto con datos y calcula el indice de masa corporal
    public double calcularIMC(PersonaDTO persona) {
        if (persona.getEstatura() <= 0) return 0;
        return persona.getPeso() / (persona.getEstatura() * persona.getEstatura());
    }

    // Metodo que determina el estado de salud de la persona basandose en el valor del IMC calculado
    public String obtenerEstado(PersonaDTO persona) {
        double imc = calcularIMC(persona);
        if (imc < 18.5) return "Bajo de peso";
        if (imc < 25.0) return "Rango normal";
        if (imc < 30.0) return "Tienes sobrepeso";
        return "obesidad";
    }
}
