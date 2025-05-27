<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Huerto o Corral</title>
    <style>
        body {
            background-color: #f0f5f9;
            font-family: Arial, sans-serif;
            text-align: center;
        }
        .form-container {
            margin: auto;
            margin-top: 50px;
            width: 400px;
            background-color: white;
            padding: 20px;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        input[type="text"] {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 8px;
            border: 1px solid #ccc;
        }
        button {
            padding: 10px 30px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
        }
    </style>
</head>
<body>
<h2>Registrar Huerto o Corral</h2>
<div class="form-container">
    <form action="RegistroServlet" method="post">
        <input type="hidden" name="accion" value="registrarHuertoCorral">
        Nombre: <br>
        <input type="text" name="nombre"><br>
        ID de Producción: <br>
        <input type="text" name="idProduccion"><br>
        <button type="submit">Registrar</button>
    </form>
    <br>
    <form action="RegistroServlet" method="get">
        <input type="hidden" name="accion" value="listarHuertos">
        <button type="submit">Listar Huertos</button>
    </form>
</div>
</body>
</html>