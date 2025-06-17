package Basedatos;

import modelo.Conexion;
import modelo.HuertoCorral;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de gestionar las operaciones relacionadas con Huertos y Corrales en la base de datos.
 */
public class HuertoCorralD {

    /**
     * Registra un nuevo huerto o corral en la base de datos.
     *
     * @param huerto Objeto que contiene los datos a insertar.
     */
    public void guardar(HuertoCorral huerto) {
        String sql = "INSERT INTO huerto (nombre, produccion_id) VALUES (?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, huerto.getNombre());
            ps.setInt(2, huerto.getIdProduccion());

            int filasInsertadas = ps.executeUpdate();
            if (filasInsertadas == 0) {
                System.out.println("⚠️ No se insertó ningún registro.");
            }

        } catch (Exception e) {
            System.err.println("❌ Error al guardar huerto/corral: " + e.getMessage());
        }
    }

    /**
     * Devuelve una lista con todos los huertos o corrales registrados.
     *
     * @return Lista de objetos HuertoCorral.
     */
    public List<HuertoCorral> consultarTodos() {
        List<HuertoCorral> huertos = new ArrayList<>();
        String sql = "SELECT * FROM huerto";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                HuertoCorral item = new HuertoCorral();
                item.setId(rs.getInt("id"));
                item.setNombre(rs.getString("nombre"));
                item.setIdProduccion(rs.getInt("produccion_id"));
                huertos.add(item);
            }

        } catch (Exception e) {
            System.err.println("❌ Error al consultar huertos/corrales: " + e.getMessage());
        }

        return huertos;
    }

    /**
     * Método adicional para mantener compatibilidad con código existente.
     */
    public List<HuertoCorral> obtenerHuertosCorrales() {
        return consultarTodos();
    }
}
