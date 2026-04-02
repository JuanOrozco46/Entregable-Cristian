// Clase que representa el producto que compra el cliente
public class Producto {

    private String nombre;
    private double valorUnitario;
    private int cantidad;

    public Producto(String nombre, double valorUnitario, int cantidad) {
        this.nombre = nombre;
        this.valorUnitario = valorUnitario;
        this.cantidad = cantidad;
    }

    // Total sin descuento: precio × cantidad
    public double getTotalBruto() { return valorUnitario * cantidad; }

    public String getNombre()        { return nombre; }
    public double getValorUnitario() { return valorUnitario; }
    public int    getCantidad()      { return cantidad; }
}
