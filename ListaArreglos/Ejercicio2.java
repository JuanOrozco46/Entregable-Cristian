package ListaArreglos;

import java.util.ArrayList;

public class Ejercicio2 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(5); numeros.add(15); numeros.add(8); numeros.add(20);

        System.out.print("Mayores a 10: ");
        for (int n : numeros) {
            if (n > 10) System.out.print(n + " ");
        }
    }
}
