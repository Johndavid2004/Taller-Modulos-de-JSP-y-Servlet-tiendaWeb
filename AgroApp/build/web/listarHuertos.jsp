<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.HuertoCorral" %>
<%@ page import="Basedatos.HuertoCorralD" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Huertos y Corrales</title>
    <style>
        body {
            background-color: #f0f5f9;
            font-family: Arial, sans-serif;
            text-align: center;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
            margin-top: 40px;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ccc;
        }
        th {
            background-color: #2a7d8f;
            color: white;
        }
        .back-button {
            margin-top: 20px;
            padding: 10px 25px;
            background-color: #2a7d8f;
            color: white;
            border: none;
            border-radius: 6px;
            text-decoration: none;
        }
    </style>
</head>
<body>
<h2>Listado de Huertos y Corrales</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>ID Producción</th>
    </tr>
    <%
        HuertoCorralD dao = new HuertoCorralD();
        List<HuertoCorral> lista = dao.listar(); // Asegúrate que listar() exista
        if (lista != null && !lista.isEmpty()) {
            for (HuertoCorral h : lista) {
    %>
    <tr>
        <td><%= h.getId() %></td>
        <td><%= h.getNombre() %></td>
        <td><%= h.getIdProduccion() %></td>
    </tr>
    <% 
            }
        } else {
    %>
    <tr>
        <td colspan="3">No hay registros</td>
    </tr>
    <% } %>
</table>
<br>
<a class="back-button" href="huertoCorral.jsp">Volver al Registro</a>
</body>
</html>