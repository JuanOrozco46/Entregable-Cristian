package modelo.dto;

//sirve exclusivamente para mover datos entre capas
public class PersonaDTO {
    private String nombre;
    private int edad;
    private double peso;
    private double estatura;

    public PersonaDTO() {}

    // Metodos getter y setter para acceder de forma controlada a las variables privadas
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    public double getEstatura() { return estatura; }
    public void setEstatura(double estatura) { this.estatura = estatura; }
}
