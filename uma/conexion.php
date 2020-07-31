<?php
$hostname='localhost';
$database='umadb1';
$username='root';
$password='4chpMlJJ9ACITu0X';

$conexion=new mysqli($hostname,$username,$password,$database);
if($conexion->connect_errno){
    echo "El sitio web está experimentado problemas";
}
?>