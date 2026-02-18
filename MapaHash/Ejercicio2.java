package MapaHash;

import java.util.HashMap;

public class Ejercicio2 {
    public static void main(String[] args) {
        HashMap<String, String> caps = new HashMap<>();
        caps.put("Colombia", "Bogotá");
        caps.put("Narnia", null); // HashMap permite esto, HashTable no
        System.out.println("Mapa: " + caps);
    }
}
