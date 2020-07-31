<?php
    include 'conexion.php';
	$numMesa = $_POST["numMesa"];
	$numeroPedido = $_POST["numeroPedido"];
	$tiempoAproximado = $_POST["tiempoAproximado"];
    $estado = $_POST["estado"];
    $idMesero = $_POST["idMesero"];


	$bytesArchivo=file_get_contents($path);

	$sql="INSERT INTO pedido(numMesa, numeroPedido, tiempoAproximado, estado, idMesero) VALUES (?,?,?,?,?)";
	$stm=$conexion->prepare($sql);
	$stm->bind_param('issss', $numMesa,$numeroPedido,$tiempoAproximado,$estado,$idMesero);
		
	if($stm->execute()){
		echo "registra";
	}else{
		echo "noRegistra";
	}
	
    mysqli_close($conexion);
