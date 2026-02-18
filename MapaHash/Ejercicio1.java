package MapaHash;

import java.util.HashMap;

public class Ejercicio1 {
    public static void main(String[] args) {
        HashMap<String, String> dic = new HashMap<>();
        dic.put("Hello", "Hola");
        dic.put("Bye", "Adiós");
        System.out.println("Hello en español: " + dic.get("Hello"));
    }
}
