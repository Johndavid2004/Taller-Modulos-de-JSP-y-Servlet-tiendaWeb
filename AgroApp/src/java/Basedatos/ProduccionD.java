package Basedatos;

import modelo.Conexion;
import modelo.Produccion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduccionD {

    // Método para insertar un nuevo registro en la tabla produccion
    public void insertar(Produccion p) {
        String sql = "INSERT INTO produccion (tipo) VALUES (?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getTipo());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Método renombrado para que sea coherente con RegistroServlet
    public List<Produccion> listarProducciones() {
        List<Produccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM produccion";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Produccion p = new Produccion();
                p.setId(rs.getInt("id"));
                p.setTipo(rs.getString("tipo"));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
