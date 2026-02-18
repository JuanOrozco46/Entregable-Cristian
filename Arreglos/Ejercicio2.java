package Arreglos;

public class Ejercicio2 {
    public static void main(String[] args) {
        double[] notas = {3.5, 4.0, 5.0, 2.5};
        double suma = 0;
        
        for (double nota : notas) {
            suma += nota;
        }
        System.out.println("El promedio es: " + (suma / notas.length));
    }
}
    

