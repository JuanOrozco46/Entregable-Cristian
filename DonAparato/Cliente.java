// Clase que representa al cliente de la tienda
public class Cliente {

    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;
    private String tipo; // "A", "B", "C" o vacío

    public Cliente(String nombre, String apellido, int edad, String telefono, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    // Retorna el porcentaje de descuento según el tipo de cliente
    public double getPorcentajeDescuento() {
        if (tipo.equalsIgnoreCase("A")) return 0.40;
        if (tipo.equalsIgnoreCase("B")) return 0.20;
        if (tipo.equalsIgnoreCase("C")) return 0.10;
        return 0.0; // Sin descuento si no tiene tipo
    }

    public String getNombreCompleto() { return nombre + " " + apellido; }
    public String getNombre()    { return nombre; }
    public String getApellido()  { return apellido; }
    public int    getEdad()      { return edad; }
    public String getTelefono()  { return telefono; }
    public String getTipo()      { return tipo.isEmpty() ? "Sin tipo" : tipo.toUpperCase(); }
}
