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

        .sin-registros {
            font-style: italic;
            color: #555;
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
        HuertoCorralD gestorHuertoCorral = new HuertoCorralD();
        List<HuertoCorral> huertosRegistrados = gestorHuertoCorral.consultarTodos();

        if (huertosRegistrados != null && !huertosRegistrados.isEmpty()) {
            for (HuertoCorral registro : huertosRegistrados) {
    %>
    <tr>
        <td><%= registro.getId() %></td>
        <td><%= registro.getNombre() %></td>
        <td><%= registro.getIdProduccion() %></td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="3" class="sin-registros">No hay registros disponibles.</td>
    </tr>
    <% } %>
</table>

<br>
<a class="back-button" href="huertoCorral.jsp">Volver al Registro</a>

</body>
</html>
