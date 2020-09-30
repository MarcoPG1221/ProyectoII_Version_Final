
package model;

import utils.Utilerias;

public class Cliente {
    private int id;
    private static int sigIdCliente = 1;
    private String nombres;
    private String apellidos;
    private String direccion;
    
    //declaramos un contructor vacio y uno principal
    public Cliente(){
        this.id = sigIdCliente++;
    }

    public Cliente(String nombres, String apellidos, String direccion) {
        this(); //llamada del contructor sin parametros
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    //Declaramos un metodo toString para devolver los valores ingresados
    @Override
    public String toString(){
        return "["+Utilerias.getNombreClase()+"]\t" + "id: "+id+"\tNombre: "+nombres+" "+apellidos+"\tDireccion: "+direccion;
    }  
}
