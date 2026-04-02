// Clase que representa el producto que compra el cliente
// Aplica programación orientada a objetos (POO)
public class Producto {

    // Atributos del producto
    private String nombre;
    private double valorUnitario; // Precio por unidad
    private int cantidad;         // Cuántos se van a comprar

    // Constructor: inicializa el producto con sus datos
    public Producto(String nombre, double valorUnitario, int cantidad) {
        this.nombre = nombre;
        this.valorUnitario = valorUnitario;
        this.cantidad = cantidad;
    }

    // Calcula el total bruto sin descuento (precio * cantidad)
    public double getTotalBruto() {
        return valorUnitario * cantidad;
    }

    // Métodos GET para acceder a los datos desde otras clases
    public String getNombre()         { return nombre; }
    public double getValorUnitario()  { return valorUnitario; }
    public int getCantidad()          { return cantidad; }
}
