
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;;

public class ControladorPrincipal {

    @FXML
    private Button btAtender;

    @FXML
    private Button btCobrar;

    @FXML
    private Button btEliminar;

    @FXML
    private Button btGestionar;

    @FXML
    private Button btRecibirMascota;


    @FXML
    void recibirMascotaPressed(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Ventanas\\IngresarMascota.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Ingresar Mascota");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @FXML
    void atenderMascotaPressed(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("\\Ventanas\\AtencionDeLaMascotaIngresoDeIDficha.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Ingresar Mascota");
            stage.setScene(new Scene(root, 622, 344));
            stage.setResizable(false);
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }


    @FXML
    void cobrarPressed(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("\\Ventanas\\CobrarLaAtencion.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Ingresar Mascota");
            stage.setScene(new Scene(root, 1025, 538));
            stage.setResizable(false);
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    
    }

    @FXML
    void eliminarPressed(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Ventanas\\EliminarMascota.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Eliminar Mascota");
            stage.setScene(new Scene(root, 800, 438));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }    
    }

    @FXML
    void gestionarPressed(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Ventanas\\GestionarPersonal.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Gestionar Personal");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }    
    }
}
