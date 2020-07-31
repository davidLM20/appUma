package Clases;

public class Plato {
    public int idPlato;
    public String nombre;
    public double costo;
    public String descripcion;
    public double tiempo;

    public Plato() {
    }

    public Plato(int idPlato, String nombre, String descripcion, double costo, double tiempo) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.costo = costo;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
    }

    public int getIdPlato(){
        return  idPlato;
    }

    public void setIdPlato(int idPlato){
        this.idPlato = idPlato;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Plato{" + "nombre=" + nombre + ", costo=" + costo + ", descripcion=" + descripcion + ", tiempo=" + tiempo + '}';
    }
}
