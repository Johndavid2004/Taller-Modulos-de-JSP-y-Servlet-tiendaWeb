package modelo;

public class HuertoCorral {
    private int id;
    private String nombre;
    private int idProduccion;

    public HuertoCorral() {}

    public HuertoCorral(int id, String nombre, int produccionId) {
        this.id = id;
        this.nombre = nombre;
        this.idProduccion = produccionId;
    }

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

    public int getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(int idProduccion) {
        this.idProduccion = idProduccion;
    }
 
}
