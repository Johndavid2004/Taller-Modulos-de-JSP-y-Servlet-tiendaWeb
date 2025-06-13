<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Enfermedad" %>
<%@ page import="Basedatos.EnfermedadD" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Enfermedades</title>
    <style>
        body {
            background-color: #f0f5f9;
            font-family: Arial, sans-serif;
            text-align: center;
        }
        table {
            width: 90%;
            margin: auto;
            border-collapse: collapse;
            margin-top: 40px;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ccc;
        }
        th {
            background-color: #236c84;
            color: white;
        }
        .back-button {
            margin-top: 20px;
            padding: 10px 25px;
            background-color: #236c84;
            color: white;
            border: none;
            border-radius: 6px;
            text-decoration: none;
        }
    </style>
</head>
<body>
<h2>Listado de Enfermedades</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Descripción</th>
        <th>Huerto/Corral</th>
    </tr>
    <%
        EnfermedadD dao = new EnfermedadD();
        List<Enfermedad> lista = dao.listarConNombreHuerto();
        if (lista != null && !lista.isEmpty()) {
            for (Enfermedad e : lista) {
    %>
    <tr>
        <td><%= e.getId() %></td>
        <td><%= e.getNombre() %></td>
        <td><%= e.getDescripcion() %></td>
        <td><%= e.getHuertoNombre() %></td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="4">No hay enfermedades registradas</td>
    </tr>
    <% } %>
</table>
<br>
<a class="back-button" href="index.jsp">Volver al Menú</a>
</body>
</html>
