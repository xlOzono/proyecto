import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Clases.Personal.Auxiliar;
import Clases.Personal.Veterinaria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ContAgregarPersonal {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btAgregar;

    @FXML
    private Button btVolver;

    @FXML
    private ComboBox<String> cbRol;

    @FXML
    private TextField entryApellido;

    @FXML
    private TextField entryDestreza;

    @FXML
    private TextField entryEspecialidad;

    @FXML
    private TextField entryNombre;

    @FXML
    private TextField entryRut;

    @FXML
    private TextField entryTitulo;

    @FXML
    private Label lbDestreza;

    @FXML
    private Label lbEspecialidad;

    @FXML
    private Label lbTitulo;

    @FXML
    void agregarPressed(ActionEvent event) {
        Alert a = new Alert(AlertType.NONE);
        try {
            if (cbRol.getSelectionModel().getSelectedItem().equals("Veterinaria")) {
                Veterinaria nuevo = new Veterinaria(Integer.parseInt(entryRut.getText()), entryNombre.getText(), entryApellido.getText(), entryTitulo.getText(), entryEspecialidad.getText());                
                a.setAlertType(AlertType.INFORMATION);
                a.setContentText("Creado con exito\nFecha de Contratacion: "+ nuevo.getFechaContratacion());
                a.show();
            }else if (cbRol.getSelectionModel().getSelectedItem().equals("Auxiliar")) {
                Auxiliar nuevo = new Auxiliar(Integer.parseInt(entryRut.getText()), entryNombre.getText(), entryApellido.getText(), entryDestreza.getText());
                a.setAlertType(AlertType.INFORMATION);
                a.setContentText("Creado con exito\nFecha de Contratacion: "+ nuevo.getFechaContratacion());
                a.show();
            }
            entryRut.setText("");
            entryNombre.setText("");
            entryApellido.setText("");
            cbRol.getSelectionModel().clearSelection();
            entryTitulo.setText("");
            entryEspecialidad.setText("");
            entryDestreza.setText("");
            
        } catch (Exception e) {
            a.setAlertType(AlertType.ERROR);
            a.setContentText("Ingrese los datos correctamente");
            a.show();
        }
    }

    @FXML
    void cbRolPressed(ActionEvent event) {
        if (cbRol.getSelectionModel().getSelectedItem().equals("Veterinaria")) {
            entryDestreza.setDisable(true);
            lbDestreza.setStyle("-fx-text-fill: grey");

            entryTitulo.setDisable(false);
            lbTitulo.setStyle("-fx-text-fill: black");
            entryEspecialidad.setDisable(false);
            lbEspecialidad.setStyle("-fx-text-fill: black");
        }else {
            entryDestreza.setDisable(false);
            lbDestreza.setStyle("-fx-text-fill: black");

            entryTitulo.setDisable(true);
            lbTitulo.setStyle("-fx-text-fill: grey");
            entryEspecialidad.setDisable(true);
            lbEspecialidad.setStyle("-fx-text-fill: grey");
        }
    }
    
    @FXML
    void volverPressed(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Ventanas/GestionarPersonal.fxml"));
            Stage stage = new Stage();
            stage.setTitle("GestionarPersonal");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        List<String> list = new ArrayList<String>();
        list.add("Veterinaria");
        list.add("Auxiliar");
        ObservableList<String> obList = FXCollections.observableList(list);
        cbRol.setItems(obList);
        cbRol.getSelectionModel().selectFirst();

        entryDestreza.setDisable(true);
        lbDestreza.setStyle("-fx-text-fill: grey");
    }

}
