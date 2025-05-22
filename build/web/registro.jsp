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
            color: #2c3e50;
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
        input[type="submit"] {
            background-color: #27ae60;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #219150;
        }
    </style>
</head>
<body>
    <h2>Registrar Nueva Producción</h2>
    <form action="RegistrarProduccion" method="post">
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

        <input type="submit" value="Registrar Producción">
    </form>
</body>
</html>
