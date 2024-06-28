
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Clases.Animales.Animal;
import Clases.Animales.TipoAnimal;
import Clases.Animales.Domesticos.Ave;
import Clases.Animales.Domesticos.Domestico;
import Clases.Animales.Domesticos.Gato;
import Clases.Animales.Domesticos.Perro;
import Clases.Ficha.Ficha;
import Persona.Fisica;
import Persona.Juridica;
import Persona.Persona;
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

public class ContIngresarDomestico {
    @FXML
    private Button btAceptarMascota;

    @FXML
    private Button btVolver;

    @FXML
    private ComboBox<String> cbTipo;

    @FXML
    private ComboBox<String> cbTipoPersona;

    @FXML
    private TextField entryApellido;

    @FXML
    private TextField entryDireccion;

    @FXML
    private TextField entryEdad;

    @FXML
    private TextField entryEmail;

    @FXML
    private TextField entryNombre;

    @FXML
    private TextField entryNombreAnimal;

    @FXML
    private TextField entryRUT;

    @FXML
    private TextField entryRaza;

    @FXML
    private TextField entryRazonSocial;

    @FXML
    private TextField entryRolTrib;

    @FXML
    private TextField entryTelefono;

    @FXML
    private Label lbApellido;

    @FXML
    private Label lbNombre;

    @FXML
    private Label lbRaza;

    @FXML
    private Label lbRazonSocial;

    @FXML
    private Label lbRolTrib;

    @FXML
    private Label lbRut;

    public void initCombos() {
        List<String> list = new ArrayList<String>();
        list.add("Perro");
        list.add("Gato");
        list.add("Ave");
        ObservableList<String> obList = FXCollections.observableList(list);
        cbTipo.setItems(obList);
        cbTipo.getSelectionModel().selectFirst();

        list = new ArrayList<String>();
        list.add("Juridica");
        list.add("Fisica");
        obList = FXCollections.observableList(list);
        cbTipoPersona.setItems(obList);
        
    }

    @FXML
    void initialize() {
        assert cbTipo != null : "fx:id=\"cbTipo\" was not injected: check your FXML file 'IngresarDomestico.fxml'.";
        assert entryNombreAnimal != null : "fx:id=\"entryNombreAnimal\" was not injected: check your FXML file 'IngresarDomestico.fxml'.";
        initCombos();
    }
    @FXML
    void cbTipoPressed(ActionEvent event) {
        if (cbTipo.getSelectionModel().getSelectedItem().equals("Ave")) {
            entryRaza.setDisable(true);
            lbRaza.setStyle("-fx-text-fill: grey");
        }
        else{
            entryRaza.setDisable(false);
            lbRaza.setStyle("-fx-text-fill: black");
        }
    }

    @FXML
    void aceptarMascotaPressed(ActionEvent event) {
        Alert a = new Alert(AlertType.NONE);
        try {
            if (Domestico.containsName(entryNombreAnimal.getText())) {
                a.setAlertType(AlertType.ERROR);
                a.setContentText("La mascota ya existe");
                a.show();
            }else{
                String tipo =cbTipo.getSelectionModel().getSelectedItem();
                Animal mascota;
                Persona propietario;
                Ficha ficha = new Ficha();
                switch (tipo) {
                    case "Perro":
                        mascota = new Perro(TipoAnimal.DOMESTICO, Integer.parseInt(entryEdad.getText()), entryNombreAnimal.getText(),entryRaza.getText());
                        ficha.setMascota(mascota);
                        a.setAlertType(AlertType.INFORMATION);
                        a.setContentText("Creado con exito");
                        a.show();
                        break;
                    case "Gato":
                        mascota = new Gato(TipoAnimal.DOMESTICO, Integer.parseInt(entryEdad.getText()), entryNombreAnimal.getText(),entryRaza.getText());
                        ficha.setMascota(mascota);
                        break;
                    
                    case "Ave":
                        mascota = new Ave(TipoAnimal.DOMESTICO, Integer.parseInt(entryEdad.getText()), entryNombreAnimal.getText());
                        ficha.setMascota(mascota);
                        break;
                }
                if (cbTipoPersona.getSelectionModel().getSelectedItem().equals("Fisica")) {
                    propietario = new Fisica(entryEmail.getText(), Integer.parseInt(entryTelefono.getText()), entryDireccion.getText(), entryNombre.getText(), entryApellido.getText(), Integer.parseInt(entryRUT.getText()));
                }else{
                    propietario = new Juridica(entryEmail.getText(), Integer.parseInt(entryTelefono.getText()), entryDireccion.getText(), entryRolTrib.getText(), Integer.parseInt(entryRolTrib.getText()));
                }
                ficha.setPropietario(propietario);
                a.setAlertType(AlertType.INFORMATION);
                a.setContentText("Numero de ficha: "  + ficha.getNumFicha());
                a.show();
            }
            
        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Ingrese los datos correctamente");
            a.show();
            System.out.println(e);
        }
    }

    @FXML
    void volverPressed(ActionEvent event) {
        Parent root;       
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Ventanas/IngresarNombre.fxml"));
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

    @FXML
    void cbTipoPersonaPressed(ActionEvent event) {
        if (cbTipoPersona.getSelectionModel().getSelectedItem().equals("Fisica")) {
            entryRazonSocial.setDisable(true);
            entryRolTrib.setDisable(true);
            
            lbRazonSocial.setStyle("-fx-text-fill: grey");
            lbRolTrib.setStyle("-fx-text-fill: grey");

            entryNombre.setDisable(false);
            entryApellido.setDisable(false);
            entryRUT.setDisable(false);

            lbNombre.setStyle("-fx-text-fill: black");
            lbApellido.setStyle("-fx-text-fill: black");
            lbRut.setStyle("-fx-text-fill: black");
        }
        else{
            entryRazonSocial.setDisable(false);
            entryRolTrib.setDisable(false);
            
            lbRazonSocial.setStyle("-fx-text-fill: black");
            lbRolTrib.setStyle("-fx-text-fill: black");

            entryNombre.setDisable(true);
            entryApellido.setDisable(true);
            entryRUT.setDisable(true);

            lbNombre.setStyle("-fx-text-fill: grey");
            lbApellido.setStyle("-fx-text-fill: grey");
            lbRut.setStyle("-fx-text-fill: grey");
        }
    }
}
