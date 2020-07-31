package Clases;

public class Mesero {
    private int idMesero;
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String celular;
    private String codigo;
    private String horario;
    private double sueldo;

    public Mesero (){
    }

    public Mesero (int idMesero, String cedula,  String nombre, String apellido, String direccion,  String celular,String codigo, String horario, double sueldo){
        this.idMesero=idMesero;
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
        this.celular=celular;
        this.codigo=codigo;
        this.horario=horario;
        this.sueldo=sueldo;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
