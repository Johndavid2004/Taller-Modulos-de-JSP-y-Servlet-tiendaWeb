package Basedatos;

import modelo.Conexion;
import modelo.Enfermedad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnfermedadD {

    public void insertar(Enfermedad e) {
        String sql = "INSERT INTO enfermedad (nombre, descripcion, huerto_id) VALUES (?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getDescripcion());
            ps.setInt(3, e.getHuertoId());
            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Enfermedad> listar() {
        List<Enfermedad> lista = new ArrayList<>();
        String sql = "SELECT * FROM enfermedad";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Enfermedad e = new Enfermedad();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setHuertoId(rs.getInt("huerto_id"));
                lista.add(e);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }
}
