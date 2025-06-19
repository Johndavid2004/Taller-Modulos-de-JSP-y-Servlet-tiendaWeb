package Basedatos;

import modelo.Conexion;
import modelo.Humedad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase que gestiona el registro de niveles de humedad en la base de datos.
 * Forma parte del módulo agrícola para monitoreo ambiental.
 */
public class HumedadD {

    /**
     * Guarda un nuevo registro de humedad asociado a un huerto o corral.
     *
     * @param h Objeto Humedad con los datos a almacenar.
     */
    public void registrarNivelHumedad(Humedad h) {
        if (h == null || h.getNivel() < 0 || h.getHuertoId() <= 0) {
            System.out.println("⚠️ Datos de humedad no válidos. Registro cancelado.");
            return;
        }

        String sql = "INSERT INTO humedad (nivel, fecha, huerto_id) VALUES (?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, h.getNivel());
            ps.setDate(2, h.getFecha());
            ps.setInt(3, h.getHuertoId());

            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                System.out.println("✅ Registro de humedad exitoso.");
            } else {
                System.out.println("⚠️ No se insertaron datos en la tabla humedad.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al registrar humedad: " + e.getMessage());
        }
    }

    public void guardar(Humedad humedad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
