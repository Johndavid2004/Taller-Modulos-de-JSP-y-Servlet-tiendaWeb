package modelo;

import java.sql.Date;

public class Humedad {
    private int id;
    private double nivel;
    private Date fecha;
    private int huertoId;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNivel() {
        return nivel;
    }

    public void setNivel(double nivel) {
        this.nivel = nivel;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHuertoId() {
        return huertoId;
    }

    public void setHuertoId(int huertoId) {
        this.huertoId = huertoId;
    }
}
