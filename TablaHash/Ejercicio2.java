package TablaHash;

import java.util.Hashtable;

public class Ejercicio2 {
    public static void main(String[] args) {
        Hashtable<Integer, Double> precios = new Hashtable<>();
        precios.put(1, 1500.0);
        precios.put(2, 2000.0);
        
        System.out.println("Precio producto 1: " + precios.get(1));
    }
}
