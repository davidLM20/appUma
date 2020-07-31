<?php
include 'conexion.php';
$usu_usuario=$_POST['cedula'];
$usu_password=$_POST['codigo'];

//$usu_usuario="12002";
//$usu_password="gabda02";

$sentencia=$conexion->prepare("SELECT * FROM mesero WHERE cedula=? AND codigo=?");
$sentencia->bind_param('ss',$usu_usuario,$usu_password);
$sentencia->execute();

$resultado = $sentencia->get_result();
if ($fila = $resultado->fetch_assoc()) {
         echo json_encode($fila,JSON_UNESCAPED_UNICODE);     
}
$sentencia->close();
$conexion->close();
?>