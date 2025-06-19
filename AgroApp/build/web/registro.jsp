<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Producción</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f3f5;
            padding: 20px;
        }
        h2 {
            text-align: center;
            color: #2c3e50;
        }
        form {
            background-color: #fff;
            padding: 25px;
            border-radius: 10px;
            max-width: 450px;
            margin: auto;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-top: 12px;
            font-weight: bold;
            color: #34495e;
        }
        input[type="text"],
        input[type="number"],
        input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }
        input[type="submit"] {
            margin-top: 20px;
            width: 100%;
            background-color: #27ae60;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #219150;
        }
        .volver {
            text-align: center;
            margin-top: 20px;
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
    <h2>Registrar Nueva Producción</h2>
    <form action="RegistroServlet" method="post">
        <label for="tipo">Tipo de Producción:</label>
        <input type="text" id="tipo" name="tipo" required>

        <label for="cantidad">Cantidad:</label>
        <input type="number" id="cantidad" name="cantidad" step="0.01" required>

        <label for="unidad">Unidad de Medida:</label>
        <input type="text" id="unidad" name="unidad" required>

        <label for="fecha">Fecha:</label>
        <input type="date" id="fecha" name="fecha" required>

        <label for="idHuertoCorral">ID del Huerto o Corral:</label>
        <input type="number" id="idHuertoCorral" name="idHuertoCorral" required>

        <input type="hidden" name="action" value="registrarProduccion">

        <input type="submit" value="Registrar Producción">
    </form>

    <div class="volver">
        <a href="index.jsp">Volver al Menú Principal</a>
    </div>
</body>
</html>
