<?php
include 'conexion.php';

//$usu_usuario="12002";
//$usu_password="gabda02";

$result=$conexion->query("SELECT * FROM pedido");
$numFilas= $result->num_rows;
$array=array();
for($x=0;$x<$numFilas;$x++){
	$array[] = $result->fetch_object();
}
echo json_encode($array);

$result->close();
$conexion->close();
?>