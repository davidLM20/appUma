<?php
include 'conexion.php';

//$usu_usuario="12002";
//$usu_password="gabda02";

$result=$conexion->query("SELECT * FROM plato");
$numFilas= $result->num_rows;
$array=array();
for($x=0;$x<$numFilas;$x++){
    $fila = ($result->fetch_object());
    utf8_encode_deep($fila);
    $array[]=$fila;
    //echo json_encode($fila);
}
echo json_encode($array, JSON_UNESCAPED_UNICODE);

$result->close();
$conexion->close();

function utf8_encode_deep($input)
{
    if (is_string($input)) {
        $input = utf8_encode($input);
    } else if (is_array($input)) {
        foreach ($input as &$value) {
            utf8_encode_deep($value);
        }

        unset($value);
    } else if (is_object($input)) {
        $vars = array_keys(get_object_vars($input));

        foreach ($vars as $var) {
            utf8_encode_deep($input->$var);
        }
    }
}

?>