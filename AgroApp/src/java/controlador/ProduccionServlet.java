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

        Produccion produccion = new Produccion();
        produccion.setTipo(tipo);

        ProduccionDAO dao = new ProduccionDAO();
        dao.insertar(produccion);

        response.sendRedirect("jsp/produccion.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProduccionDAO dao = new ProduccionDAO();
        List<Produccion> lista = dao.listar();

        request.setAttribute("lista", lista);
        RequestDispatcher rd = request.getRequestDispatcher("jsp/produccion.jsp");
        rd.forward(request, response);
    }
}
