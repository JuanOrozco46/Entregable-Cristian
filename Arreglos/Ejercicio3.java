package Arreglos;

public class Ejercicio3 {
    public static void main(String[] args) {
        int[] numeros = {100, 200, 300};
        int buscar = 200;
        boolean encontrado = false;

        for (int n : numeros) {
            if (n == buscar) encontrado = true;
        }
        System.out.println("¿Número encontrado?: " + encontrado);
    }
    
}
