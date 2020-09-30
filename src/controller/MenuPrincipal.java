
package controller;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
 
public class MenuPrincipal extends Application {

    @Override
    public void start(Stage stage) {
 
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuPrincipal.class.getResource("/view/aplicacionVista.fxml"));
            
            // Cargo la ventana 
            Pane ventana = (Pane) loader.load();
 
            // Cargo el scene
            Scene scene = new Scene(ventana);
 
            // Seteo la scene y la muestro
            stage.setTitle("Auto Partes");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
}
