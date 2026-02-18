package TablaHash;

import java.util.Hashtable;

public class Ejercicio3 {
    public static void main(String[] args) {
        Hashtable<String, String> agenda = new Hashtable<>();
        agenda.put("Juan", "3001234567");
        agenda.remove("Juan"); // Borrar contacto
        System.out.println("Agenda vacía: " + agenda.isEmpty());
    }
}
