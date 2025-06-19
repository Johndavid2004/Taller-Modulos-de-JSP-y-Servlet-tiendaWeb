package controlador;

import Basedatos.ProduccionD;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("tipo");

        if (tipo == null || tipo.trim().isEmpty()) {
            request.setAttribute("error", "El tipo de producción no puede estar vacío.");
            RequestDispatcher rd = request.getRequestDispatcher("jsp/produccion.jsp");
            rd.forward(request, response);
            return;
        }

        Produccion nuevaProduccion = new Produccion();
        nuevaProduccion.setTipo(tipo);

        ProduccionD manejadorProduccion = new ProduccionD();
        manejadorProduccion.insertar(nuevaProduccion);

        response.sendRedirect("jsp/produccion.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProduccionD manejadorProduccion = new ProduccionD();
        List<Produccion> lista = manejadorProduccion.listarProducciones();

        request.setAttribute("lista", lista);
        RequestDispatcher rd = request.getRequestDispatcher("jsp/produccion.jsp");
        rd.forward(request, response);
    }
}
