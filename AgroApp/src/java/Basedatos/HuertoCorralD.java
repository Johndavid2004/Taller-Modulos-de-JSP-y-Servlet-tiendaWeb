package Basedatos;

import modelo.Conexion;
import modelo.HuertoCorral;
import java.sql.*;
import java.util.*;

public class HuertoCorralD {

    public void insertar(HuertoCorral h) {
        String sql = "INSERT INTO huerto (nombre, produccion_id) VALUES (?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, h.getNombre());
            ps.setInt(2, h.getIdProduccion());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<HuertoCorral> listar() {
        List<HuertoCorral> lista = new ArrayList<>();
        String sql = "SELECT * FROM huerto";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                HuertoCorral h = new HuertoCorral();
                h.setId(rs.getInt("id"));
                h.setNombre(rs.getString("nombre"));
                h.setIdProduccion(rs.getInt("produccion_id"));
                lista.add(h);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // ✅ Nuevo método requerido
    public List<HuertoCorral> obtenerHuertosCorrales() {
        return listar(); // simplemente llama al método existente
    }
}
