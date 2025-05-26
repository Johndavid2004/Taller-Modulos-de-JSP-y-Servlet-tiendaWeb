package controlador;

import dao.ProduccionDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Produccion;

import java.io.IOException;
import java.util.List;

@WebServlet("/ProduccionServlet")
public class ProduccionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo");

        // Validación simple
        if (tipo == null || tipo.trim().isEmpty()) {
            request.setAttribute("error", "El tipo de producción no puede estar vacío.");
        } else {
            Produccion produccion = new Produccion();
            produccion.setTipo(tipo);

            ProduccionDAO dao = new ProduccionDAO();
            dao.insertar(produccion);

            request.setAttribute("mensaje", "Producción registrada correctamente.");
        }

        // Siempre listar después de registrar o error
        ProduccionDAO dao = new ProduccionDAO();
        List<Produccion> lista = dao.listarProducciones();

        request.setAttribute("lista", lista);
        RequestDispatcher rd = request.getRequestDispatcher("jsp/produccion.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProduccionDAO dao = new ProduccionDAO();
        List<Produccion> lista = dao.listarProducciones();

        request.setAttribute("lista", lista);
        RequestDispatcher rd = request.getRequestDispatcher("jsp/produccion.jsp");
        rd.forward(request, response);
    }
}
