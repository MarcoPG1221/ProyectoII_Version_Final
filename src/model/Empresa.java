
package model;

/**
 *
 * @author pc
 */
public class Empresa extends Cliente {
    private String contacto;
    private int descuento;

    public Empresa(){
        //constructor Vacio
    }
    //Mandamos a llamar el constructor de la clase Cliente y agregamos las demas variables
    public Empresa(String nombres, String apellidos, String direccion, String contacto) {
        super(nombres, apellidos, direccion);
        this.contacto = contacto;
    }

    //Creamos los metodos getter y setters
    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    
    //Creamos el metodo toString y mandamos llamar los valores de la clase Cliente
    public String toString(){
        return super.toString() + "\tTelefono: "+contacto;
    }
    
}
