
import java.io.IOException;
import Clases.Animales.Animal;
import Clases.Animales.Domesticos.Domestico;
import Clases.Ficha.Ficha;
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
    private Button btVolver;

    @FXML
    private TextField entryNombre;

    @FXML
    private Label lbFicha;

    @FXML
    void aceptarPressed(ActionEvent event) {
        try {
            //Si el arreglo con los animales está vacío o el codigo no se encuentra abre la ventana ingresar mascota
            if (!Domestico.containsName(entryNombre.getText()) || Animal.animales.isEmpty()) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("Ventanas/IngresarDomestico.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Ingresar Domestico");
                    stage.setScene(new Scene(root, 800, 400));
                    stage.show();
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            //Si se encuentra al animal en la lista, rellena la ficha
            if (Domestico.containsName(entryNombre.getText())){
                Domestico mascota = Domestico.getDomestico(entryNombre.getText());
                Ficha ficha = Ficha.getFicha(mascota);
                lbFicha.setText("Numero de ficha: " + Integer.toString(ficha.getNumFicha()));
            }
        } catch (NumberFormatException e) {
            System.out.println("Error");
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
