package modelo;

public class Produccion {
    private int id;
    private String tipo;

    // Constructor vacío
    public Produccion() {
    }

    // Constructor con parámetros
    public Produccion(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
