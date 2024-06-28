import java.io.IOException;

import Clases.Ficha.Ficha;
import Clases.Personal.Auxiliar;
import Clases.Personal.Personal;
import Clases.Personal.Veterinaria;
import javafx.scene.Node;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ContAtencionDeLaMascotaIngresoDeIDficha {

    @FXML
    private TextArea AreaTextoFicha;

    @FXML
    private TextArea AreaTextoIngreseRut;

    @FXML
    private TextArea AreaTextoRutAuxiliar;

    @FXML
    private CheckBox CheckBoxAuxiliarRequerrido;

    @FXML
    private ComboBox<Integer> ComboBoxFichasRecientes;

    @FXML
    private Label LabelIngreseElRutDelAuxiliar;

    @FXML
    private Button btConfirmar;

    @FXML
    private Button btVolver;

    @FXML
    void ConfimarPressed(ActionEvent event) {
        
        Boolean contiene = null;
        Boolean contiene2 = null;
        Ficha ficha = null;
        Personal personal = null;
        Personal personal2 = null;
        try {
            for (Ficha f: Ficha.getArrayList()) {
                    if(f.getNumFicha() == Integer.parseInt(AreaTextoFicha.getText())){
                        contiene = true;
                        ficha = f;
                        
                    }
            }
            for(Personal p: Personal.personal){
                if (CheckBoxAuxiliarRequerrido.isSelected()) {
                    if(p.getRut() == Integer.parseInt(AreaTextoIngreseRut.getText()) && p instanceof Veterinaria){              
                        personal = p;
                    }
                    if(p.getRut() == Integer.parseInt(AreaTextoRutAuxiliar.getText()) && p instanceof Auxiliar){
                        System.out.println(p.getRut());
                        personal2 = p;
                    }
                    if (personal != null && personal2 != null && personal != personal2) {
                        contiene2 = true;
                    }
                }
                else
                    if(p.getRut() == Integer.parseInt(AreaTextoIngreseRut.getText())){
                        contiene2 = true;
                        personal = p;
                    
                }
            }
            
            if (contiene && contiene2) {
                
                FXMLLoader loader = new FXMLLoader();
                AnchorPane root = (AnchorPane)loader.load(getClass().getResource("\\Ventanas\\AtencionDeLaMascota.fxml").openStream());
                ContAtencionDeLaMascota ContAtencionDeLaMascotainstancia = (ContAtencionDeLaMascota)loader.getController();
                ContAtencionDeLaMascotainstancia.mostrarFicha(ficha,personal,personal2);
                Stage stage = new Stage();
                stage.setTitle("Ventana Atención");
                stage.setScene(new Scene(root, 911, 498));
                stage.setResizable(false);
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
    void OnActionCheckBoxAuxiliarRequerrido(ActionEvent event) {
        
        if(CheckBoxAuxiliarRequerrido.isSelected()){
            LabelIngreseElRutDelAuxiliar.setDisable(false);
            AreaTextoRutAuxiliar.setDisable(false);
        }else{
            LabelIngreseElRutDelAuxiliar.setDisable(true);
            AreaTextoRutAuxiliar.setDisable(true);
        }
    }

    @FXML
    void OnActionComboBoxFichasRecientes(ActionEvent event) {
        AreaTextoFicha.setText("");
        AreaTextoFicha.setText(String.valueOf(ComboBoxFichasRecientes.getSelectionModel().getSelectedItem()));
        

    }

    @FXML
    void OnDragComboBoxFichasRecientes(MouseEvent event) {

    }

    @FXML
    /* Si se pulsa el botón volver se ejecuta el evento para crear la pestaña anterior y esconder la actual
     * esto creando un stage y definiendo su tamaño en stage.setScene(new(root,alto,largo)) luego definiendo que
     * la variable no se pueda cambiar de tamaño con el método .setResizable y por ultimo mostrandola con el show
     * y ocultandola en el método de ((Node)(event.getSource())).getScene().getWindow().hide();
     */
    void volverPressed(ActionEvent event) throws IOException {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getClassLoader().getResource("\\Ventanas\\PantallaPrincipal.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Menu Principal");
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();

        }
        catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    @FXML
    void initialize() {
        /*Se definen los valores del comboBox recorriendo la lista de objetos tipo Ficha que se encuentra
          como atributo mediante el método de la clase Ficha getArrayList*/
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
