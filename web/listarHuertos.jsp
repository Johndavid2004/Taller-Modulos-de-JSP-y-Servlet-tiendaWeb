<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.HuertoCorral" %>

<%
    List<HuertoCorral> listaHuertos = (List<HuertoCorral>) request.getAttribute("listaHuertos");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Listado de Huertos y Corrales</title>
</head>
<body>
    <h2>Listado de Huertos y Corrales</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>ID Producción</th>
        </tr>
        <%
            if (listaHuertos != null) {
                for (HuertoCorral h : listaHuertos) {
        %>
        <tr>
            <td><%= h.getId() %></td>
            <td><%= h.getNombre() %></td>
            <td><%= h.getProduccionId() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="3">No hay registros</td></tr>
        <%
            }
        %>
    </table>
</body>
</html>
