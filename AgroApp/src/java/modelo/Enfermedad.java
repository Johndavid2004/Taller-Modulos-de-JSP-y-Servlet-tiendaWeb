package modelo;

public class Enfermedad {
    private int id;
    private String nombre;
    private String descripcion;
    private int huertoId;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHuertoId() {
        return huertoId;
    }

    public void setHuertoId(int huertoId) {
        this.huertoId = huertoId;
    }
}
