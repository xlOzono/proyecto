import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Clases.Auxiliar;
import Clases.Personal;
import Clases.Veterinaria;
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

public class ContModificarPersonal {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button btBuscar;

    @FXML
    private Button btModificar;

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
    private Label lbApellido;

    @FXML
    private Label lbDestreza;

    @FXML
    private Label lbEspecialidad;

    @FXML
    private Label lbNombre;

    @FXML
    private Label lbRol;

    @FXML
    private Label lbTitulo;

    @FXML
    void buscarPressed(ActionEvent event) {
        Alert a = new Alert(AlertType.NONE);
        try {
            entryNombre.setText("");
            entryApellido.setText("");
            entryTitulo.setText("");
            entryEspecialidad.setText("");
            entryDestreza.setText("");
            cbRol.getSelectionModel().clearSelection();

            Personal trabajador = Personal.getTrabajador(Integer.parseInt(entryRut.getText()));
            entryNombre.setText(trabajador.getNombre());
            entryApellido.setText(trabajador.getApellido());
            if (trabajador instanceof Veterinaria) {
                cbRol.getSelectionModel().select(0);
                entryTitulo.setText(((Veterinaria)trabajador).getTitulo());
                entryEspecialidad.setText(((Veterinaria)trabajador).getEspecialidad());
                lbTitulo.setStyle("-fx-text-fill: black");
                lbEspecialidad.setStyle("-fx-text-fill: black");
                lbDestreza.setStyle("-fx-text-fill: grey");
                entryTitulo.setDisable(false);
                entryEspecialidad.setDisable(false);
                entryDestreza.setDisable(true);
            }else {
                cbRol.getSelectionModel().select(1);
                entryDestreza.setText(((Auxiliar)trabajador).getDestrezaTecnica());
                lbDestreza.setStyle("-fx-text-fill: black");
                lbTitulo.setStyle("-fx-text-fill: grey");
                lbEspecialidad.setStyle("-fx-text-fill: grey");
                entryTitulo.setDisable(true);
                entryEspecialidad.setDisable(true);
                entryDestreza.setDisable(false);
            }
            
            entryNombre.setDisable(false);
            entryApellido.setDisable(false);
            lbNombre.setStyle("-fx-text-fill: black");
            lbApellido.setStyle("-fx-text-fill: black");
            lbRol.setStyle("-fx-text-fill: black");
        } catch (Exception e) {
            a.setAlertType(AlertType.ERROR);
            a.setContentText("El RUT no existe o no es valido");
            a.show();
        }
    }

    @FXML
    void modificarPressed(ActionEvent event) {
        Alert a = new Alert(AlertType.NONE);
        try {
            String rol = cbRol.getSelectionModel().getSelectedItem();
            int rut = Integer.parseInt(entryRut.getText());
            Personal trabajador = Personal.getTrabajador(rut);
            trabajador.setNombre(entryNombre.getText());
            trabajador.setApellido(entryApellido.getText());
            if (rol.equals("Veterinaria")) {
                ((Veterinaria)trabajador).setTitulo(entryTitulo.getText());
                ((Veterinaria)trabajador).setEspecialidad(entryEspecialidad.getText());
            }else{
                ((Auxiliar)trabajador).setDestrezaTecnica(entryDestreza.getText());;
            }
            a.setAlertType(AlertType.INFORMATION);
            a.setContentText("Modificado con exito");
            a.show();
        } catch (Exception e) {
            a.setAlertType(AlertType.ERROR);
            a.setContentText("Ingrese los datos correctamente");
            a.show();
        }
    }

    @FXML
    void volverPressed(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Ventanas/GestionarPersonal.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Menu Principal");
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
    }

}
