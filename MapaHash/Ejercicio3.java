package MapaHash;

import java.util.HashMap;

public class Ejercicio3 {
    public static void main(String[] args) {
        HashMap<Integer, String> empleados = new HashMap<>();
        empleados.put(101, "Ana");
        
        if (empleados.containsKey(101)) {
            System.out.println("El empleado 101 existe.");
        }
    }
}
//h