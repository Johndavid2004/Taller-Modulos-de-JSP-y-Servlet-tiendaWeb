package controlador;

import Basedatos.ProduccionD;
import Basedatos.HuertoCorralD;
import modelo.Produccion;
import modelo.HuertoCorral;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("registrarProduccion".equals(action)) {
            registrarProduccion(request, response);
        } else if ("huertoCorral".equals(action)) {
            registrarHuertoCorral(request, response);
        } else if ("listarHuertos".equals(action)) {
            listarHuertos(request, response);
        } else {
            request.setAttribute("error", "Acción no válida");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void registrarProduccion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo");

        if (tipo == null || tipo.trim().isEmpty()) {
            request.setAttribute("error", "El tipo de producción no puede estar vacío.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }

        Produccion p = new Produccion();
        p.setTipo(tipo);

        ProduccionD dao = new ProduccionD();
        dao.insertar(p);

        List<Produccion> listaProduccion = dao.listarProducciones();

        request.setAttribute("mensaje", "Producción registrada correctamente.");
        request.setAttribute("listaProduccion", listaProduccion);

        request.getRequestDispatcher("HuertoCorral.jsp").forward(request, response);
    }

    private void registrarHuertoCorral(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String prodIdStr = request.getParameter("produccionId");

        if (nombre == null || nombre.trim().isEmpty() || prodIdStr == null || prodIdStr.trim().isEmpty()) {
            request.setAttribute("error", "Todos los campos son obligatorios");
            request.getRequestDispatcher("HuertoCorral.jsp").forward(request, response);
            return;
        }

        int produccionId;
        try {
            produccionId = Integer.parseInt(prodIdStr);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "ID de producción inválido");
            request.getRequestDispatcher("HuertoCorral.jsp").forward(request, response);
            return;
        }

        HuertoCorral h = new HuertoCorral();
        h.setNombre(nombre);
        h.setIdProduccion(produccionId);

        HuertoCorralD dao = new HuertoCorralD();
        dao.insertar(h);

        request.setAttribute("mensaje", "Huerto o Corral registrado correctamente");

        ProduccionD produccionDAO = new ProduccionD();
        List<Produccion> listaProduccion = produccionDAO.listarProducciones();
        request.setAttribute("listaProduccion", listaProduccion);

        request.getRequestDispatcher("HuertoCorral.jsp").forward(request, response);
    }

    private void listarHuertos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HuertoCorralD dao = new HuertoCorralD();
        List<HuertoCorral> lista = dao.obtenerHuertosCorrales();

        request.setAttribute("listaHuertos", lista);
        request.getRequestDispatcher("listarHuertos.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet de Registro para Huerto/Corral";
    }
}
