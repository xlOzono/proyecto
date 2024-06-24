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
    private Button brRecibirMascota;


    @FXML
    void recibirMascota(ActionEvent event) {
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
}
