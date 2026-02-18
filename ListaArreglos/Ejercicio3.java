package ListaArreglos;

import java.util.ArrayList;

public class Ejercicio3 {
    public static void main(String[] args) {
        ArrayList<String> autos = new ArrayList<>();
        autos.add("Mazda");
        autos.add("Renault");
        autos.clear(); // Borra todo
        System.out.println("Total autos: " + autos.size());
    }
}
