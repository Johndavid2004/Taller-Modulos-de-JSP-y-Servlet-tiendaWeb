<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Huerto o Corral</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f5f9;
            padding: 40px;
            text-align: center;
        }
        
        h2 {
            
            color: #2a7d8c;
        }
        a {
            display: block;
            margin: 15px auto;
            padding: 12px 25px;
            background-color: #2a7d8c;
            color: white;
            text-decoration: none;
            width: 250px;
            border-radius: 6px;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #1c5a65;
        }
        
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            width: 400px;
            margin: auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        input, select {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            background-color: #27ae60;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #219150;
        }
    </style>
</head>
<body>
<h2>Registrar Huerto o Corral</h2>

<form action="listarHuertos" method="post">
    <input type="hidden" name="action" value="registrarHuertoCorral" />

    <label for="nombre">Nombre:</label>
    <input type="text" name="nombre" required><br><br>

    <label for="produccionId">ID de Producción:</label>
    <input type="number" name="produccionId" required><br><br>

    <button type="submit" onclick="location.href='listarHuertos.jsp" >Registrar</button>
</form>

<%-- Mensajes opcionales --%>
<% if (request.getAttribute("mensaje") != null) { %>
    <p style="color: green;"><%= request.getAttribute("mensaje") %></p>
<% } %>
<% if (request.getAttribute("error") != null) { %>
    <p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>

</body>
</html>
