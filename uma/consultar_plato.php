<?php
include 'conexion.php';
$idPlato=$_POST['idPlato'];

//$idPlato=17;
//$usu_password="gabda02";

$sentencia=$conexion->prepare("SELECT * FROM plato WHERE idPlato=?");
$sentencia->bind_param('s',$idPlato);
$sentencia->execute();

$resultado = $sentencia->get_result();
if ($fila = $resultado->fetch_assoc()) {
         echo json_encode($fila,JSON_UNESCAPED_UNICODE);     
}
$sentencia->close();
$conexion->close();
?>