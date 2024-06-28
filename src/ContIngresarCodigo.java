import java.io.IOException;

import Clases.Animales.Animal;
import Clases.Animales.Granja.Granja;
import Clases.Ficha.Ficha;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ContIngresarCodigo {

    @FXML
    private Button btAceptarCodigo;

    @FXML
    private Button btVolver;

    @FXML
    private TextField entryCodigo;

    @FXML
    private Label lbFicha;

    @FXML
    void aceptarPressed(ActionEvent event) {
        Alert a = new Alert(AlertType.NONE);
        try {
            //Si el arreglo con los animales está vacío o el codigo no se encuentra abre la ventana ingresar mascota
            if (!Granja.containsCodigo(Integer.parseInt(entryCodigo.getText())) || Animal.animales.isEmpty()) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("Ventanas/IngresarGranja.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Ingresar Granja");
                    stage.setScene(new Scene(root, 800, 400));
                    stage.show();
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            //Si se encuentra al animal en la lista, rellena la ficha
            if (Granja.containsCodigo(Integer.parseInt(entryCodigo.getText()))){
                Granja mascota = Granja.getGranja(Integer.parseInt(entryCodigo.getText()));
                Ficha ficha = Ficha.getFicha(mascota);
                lbFicha.setText("Numero de ficha: " + Integer.toString(ficha.getNumFicha()));
            }

        } catch (Exception e) {
            a.setAlertType(AlertType.ERROR);
            a.setContentText("Ingrese un numero");
            a.show();
            // TODO: handle exception
        }
    }

    @FXML
    void volverPressed(ActionEvent event) {
        Parent root;       
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Ventanas/IngresarMascota.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Ingresar Domestico");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}