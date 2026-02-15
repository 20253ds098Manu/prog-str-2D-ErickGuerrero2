public class Persona {

    private int id;
    private String nombre;
    private double promedio; // Nuevo requerimiento
    private boolean activa;

    public Persona() {}

    public Persona(int id, String nombre, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.promedio = promedio;
        this.activa = true; //
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) { this.promedio = promedio; }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Promedio: " + promedio + " | Activa: " + activa;
    }
}