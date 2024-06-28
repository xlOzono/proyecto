import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Clases.Personal.Personal;
import Clases.Personal.Veterinaria;
import Clases.Personal.Auxiliar;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ContEliminarPersonal {

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
            }else {
                cbRol.getSelectionModel().select(1);
                entryDestreza.setText(((Auxiliar)trabajador).getDestrezaTecnica());
            }

        } catch (Exception e) {
            a.setAlertType(AlertType.ERROR);
            a.setContentText("El RUT no existe o no es valido");
            a.show();
        }
    }

    @FXML
    void eliminarPressed(ActionEvent event) {
        Alert a = new Alert(AlertType.NONE);
        try {
            int rut = Integer.parseInt(entryRut.getText());
            Personal trabajador = Personal.getTrabajador(rut);
            Personal.personal.remove(trabajador);  
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
