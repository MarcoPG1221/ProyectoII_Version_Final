
package System;

import model.Producto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Empresa;
import model.Individual;

/**
 *
 * @author pc
 */
public class DataSistema {
    
    public static List<Cliente> clienteIndividual;
    public static List<Cliente> clienteEmpresa;
    public static List<Producto> productos;
    public static List<Orden> orden;
    public static Producto pro;
    public static ItemOrden item;
    public static Cliente cl;
    
    public DataSistema(){
        clienteIndividual = new ArrayList();
        clienteEmpresa = new ArrayList();
        productos = new ArrayList();
        orden = new ArrayList();
    }
    
    public void addClienteIndividual(Individual i){
        int tamano = clienteIndividual.size();
        //con un if validaremos que solo se puedan registrar 4 clientes
        if(tamano <= 3){
           clienteIndividual.add(i);     
           JOptionPane.showMessageDialog(null,"Cliente Registrado");
        }else{
            JOptionPane.showMessageDialog(null,"Solo Puede Registrar 4 Clientes");
        }   
    }
    
    //Metodo booleano que usaremos para eliminar un cliente en especifico
    public boolean EliminarClienteIndividual( int numero){
        int tam = clienteIndividual.size();
        //Verificamos que si se encuentra vacia
        if(tam == 0){
            JOptionPane.showMessageDialog(null,"Cliente no encontrado");
        }
        //Hacemos un Recorrido en busca del id
        for(int i = 0; i < tam; i++){
            if(numero == clienteIndividual.get(i).getId()){
                //Eliminamos el cliente
                clienteIndividual.remove(i);
                JOptionPane.showMessageDialog(null,"Cliente Eliminado");
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"Cliente no encontrado");
            }
        }
        return false;
    }
    
    public void CambioClienteIndividual(int buscar, String nombres, String apellidos, String direccion, String dpi){
        int tam = clienteIndividual.size();
        for(int i = 0; i < tam; i++ ){
            if(buscar == clienteIndividual.get(i).getId()){
                Individual ci = new Individual();
                ci.setId(clienteIndividual.get(i).getId());
                ci.setNombres(nombres);
                ci.setApellidos(apellidos);
                ci.setDireccion(direccion);
                ci.setDPI(dpi);
                clienteIndividual.add(ci);
                JOptionPane.showMessageDialog(null,"Cliente Cambiado");
                clienteIndividual.remove(i);
            }
        }
    }
    
    public void addClienteEmpresa(Empresa e){
        int tamano = clienteEmpresa.size();
        //con un if validaremos que solo se puedan registrar 4 clientes
        if(tamano <= 3){
           clienteEmpresa.add(e);
           JOptionPane.showMessageDialog(null,"Cliente Registrado");
        }else{
           JOptionPane.showMessageDialog(null,"Solo Puede Registrar 4 Clientes");
        }
    }
    
    //Metodo booleano que usaremos para eliminar un cliente en especifico
    public boolean EliminarClienteEmpresa(int numero){
        int tam = clienteEmpresa.size();
        //Verificamos que si se encuentra vacia
        if(tam == 0){
            JOptionPane.showMessageDialog(null,"Cliente no encontrado");
        }
        //Hacemos un Recorrido en busca del id
        for(int i = 0; i < tam; i++){
            if(numero == clienteEmpresa.get(i).getId()){
                //Eliminamos el cliente
                clienteEmpresa.remove(i);
                JOptionPane.showMessageDialog(null,"Cliente Eliminado");
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"Cliente no encontrado");
            }
        }
        return false;
    }
    
    public void CambioClienteE(int buscar, String nombres, String apellidos, String direccion, String contacto){
        int tam = clienteEmpresa.size();
        for(int i = 0; i < tam; i++ ){
            if(buscar == clienteEmpresa.get(i).getId()){
                Empresa ce = new Empresa();
                ce.setId(clienteEmpresa.get(i).getId());
                ce.setNombres(nombres);
                ce.setApellidos(apellidos);
                ce.setDireccion(direccion);
                ce.setContacto(contacto);
                clienteEmpresa.add(ce);
                JOptionPane.showMessageDialog(null,"Cliente Cambiado");
                clienteEmpresa.remove(i);
            }
        }
    }
    
    public void addProductos(Producto p){
        int tamano = productos.size();
        if(tamano <= 8){
           productos.add(p);     
           JOptionPane.showMessageDialog(null,"Producto Registrado");
        }else{
            JOptionPane.showMessageDialog(null,"Solo Puede Registrar 8 Productos");
        }   
    }
    
    //Metodo booleano que usaremos para eliminar un cliente en especifico
    public boolean EliminarProducto(int numero){
        int tam = productos.size();
        //Verificamos que si se encuentra vacia
        if(tam == 0){
            JOptionPane.showMessageDialog(null,"Producto no encontrado");
        }
        //Hacemos un Recorrido en busca del id
        for(int i = 0; i < tam; i++){
            if(numero == productos.get(i).getId()){
                //Eliminamos el producto
                productos.remove(i);
                JOptionPane.showMessageDialog(null,"Producto Eliminado");
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"Producto no encontrado");
            }
        }
        return false;
    }
    
    public void CambioProducto(int buscar, String nom, Double pre){
        int tam = productos.size();
        for(int i = 0; i < tam; i++ ){
            if(buscar == productos.get(i).getId()){
                
                Producto pro = new Producto();
                pro.setId(productos.get(i).getId());
                pro.setNombreProducto(nom);
                pro.setPrecio(pre);
                productos.add(pro);
                
                JOptionPane.showMessageDialog(null,"Producto Cambiado");
                productos.remove(i);
            }
        }
    }
    
    
    public boolean BuscarClientes(int buscar){
        int tam = clienteIndividual.size();
        int tamano = clienteEmpresa.size();
        for(int i = 0; i < tam; i++ ){
            if(buscar == clienteIndividual.get(i).getId()){
                cl = new Cliente();
                cl.setId(clienteIndividual.get(i).getId());
                cl.setNombres(clienteIndividual.get(i).getNombres());
                cl.setApellidos(clienteIndividual.get(i).getApellidos());
                cl.setDireccion(clienteIndividual.get(i).getDireccion());
                JOptionPane.showMessageDialog(null,"Cliente Registrado Tipo Individual");
                return true;
            }
        }
        
        for(int j = 0; j < tamano ; j++){
            if(buscar == clienteEmpresa.get(j).getId()){
                cl = new Cliente();
                cl.setId(clienteEmpresa.get(j).getId());
                cl.setNombres(clienteEmpresa.get(j).getNombres());
                cl.setApellidos(clienteEmpresa.get(j).getApellidos());
                cl.setDireccion(clienteEmpresa.get(j).getDireccion());
                JOptionPane.showMessageDialog(null,"Cliente Registrado Tipo Empresa");
                return true;
            }
        }
        return false;
    }
    
    public boolean addOrden(int idP,int cantidad, Date fecha, double precioEnvio, String tipoEnvio, int diasEnvio){
        
        int tam = productos.size();
        for(int i = 0; i < tam; i++ ){
            if(idP == productos.get(i).getId()){
                //inicializamos el producto
                pro = new Producto();
                //luego guardamos los datos del producto
                pro.setId(productos.get(i).getId());
                pro.setNombreProducto(productos.get(i).getNombreProducto());
                pro.setPrecio(productos.get(i).getPrecio());
                //con la clase item enviaremos el precio del producto y la cantidad para calcular el precio final
                item = new ItemOrden(cantidad, productos.get(i).getPrecio());
                //Creamos una clase Orden la cual nos almacenara todos los datos de las ordenes de compra
                Orden o = new Orden(fecha,precioEnvio,tipoEnvio,diasEnvio,cl,pro,item);
                orden.add(o);
                JOptionPane.showMessageDialog(null,"Compra Realizada con Exito");
                return true;
            }
        }
        return false;
    }
    
    public boolean BorrarCompra(int buscarCompra){
        int tam = orden.size();
        for(int i = 0; i < tam; i++){
            if(buscarCompra == orden.get(i).getId()){
                orden.remove(i);
                return true;
            }
        }
        return false;
    }
    
    //Declaramos los Gettes para devolver valores
    public List<Cliente> getClienteIndividual() {
        return clienteIndividual;
    }

    public List<Cliente> getClienteEmpresa() {
        return clienteEmpresa;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Orden> getOrden() {
        return orden;
    }   
    
}
