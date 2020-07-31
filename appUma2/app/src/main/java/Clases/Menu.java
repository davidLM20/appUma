package Clases;

import java.util.ArrayList;

public class Menu {
    private String nombre;
    private String descripcion;
    private String dias;
    private String meses;
    private ArrayList<Plato> listaPlatosMenu = new ArrayList<>();

    public Menu() {
    }

    public Menu(String nombre, String descripcion, String dias, String meses) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dias = dias;
        this.meses = meses;
    }

    public void AgregarPlato(Plato plato){
        this.listaPlatosMenu.add(plato);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getMeses() {
        return meses;
    }

    public void setMeses(String meses) {
        this.meses = meses;
    }

    public ArrayList<Plato> getListaPlatosMenu() {
        return listaPlatosMenu;
    }

    public void setListaPlatosMenu(ArrayList<Plato> listaPlatosMenu) {
        this.listaPlatosMenu = listaPlatosMenu;
    }

    @Override
    public String toString() {
        return "Menu{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", dias=" + dias + ", meses=" + meses + ", listaPlatosMenu=" + listaPlatosMenu + '}';
    }
}
