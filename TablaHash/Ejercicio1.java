package TablaHash;

import java.util.Hashtable;

public class Ejercicio1 {
    public static void main(String[] args) {
        Hashtable<String, String> credenciales = new Hashtable<>();
        credenciales.put("admin", "12345");
        
        String user = "admin";
        if(credenciales.containsKey(user)){
            System.out.println("Pass: " + credenciales.get(user));
        }
    }
}
