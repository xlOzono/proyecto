import java.io.IOException;
import Clases.Ficha.Ficha;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ContAtencionDeLaMascotaIngresoDeIDficha {
    

    @FXML
    private TextArea AreaTextoFicha;

    @FXML
    private ComboBox<Integer> ComboBoxFichasRecientes;

    @FXML
    private Button btConfirmar;

    @FXML
    private Button btVolver;


    @FXML
    void OnActionComboBoxFichasRecientes(ActionEvent event) {
        AreaTextoFicha.setText("");
        AreaTextoFicha.appendText(String.valueOf(ComboBoxFichasRecientes.getSelectionModel().getSelectedItem()));
    }

    @FXML
    void OnDragComboBoxFichasRecientes(MouseEvent event) {

    

    }

    @FXML
    void volverPressed(ActionEvent event) throws IOException {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getClassLoader().getResource("\\Ventanas\\PantallaPrincipal.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Menu Principal");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();

        }
        catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @FXML
    void ConfimarPressed(ActionEvent event) {
        Boolean cotiene = null;
        Ficha ficha = null;
        try {
            for (Ficha f: Ficha.getArrayList()) {
                    if(f.getNumFicha() == Integer.parseInt(AreaTextoFicha.getText())){
                        cotiene = true;
                        ficha = f;
                        break;
                    }
            }
            
            if (cotiene) {
                
                FXMLLoader loader = new FXMLLoader();
                AnchorPane root = (AnchorPane)loader.load(getClass().getResource("\\Ventanas\\AtencionDeLaMascota.fxml").openStream());
                ContAtencionDeLaMascota ContAtencionDeLaMascotainstancia = (ContAtencionDeLaMascota)loader.getController();
                ContAtencionDeLaMascotainstancia.mostrarFicha(ficha);
                Stage stage = new Stage();
                stage.setTitle("Ventana Atención");
                stage.setScene(new Scene(root, 800, 400));
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();

                

                
            }
        
        } catch (Exception e) {
            System.out.println(e);
                Alert a = new Alert(AlertType.NONE);
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Ingrese los datos correctamente");
                a.show(); 
            }
            

    }

    

    @FXML
    void initialize() {
        ObservableList<Integer> idFichas = FXCollections.observableArrayList();
            for (Ficha f: Ficha.getArrayList()) {
            ComboBoxFichasRecientes.setItems(idFichas);
            idFichas.add(f.getNumFicha());
            }
        ComboBoxFichasRecientes.setItems(idFichas);
        assert AreaTextoFicha != null : "fx:id=\"AreaTextoFicha\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert ComboBoxFichasRecientes != null : "fx:id=\"ComboBoxFichasRecientes\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert btConfirmar != null : "fx:id=\"btConfirmar\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert btVolver != null : "fx:id=\"btVolver\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
    
    }
}
