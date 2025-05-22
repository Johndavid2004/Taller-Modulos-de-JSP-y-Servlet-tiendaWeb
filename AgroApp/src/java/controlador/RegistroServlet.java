package controlador;

import dao.ProduccionDAO;
import dao.HuertoCorralDAO;
import modelo.Produccion;
import modelo.HuertoCorral;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");

        if ("registrarProduccion".equals(action)) {
            registrarProduccion(request, response);
        } else if ("registrarHuertoCorral".equals(action)) {
            registrarHuertoCorral(request, response);
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

        ProduccionDAO dao = new ProduccionDAO();
        dao.insertar(p);

        request.setAttribute("mensaje", "Producción registrada correctamente.");
        request.getRequestDispatcher("registro.jsp").forward(request, response);
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
        h.setProduccionId(produccionId);

        HuertoCorralDAO dao = new HuertoCorralDAO();
        dao.insertar(h);

        request.setAttribute("mensaje", "Huerto o Corral registrado correctamente");
        request.getRequestDispatcher("HuertoCorral.jsp").forward(request, response);
    }
}
