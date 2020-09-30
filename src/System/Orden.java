
package System;

import model.Producto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Cliente;
import model.Empresa;
import model.Individual;

public class Orden {
    private int id;
    private Cliente cliente;
    private ItemOrden item1;
    private ItemOrden item2;
    private Date fechaOrden;
    private double precioEnvio;
    private double total;
    private String tipoEnvio;
    private static String estado = "activo";
    private static int sigIdOrden = 1;
    private int diasEnvio;
    private Producto pro;
    
    //Creamos un primer constructor con solo el id, total y fechaOrden
    public Orden(){
        this.id = sigIdOrden++;
        this.total = 0.0;
        this.fechaOrden = new Date();
    }
    
    public Orden(Date pFecha, double precioEnvio, String tipoEnvio, int diasEnvio, Cliente c, Producto pro, ItemOrden orden){
        this(); //llamada al contructor sin parametros
        this.fechaOrden = pFecha;
        this.precioEnvio = precioEnvio;
        this.tipoEnvio = tipoEnvio;
        this.diasEnvio = diasEnvio;
        this.cliente = c;
        this.pro = pro;
        this.item1 = orden;
    }
    
    public Orden(int pCliente, Date pFecha){
        
    }
       
    public double getTotalOrden(){
        return total;
    }

    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String Fechaformateada = sdf.format(fechaOrden);
        
        return  "No. Orden: " + id +"\n" + cliente + "\nFecha de Compra: " + Fechaformateada + 
                "\nPrecio de Envio: Q." + precioEnvio + "\tTipo de Envio: " + tipoEnvio + "\tDias de Envio: " + diasEnvio + " dias" + 
                "\tEstado: " + estado +"\nProductos Adquiridos:\n"+ pro + "\tcantidad: "+ item1.getCantidad() +
                "\nTotal a Pagar: \t\tQ. "+ item1.getTotalOrden() +"\n";
    }
}
