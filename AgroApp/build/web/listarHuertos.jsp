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
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f5f9;
            padding: 40px;
            text-align: center;
        }

        h2 {
            color: #2a7d8c;
            margin-bottom: 30px;
        }

        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px 20px;
            border: 1px solid #ccc;
            text-align: center;
        }

        th {
            background-color: #2a7d8c;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #d3eef3;
        }

        .volver {
            display: inline-block;
            margin-top: 30px;
            padding: 12px 25px;
            background-color: #2a7d8c;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            transition: background-color 0.3s ease;
        }

        .volver:hover {
            background-color: #1c5a65;
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
            if (listaHuertos != null && !listaHuertos.isEmpty()) {
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
        <tr>
            <td colspan="3">No hay registros</td>
        </tr>
        <%
            }
        %>
    </table>

    <a href="registro.jsp" class="volver">Volver al Registro</a>
</body>
</html>
