package ListaArreglos;

import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Estudiar Java");
        lista.add("Dormir");
        lista.remove("Estudiar Java"); // Ya terminamos
        System.out.println("Pendiente: " + lista);
    }
}
