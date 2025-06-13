<%@ page import="Basedatos.HuertoCorralD, modelo.HuertoCorral" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Enfermedad</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f6fa;
            padding: 20px;
        }

        .form-container {
            background-color: #fff;
            border-radius: 12px;
            max-width: 400px;
            margin: auto;
            padding: 25px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            color: #236c84;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 12px;
            color: #333;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 8px;
            margin-top: 6px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }

        input[type="submit"] {
            margin-top: 20px;
            width: 100%;
            background-color: #236c84;
            color: #fff;
            border: none;
            padding: 10px;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #184d5f;
        }

        .volver {
            text-align: center;
            margin-top: 15px;
        }

        .volver a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #ccc;
            color: #000;
            border-radius: 6px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .volver a:hover {
            background-color: #999;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Registrar Enfermedad</h2>
        <form action="RegistroServlet" method="post">
            <label>Nombre de la Enfermedad:</label>
            <input type="text" name="nombre" required>

            <label>Descripción:</label>
            <input type="text" name="descripcion" required>

            <label>Huerto/Corral:</label>
            <select name="huertoId">
                <%
                    Basedatos.HuertoCorralD dao = new Basedatos.HuertoCorralD();
                    for (HuertoCorral h : dao.listar()) {
                %>
                    <option value="<%= h.getId() %>"><%= h.getNombre() %></option>
                <%
                    }
                %>
            </select>

            <input type="hidden" name="action" value="registrarEnfermedad">
            <input type="submit" value="Registrar">
        </form>
    </div>

    <div class="volver">
        <a href="index.jsp">Volver al Menú Principal</a>
    </div>
</body>
</html>
