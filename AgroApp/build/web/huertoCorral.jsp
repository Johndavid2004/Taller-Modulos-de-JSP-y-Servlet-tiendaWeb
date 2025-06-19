<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.HuertoCorral" %>
<%@ page import="modelo.Produccion" %>
<%@ page import="Basedatos.HuertoCorralD" %>
<%@ page import="Basedatos.ProduccionD" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro de Huerto o Corral</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e8f0f7;
            padding: 20px;
        }

        .form-box {
            max-width: 500px;
            background-color: #fff;
            padding: 25px;
            border-radius: 10px;
            margin: auto;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            color: #1d4e6e;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            border-radius: 6px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            margin-top: 20px;
            background-color: #1d4e6e;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 6px;
            width: 100%;
            cursor: pointer;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #13394e;
        }

        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
        }

        .back-link a {
            background-color: #ccc;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 6px;
            color: black;
            font-weight: bold;
        }

        .mensaje {
            text-align: center;
            color: green;
            margin-top: 15px;
        }

        .error {
            text-align: center;
            color: red;
            margin-top: 15px;
        }
    </style>
</head>
<body>

<div class="form-box">
    <h2>Registrar Huerto o Corral</h2>

    <% 
        String mensaje = (String) request.getAttribute("mensaje");
        String error = (String) request.getAttribute("error");
        if (mensaje != null) { 
    %>
        <p class="mensaje"><%= mensaje %></p>
    <% } else if (error != null) { %>
        <p class="error"><%= error %></p>
    <% } %>

    <form action="RegistroServlet" method="post">
        <label>Nombre del Huerto o Corral:</label>
        <input type="text" name="nombre" required>

        <label>Tipo de Producción:</label>
        <select name="produccionId" required>
            <%
                List<Produccion> listaProduccion = (List<Produccion>) request.getAttribute("listaProduccion");
                if (listaProduccion != null) {
                    for (Produccion item : listaProduccion) {
            %>
                        <option value="<%= item.getId() %>"><%= item.getTipo() %></option>
            <%
                    }
                } else {
            %>
                <option disabled>No hay tipos de producción registrados</option>
            <%
                }
            %>
        </select>

        <input type="hidden" name="action" value="huertoCorral">
        <input type="submit" value="Registrar">
    </form>

    <div class="back-link">
        <a href="index.jsp">Volver al Menú Principal</a>
    </div>
</div>

</body>
</html>
