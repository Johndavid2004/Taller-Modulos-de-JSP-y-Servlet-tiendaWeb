<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Huerto o Corral</title>
</head>
<body>
<h2>Registrar Huerto o Corral</h2>

<form action="RegistroServlet" method="post">
    <input type="hidden" name="action" value="registrarHuertoCorral" />

    <label for="nombre">Nombre:</label>
    <input type="text" name="nombre" required><br><br>

    <label for="produccionId">ID de Producción:</label>
    <input type="number" name="produccionId" required><br><br>

    <button type="submit">Registrar</button>
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
