
package System;

import utils.Utilerias;

class ItemOrden {
    private int noLinea;
    private int cantidad;
    private static int siguienteNoLinea = 1;
    private double producto;

    public ItemOrden(){
        this.noLinea = siguienteNoLinea++;
    }
    public ItemOrden(int pCantidad, double pldProducto) {
        this();
        this.cantidad = pCantidad;
        this.producto = pldProducto;
    }

    //Creamos los metodos getters y setters
    public int getNoLinea() {
        return noLinea;
    }

    public void setNoLinea(int noLinea) {
        this.noLinea = noLinea;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getTotalOrden(){
        return (cantidad * producto);
    }
    
    public String toString(){
        return "["+Utilerias.getNombreOrden()+"]" + " No. 0000" + noLinea;
    }
    
}
