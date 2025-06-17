package Basedatos;

import modelo.Conexion;
import modelo.Produccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduccionD {

    // Guarda un nuevo registro de tipo de producción en la base de datos
    public boolean guardarProduccion(Produccion produccion) {
        String consulta = "INSERT INTO produccion (tipo) VALUES (?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, produccion.getTipo());
            int resultado = ps.executeUpdate();

            return resultado > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al guardar la producción: " + e.getMessage());
            return false;
        }
    }

    // Devuelve todos los tipos de producción registrados en la base de datos
    public List<Produccion> obtenerTodasLasProducciones() {
        List<Produccion> lista = new ArrayList<>();
        String consulta = "SELECT * FROM produccion";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(consulta);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Produccion prod = new Produccion();
                prod.setId(rs.getInt("id"));
                prod.setTipo(rs.getString("tipo"));
                lista.add(prod);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar producciones: " + e.getMessage());
        }

        return lista;
    }

    // Busca una producción específica por ID
    public Produccion buscarPorId(int id) {
        String consulta = "SELECT * FROM produccion WHERE id = ?";
        Produccion prod = null;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                prod = new Produccion();
                prod.setId(rs.getInt("id"));
                prod.setTipo(rs.getString("tipo"));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al buscar producción por ID: " + e.getMessage());
        }

        return prod;
    }
}
