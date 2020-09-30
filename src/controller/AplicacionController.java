
package controller;

import System.DataSistema;
import System.Orden;
import model.Producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import java.util.Date;
import javafx.scene.control.Label;
import model.Cliente;
import model.Empresa;
import model.Individual;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class AplicacionController implements Initializable {  
    //Declaramos las Clases private static
    private static DataSistema sistema = new DataSistema();
    private static Cliente cliente;
    private static Producto producto;
    private static Orden orden;
    private static Date fecha = new Date();
    //Creamos el ObservableList para ingresasr los datos en la Table
    private static ObservableList<Cliente> data;
    private static ObservableList<Producto> productos;
    private static ObservableList<Orden> ordenes;
    //Cliente Individual
    //TextField
    @FXML
    private TextField txtNombreIndividual;
    @FXML
    private TextField txtApellidoIndividual;
    @FXML
    private TextField txtDireccionIndividual;
    @FXML
    private TextField txtDpiIndividual;
    //Button
    @FXML
    private Button btnAltasIndividual;
    @FXML
    private Button btnBajasIndividual;
    @FXML
    private Button btnCambioIndividual;
    
    //Cliente Empresa
    //TextField
    @FXML
    private TextField txtNombreEmpresa;
    @FXML
    private TextField txtApellidoEmpresa;
    @FXML
    private TextField txtDireccionEmpresa;
    @FXML
    private TextField txtContactoEmpresa;
    //Button
    @FXML
    private Button btnAltasEmpresa;
    @FXML
    private Button btnBajasEmpresa;
    @FXML
    private Button btnCambioEmpresa;
    
    //Datos de la Ventana Cliente
    @FXML
    private Pane PaneCliente;
    @FXML
    private Pane PaneReporteClientes;
    
    //Datos Producto
    //TextField
    @FXML
    private TextField txtnombreProducto;
    @FXML
    private TextField txtprecio;
    //Button
    @FXML
    private Button btnAltasProducto;
    @FXML
    private Button btnBajasProducto;
    @FXML
    private Button btnCambioProducto;
    
    //Datos de la Ventana Producto
    @FXML
    private Pane PaneRegistroProducto;
    @FXML
    private Pane PaneInventarioProducto;
    
    //ListView Utilizadas
    @FXML
    private ListView LIstViewproducto;
    @FXML
    private ListView LIstViewIndividual;
    @FXML
    private ListView LIstViewEmpresa;
    
    //Metodo Comprar Producto
    @FXML
    private Pane PaneComprar;
    @FXML
    private TextField txtIdCli;
    @FXML
    private TextField txtIdPro;
    @FXML
    private TextField txtPrecioEnvio;
    @FXML
    private TextField txtTipoEnvio;
    @FXML
    private TextField txtDiasEnvio;
    @FXML
    private TextField txtCantidad;
    @FXML
    private Button ButtonComprar;
    @FXML
    private Button ButtonBuscar;
    @FXML
    private Pane PaneOrdenes;
    @FXML
    private ListView ListViewCompras;
    @FXML
    private Button buttonEliminar;
    /**
     * Initializes the controller class.
     * 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        
    }
    //Controles para Cliente Individual
    //Funcionalidad del Botton Altas
    @FXML
    private void AltasIndividual(ActionEvent event) {
        //Creamos un objeto de cliente Individual
        cliente = new Individual (txtNombreIndividual.getText(),txtApellidoIndividual.getText(),
                txtDireccionIndividual.getText(),this.txtDpiIndividual.getText());
        //Agregamos el objeto Individual a DataSistema
        sistema.addClienteIndividual( (Individual) cliente);
        //Agregamos a la Table
        data = FXCollections.observableList(sistema.getClienteIndividual());
        LIstViewIndividual.setItems(data);
        //Despues de registrar refrescamos
        txtNombreIndividual.setText("");
        txtApellidoIndividual.setText("");
        txtDireccionIndividual.setText("");
        txtDpiIndividual.setText("");
    }
    
    //Funcionalidad del Botton Bajas
    @FXML
    private void BajasIndividual(ActionEvent event) {
        int buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingres el id a buscar: "));
        sistema.EliminarClienteIndividual(buscar);
        data = FXCollections.observableList(sistema.getClienteIndividual());
        LIstViewIndividual.setItems(data);
    }
    //Funcionalidad del Botton Cambio
    @FXML
    private void CambioIndividual(ActionEvent event) {
        int buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id a buscar: "));
        //Creamos dos variables nuevas para cambiar los datos
        sistema.CambioClienteIndividual(buscar,txtNombreIndividual.getText(),txtApellidoIndividual.getText(),
                txtDireccionIndividual.getText(),this.txtDpiIndividual.getText());
        //Acutalizamos la ListView
        data = FXCollections.observableList(sistema.getClienteIndividual());
        LIstViewIndividual.setItems(data);
        txtNombreIndividual.setText("");
        txtApellidoIndividual.setText("");
        txtDireccionIndividual.setText("");
        txtDpiIndividual.setText("");
        
    }
    
    //Controles para Cliente Empresa
    //Funcionalidad del Botton Altas
    @FXML
    private void AltasEmpresa(ActionEvent event) {
        //Creamos un objeto de cliente Individual
        cliente = new Empresa (txtNombreEmpresa.getText(),txtApellidoEmpresa.getText(),
                txtDireccionEmpresa.getText(),this.txtContactoEmpresa.getText());
        //Agregamos el objeto Individual a DataSistema
        sistema.addClienteEmpresa((Empresa) cliente);
        //Agregamos a la Table
        data = FXCollections.observableList(sistema.getClienteEmpresa());
        LIstViewEmpresa.setItems(data);
        //Despues de registrar los datos refrescamos
        txtNombreEmpresa.setText("");
        txtApellidoEmpresa.setText("");
        txtDireccionEmpresa.setText("");
        txtContactoEmpresa.setText("");   
    }//fin procedimiento AltasEmpresa
    
    //Funcionalidad del Botton Bajas
    @FXML
    private void BajasEmpresa(ActionEvent event) {
        int buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id a buscar: "));
        sistema.EliminarClienteEmpresa(buscar);
        data = FXCollections.observableList(sistema.getClienteEmpresa());
        LIstViewEmpresa.setItems(data);
    }
    
    //Funcionalidad del Botton Cambio
    @FXML
    private void CambioEmpresa(ActionEvent event) {
        int buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id a buscar: "));
        //Creamos dos variables nuevas para cambiar los datos
        sistema.CambioClienteE(buscar,txtNombreEmpresa.getText(),txtApellidoEmpresa.getText(),
                txtDireccionEmpresa.getText(),this.txtContactoEmpresa.getText()); 
        //Acutalizamos la ListView
        data = FXCollections.observableList(sistema.getClienteEmpresa());
        LIstViewEmpresa.setItems(data);
        txtNombreEmpresa.setText("");
        txtApellidoEmpresa.setText("");
        txtDireccionEmpresa.setText("");
        txtContactoEmpresa.setText("");
    }

    //Funcionalidad de Producto
    //Funcionalidad del Botton Altas
    @FXML
    private void AltasProducto(ActionEvent event) {
        //Creamos un objeto de tipo Producto
        producto = new Producto(txtnombreProducto.getText(),Double.parseDouble(txtprecio.getText()));
        //Agregamos el producto a DataSistema
        sistema.addProductos(producto);
        //Agregamos a la Table
        productos = FXCollections.observableList(sistema.getProductos());
        LIstViewproducto.setItems(productos); 
        txtnombreProducto.setText("");
        txtprecio.setText("");
    }
    
    //Funcionalidad del Botton Bajas
    @FXML
    private void BajasProducto(ActionEvent event) {
        int buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id a buscar: "));
        sistema.EliminarProducto(buscar);
        productos = FXCollections.observableList(sistema.getProductos());
        LIstViewproducto.setItems(productos);
    }

    //Funcionalidad del Botton Cambio
    @FXML
    private void CambioProducto(ActionEvent event) {
        int buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id a buscar: "));
        //Creamos dos variables nuevas para cambiar los datos
        String nombreP = txtnombreProducto.getText();
        Double precio = Double.parseDouble(txtprecio.getText());
        //Agregamos el producto a DataSistema
        sistema.CambioProducto(buscar, nombreP, precio);
        //Acutalizamos la ListView
        productos = FXCollections.observableList(sistema.getProductos());
        LIstViewproducto.setItems(productos);
        txtnombreProducto.setText("");
        txtprecio.setText("");   
    }
    
    //Buscar y verificar que el cliente este registrado
    @FXML
    private void Buscar(ActionEvent event) {
        if(sistema.BuscarClientes(Integer.parseInt(txtIdCli.getText()))==true){
            JOptionPane.showMessageDialog(null, "Se Puede Realizar la Compra");
        }else if(sistema.BuscarClientes(Integer.parseInt(txtIdCli.getText()))==false){
                JOptionPane.showMessageDialog(null,"No se Puede Realizar la Compra");
        }
        txtIdCli.setText("");
    }
    
    @FXML
    private void CrearComprar(ActionEvent event) {
        sistema.addOrden(Integer.parseInt(txtIdPro.getText()),Integer.parseInt(txtCantidad.getText()),
                fecha,Double.parseDouble(txtPrecioEnvio.getText()),txtTipoEnvio.getText(),
                Integer.parseInt(txtDiasEnvio.getText()));
        ordenes = FXCollections.observableList(sistema.getOrden());
        ListViewCompras.setItems(ordenes);
        txtPrecioEnvio.setText("");
        txtTipoEnvio.setText("");
        txtDiasEnvio.setText("");
        txtIdPro.setText("");
        txtCantidad.setText("");
    }
    
    @FXML
    private void EliminarCompra(ActionEvent event) {
        int buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de orden: "));
        sistema.BorrarCompra(buscar);
        ordenes = FXCollections.observableList(sistema.getOrden());
        ListViewCompras.setItems(ordenes);
    }

    //Abriendo ventanas y Cerrando Ventanas
    @FXML
    private void RegistroDeClientes(ActionEvent event) {
        PaneCliente.setVisible(true);
        PaneReporteClientes.setVisible(false);
        PaneRegistroProducto.setVisible(false);
        PaneInventarioProducto.setVisible(false);
        PaneComprar.setVisible(false);
        PaneOrdenes.setVisible(false);
    }

    @FXML
    private void showMostrarClientes(ActionEvent event) {
        PaneReporteClientes.setVisible(true);
        PaneCliente.setVisible(false);
        PaneRegistroProducto.setVisible(false);
        PaneInventarioProducto.setVisible(false);
        PaneComprar.setVisible(false);
        PaneOrdenes.setVisible(false);
    }

    @FXML
    private void showProducto(ActionEvent event) {
        PaneRegistroProducto.setVisible(true);
        PaneReporteClientes.setVisible(false);
        PaneCliente.setVisible(false);
        PaneInventarioProducto.setVisible(false);
        PaneComprar.setVisible(false);
        PaneOrdenes.setVisible(false);
    }

    @FXML
    private void showReporteProducto(ActionEvent event) {
        PaneInventarioProducto.setVisible(true);
        PaneReporteClientes.setVisible(false);
        PaneRegistroProducto.setVisible(false);
        PaneCliente.setVisible(false);
        PaneComprar.setVisible(false);
        PaneOrdenes.setVisible(false);
    }

    @FXML
    private void showComprar(ActionEvent event) {
        PaneComprar.setVisible(true);
        PaneInventarioProducto.setVisible(true);
        PaneReporteClientes.setVisible(false);
        PaneRegistroProducto.setVisible(false);
        PaneCliente.setVisible(false);
        PaneOrdenes.setVisible(false);
    }

    @FXML
    private void showInicio(ActionEvent event) {
        PaneComprar.setVisible(false);
        PaneInventarioProducto.setVisible(false);
        PaneReporteClientes.setVisible(false);
        PaneRegistroProducto.setVisible(false);
        PaneCliente.setVisible(false);
        PaneOrdenes.setVisible(false);
    }

    @FXML
    private void showOrdenCompra(ActionEvent event) {
        PaneOrdenes.setVisible(true);
        PaneComprar.setVisible(false);
        PaneInventarioProducto.setVisible(false);
        PaneReporteClientes.setVisible(false);
        PaneRegistroProducto.setVisible(false);
        PaneCliente.setVisible(false);
    }
}
