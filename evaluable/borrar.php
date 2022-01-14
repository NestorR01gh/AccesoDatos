<?php
if (isset($_POST["id"])) {
    $id =  $_POST["id"];
    $servidor = "localhost";
    $usuario = "root";
    $password = "";
    $dbname = "pelis";
    $conexion = mysqli_connect($servidor, $usuario, $password, $dbname);
    if (!$conexion) {
        echo "Error en la conexion a MySQL: " . mysqli_connect_error();
        exit();
    }
    $sql = "DELETE FROM pelis WHERE imdbId = '" . $id . "'";
    if (mysqli_query($conexion, $sql)) {
        echo "Registro borrado correctamente.";
    } else {
        echo "Error: " . $sql . "<br>" . mysqli_error($conexion);
    }
}
