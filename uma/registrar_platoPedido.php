<?php
    include 'conexion.php';
	$cantidad = $_POST["cantidad"];
	$estado = $_POST["estado"];
	$observacion = $_POST["observacion"];
    $idPedido = $_POST["idPedido"];
    $idPlato = $_POST["idPlato"];

	$sql="INSERT INTO platopedido(cantidad, estado, observacion, idPedido, idPlato) VALUES (?,?,?,?,?)";
	$stm=$conexion->prepare($sql);
	$stm->bind_param('iisii', $cantidad,$estado,$observacion,$idPedido,$idPlato);
    
	if($stm->execute()){
		echo "registra";
	}else{
		echo "no registra";
	}
	
    mysqli_close($conexion);