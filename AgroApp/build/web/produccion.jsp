<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="modelo.Produccion" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro de Producción Agrícola</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #f0f4f8, #d9e2ec);
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 60px auto;
            background-color: white;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
        }

        h2, h3 {
            color: #2f4858;
            text-align: center;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
            margin-top: 20px;
        }

        label {
            font-weight: bold;
            color: #334e68;
        }

        input[type="text"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: #2b6cb0;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #2c5282;
        }

        ul {
            list-style: none;
            padding: 0;
            margin-top: 20px;
        }

        li {
            background-color: #edf2f7;
            padding: 10px;
            margin-bottom: 8px;
            border-radius: 8px;
            transition: transform 0.2s ease;
        }

        li:hover {
            transform: scale(1.02);
            background-color: #e2e8f0;
        }

        @media (max-width: 600px) {
            .container {
                margin: 30px 15px;
                padding: 20px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
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
                } else {
            %>
                <li>No hay registros disponibles.</li>
            <%
                }
            %>
        </ul>
    </div>
</body>
</html>
