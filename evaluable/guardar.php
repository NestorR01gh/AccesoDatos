<?php
if (isset($_POST["titol"])) {
    $id = $_POST["id"];
    $titol = $_POST["titol"];
    $any = $_POST["any"];
    $estrena = $_POST["estrena"];
    $genere = $_POST["genere"];
    $argument = $_POST["argument"];
    $servidor = "localhost";
    $usuario = "root";
    $password = "";
    $dbname = "pelis";
    $conexion = mysqli_connect($servidor, $usuario, $password, $dbname);
    if (!$conexion) {
        echo "Error en la conexion a MySQL: " . mysqli_connect_error();
        exit();
    }
    $sql = "INSERT INTO pelis VALUES (NULL, '" . $id . "','" . $titol . "'," . $any . ",'" . $estrena . "','" . $genere . "','" . $argument . "')";
    if (mysqli_query($conexion, $sql)) {
        echo "Registro insertado correctamente.";
    } else {
        echo "Error: " . $sql . "<br>" . mysqli_error($conexion);
    }
}
