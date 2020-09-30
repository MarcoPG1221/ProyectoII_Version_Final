
package model;

import utils.Utilerias;

public class Producto {
    
    private int id;
    private static int sigIdProducto = 2000;
    private String nombreProducto;
    private double precio;

    //Creamos un constructor vacio y uno con parámetros
    public Producto(){
        this.id = sigIdProducto++;
    }
    
    public Producto(String nombreProducto, double precio) {
        this(); //llamada al contructor sin parametros
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }
    
    //Creamos los metodos getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    //Declaramos un metodo toString para devolver los valores ingresados
    public String toString(){
        return "["+Utilerias.getNombreProducto()+"]\t" + "id: "+id+"\t\tNombre: "+nombreProducto+"\t\tPrecio: Q. "+precio;
    }
    
}
