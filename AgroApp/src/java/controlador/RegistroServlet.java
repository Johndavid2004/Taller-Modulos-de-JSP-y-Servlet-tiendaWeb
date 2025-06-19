package controlador;

import Basedatos.ProduccionD;
import Basedatos.HuertoCorralD;
import Basedatos.EnfermedadD;
import Basedatos.HumedadD;
import modelo.Produccion;
import modelo.HuertoCorral;
import modelo.Enfermedad;
import modelo.Humedad;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            request.setAttribute("error", "No se recibió ninguna acción.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        switch (accion) {
            case "registrarProduccion":
                procesarRegistroProduccion(request, response);
                break;
            case "huertoCorral":
                procesarRegistroHuertoCorral(request, response);
                break;
            case "registrarEnfermedad":
                procesarRegistroEnfermedad(request, response);
                break;
            case "registrarHumedad":
                procesarRegistroHumedad(request, response);
                break;
            case "listarHuertos":
                mostrarHuertosRegistrados(request, response);
                break;
            default:
                request.setAttribute("error", "Acción no válida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void procesarRegistroProduccion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo");
        String cantidadStr = request.getParameter("cantidad");
        String unidad = request.getParameter("unidad");
        String fechaStr = request.getParameter("fecha");
        String idHuertoStr = request.getParameter("idHuertoCorral");

        // Validación básica
        if (tipo == null || cantidadStr == null || unidad == null || fechaStr == null || idHuertoStr == null ||
                tipo.trim().isEmpty() || cantidadStr.trim().isEmpty() || unidad.trim().isEmpty() ||
                fechaStr.trim().isEmpty() || idHuertoStr.trim().isEmpty()) {
            request.setAttribute("error", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }

        try {
            double cantidad = Double.parseDouble(cantidadStr);
            Date fecha = Date.valueOf(fechaStr);
            int idHuerto = Integer.parseInt(idHuertoStr);

            Produccion nuevaProduccion = new Produccion();
            nuevaProduccion.setTipo(tipo);
            nuevaProduccion.setCantidad(cantidad);
            nuevaProduccion.setUnidad(unidad);
            nuevaProduccion.setFecha(fecha);
            nuevaProduccion.setIdHuertoCorral(idHuerto);

            new ProduccionD().guardar(nuevaProduccion);

            List<Produccion> listaProduccion = new ProduccionD().consultarTodas();

            request.setAttribute("mensaje", "Producción registrada correctamente.");
            request.setAttribute("listaProduccion", listaProduccion);

            request.getRequestDispatcher("registro.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "Error al procesar los datos: " + e.getMessage());
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }

    private void procesarRegistroHuertoCorral(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String prodIdStr = request.getParameter("produccionId");

        if (nombre == null || nombre.trim().isEmpty() || prodIdStr == null || prodIdStr.trim().isEmpty()) {
            request.setAttribute("error", "Todos los campos son obligatorios");
            request.getRequestDispatcher("huertoCorral.jsp").forward(request, response);
            return;
        }

        try {
            int produccionId = Integer.parseInt(prodIdStr);

            HuertoCorral nuevoHuerto = new HuertoCorral();
            nuevoHuerto.setNombre(nombre);
            nuevoHuerto.setIdProduccion(produccionId);

            new HuertoCorralD().guardar(nuevoHuerto);

            List<Produccion> listaProduccion = new ProduccionD().consultarTodas();
            request.setAttribute("listaProduccion", listaProduccion);
            request.setAttribute("mensaje", "Huerto o Corral registrado correctamente");

            request.getRequestDispatcher("huertoCorral.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "ID de producción inválido");
            request.getRequestDispatcher("huertoCorral.jsp").forward(request, response);
        }
    }

    private void procesarRegistroEnfermedad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String huertoIdStr = request.getParameter("huertoId");

        if (nombre == null || descripcion == null || huertoIdStr == null
                || nombre.trim().isEmpty() || descripcion.trim().isEmpty() || huertoIdStr.trim().isEmpty()) {
            request.setAttribute("error", "Todos los campos son obligatorios");
            request.getRequestDispatcher("registrarEnfermedad.jsp").forward(request, response);
            return;
        }

        try {
            int huertoId = Integer.parseInt(huertoIdStr);

            Enfermedad enfermedad = new Enfermedad();
            enfermedad.setNombre(nombre);
            enfermedad.setDescripcion(descripcion);
            enfermedad.setHuertoId(huertoId);

            new EnfermedadD().guardar(enfermedad);

            request.setAttribute("mensaje", "Enfermedad registrada correctamente");
            request.getRequestDispatcher("registrarEnfermedad.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error al registrar enfermedad: " + e.getMessage());
            request.getRequestDispatcher("registrarEnfermedad.jsp").forward(request, response);
        }
    }

    private void procesarRegistroHumedad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nivelStr = request.getParameter("nivel");
        String fechaStr = request.getParameter("fecha");
        String huertoIdStr = request.getParameter("huertoId");

        if (nivelStr == null || fechaStr == null || huertoIdStr == null
                || nivelStr.trim().isEmpty() || fechaStr.trim().isEmpty() || huertoIdStr.trim().isEmpty()) {
            request.setAttribute("error", "Todos los campos son obligatorios");
            request.getRequestDispatcher("registrarHumedad.jsp").forward(request, response);
            return;
        }

        try {
            double nivel = Double.parseDouble(nivelStr);
            Date fecha = Date.valueOf(fechaStr);
            int huertoId = Integer.parseInt(huertoIdStr);

            Humedad humedad = new Humedad();
            humedad.setNivel(nivel);
            humedad.setFecha(fecha);
            humedad.setHuertoId(huertoId);

            new HumedadD().guardar(humedad);

            request.setAttribute("mensaje", "Registro de humedad exitoso");
            request.getRequestDispatcher("registrarHumedad.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error al registrar humedad: " + e.getMessage());
            request.getRequestDispatcher("registrarHumedad.jsp").forward(request, response);
        }
    }

    private void mostrarHuertosRegistrados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<HuertoCorral> huertos = new HuertoCorralD().consultarTodos();
        request.setAttribute("listaHuertos", huertos);
        request.getRequestDispatcher("listarHuertos.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Controlador central para operaciones de producción agrícola";
    }
}
