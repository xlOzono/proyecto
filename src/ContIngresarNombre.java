
import java.io.IOException;

import Clases.Animales.Animal;
import Clases.Animales.Domesticos.Domestico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;


public class ContIngresarNombre {

    @FXML
    private Button btAceptarNombre;

    @FXML
    private TextField entryNombre;

    @FXML
    private Label lbFicha;

    @FXML
    void aceptarPressed(ActionEvent event) {
        //Si el arreglo con los animales está vacío abre la ventana ingresar mascota
        if (Animal.animales.isEmpty()) {
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("Ventanas/IngresarDomestico.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Ingresar Domestico");
                stage.setScene(new Scene(root, 600, 400));
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Si no está vacía, busca en el arreglo el nombre del animal para rellenar la ficha
        for(Animal animal: Animal.animales){
            //Si se encuentra al animal en la lista, rellena la ficha
            if (animal instanceof Domestico && ((Domestico)animal).getNombre().equals(entryNombre.getText())){
                lbFicha.setText("ValoresFicha");
            }
            else{
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("Ventanas/IngresarDomestico.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Ingresar Domestico");
                    stage.setScene(new Scene(root, 600, 400));
                    stage.show();
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
