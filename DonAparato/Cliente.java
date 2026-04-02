// Clase que representa al cliente de la tienda
// Aplica programación orientada a objetos (POO)
public class Cliente {

    // Atributos (datos del cliente)
    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;
    private String tipo; // Puede ser "A", "B", "C" o vacío (sin tipo)

    // Constructor: inicializa el cliente con sus datos
    public Cliente(String nombre, String apellido, int edad, String telefono, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    // Método que calcula el porcentaje de descuento según el tipo
    public double getPorcentajeDescuento() {
        if (tipo.equalsIgnoreCase("A")) {
            return 0.40; // 40% de descuento
        } else if (tipo.equalsIgnoreCase("B")) {
            return 0.20; // 20% de descuento
        } else if (tipo.equalsIgnoreCase("C")) {
            return 0.10; // 10% de descuento
        } else {
            return 0.0; // Sin descuento si no tiene tipo asignado
        }
    }

    // Método que devuelve el nombre completo del cliente
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    // Métodos GET para acceder a los atributos desde otras clases
    public String getNombre()    { return nombre; }
    public String getApellido()  { return apellido; }
    public int getEdad()         { return edad; }
    public String getTelefono()  { return telefono; }
    public String getTipo()      { return tipo.isEmpty() ? "Sin tipo" : tipo.toUpperCase(); }
}
