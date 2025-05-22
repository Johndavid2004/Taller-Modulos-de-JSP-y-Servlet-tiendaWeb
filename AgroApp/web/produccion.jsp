<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="modelo.Produccion" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Registro de Producción Agrícola</title>
</head>
<body>
    <h2>Registrar Tipo de Producción</h2>
    <form action="../ProduccionServlet" method="post">
        <label>Tipo de Producción:</label>
        <input type="text" name="tipo" required />
        <input type="submit" value="Registrar" />
    </form>

    <h3>Tipos registrados:</h3>
    <ul>
        <%
            List<Produccion> lista = (List<Produccion>) request.getAttribute("lista");
            if (lista != null) {
                for (Produccion p : lista) {
        %>
            <li><%= p.getId() %> - <%= p.getTipo() %></li>
        <%
                }
            }
        %>
    </ul>
</body>
</html>
