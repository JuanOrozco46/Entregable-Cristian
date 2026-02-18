package Arreglos;
public class Ejercicio1 {
    public static void main(String[] args) {
        int[] a = {10, 20, 30};
        int[] b = {5, 10, 15};
        int[] suma = new int[3];

        System.out.println("Suma de arreglos:");
        for (int i = 0; i < a.length; i++) {
            suma[i] = a[i] + b[i];
            System.out.println("Pos " + i + ": " + suma[i]);
        }
    }
}