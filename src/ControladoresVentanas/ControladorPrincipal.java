package ControladoresVentanas;
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

    }

    @FXML
    void cobrarPressed(ActionEvent event) {

    }

    @FXML
    void eliminarPressed(ActionEvent event) {

    }

    @FXML
    void gestionarPressed(ActionEvent event) {

    }
}
