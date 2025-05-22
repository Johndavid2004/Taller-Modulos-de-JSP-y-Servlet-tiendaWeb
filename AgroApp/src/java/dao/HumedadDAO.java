package dao;

import modelo.Conexion;
import modelo.Humedad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HumedadDAO {

    public void insertar(Humedad h) {
        String sql = "INSERT INTO humedad (nivel, fecha, huerto_id) VALUES (?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, h.getNivel());
            ps.setDate(2, h.getFecha());
            ps.setInt(3, h.getHuertoId());
            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Humedad> listar() {
        List<Humedad> lista = new ArrayList<>();
        String sql = "SELECT * FROM humedad";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Humedad h = new Humedad();
                h.setId(rs.getInt("id"));
                h.setNivel(rs.getDouble("nivel"));
                h.setFecha(rs.getDate("fecha"));
                h.setHuertoId(rs.getInt("huerto_id"));
                lista.add(h);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }
}
