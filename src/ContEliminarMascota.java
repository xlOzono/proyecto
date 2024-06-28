import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Clases.Fisica;
import Clases.Juridica;
import Clases.Persona;
import Clases.Animales.Animal;
import Clases.Animales.Domesticos.Domestico;
import Clases.Animales.Granja.Granja;
import Clases.Ficha.Ficha;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ContEliminarMascota {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btBuscar;

    @FXML
    private Button btEliminarMascota;

    @FXML
    private Button btVolver;

    @FXML
    private ComboBox<String> cbTipoMascota;

    @FXML
    private TextField entryApellido;

    @FXML
    private TextField entryCodigoAnimal;

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
    private TextField entryTipoAnimal;

    @FXML
    private TextField entryTipoPersona;

    @FXML
    private Label lbApellido;

    @FXML
    private Label lbCodigoMascota;

    @FXML
    private Label lbNombre;

    @FXML
    private Label lbNombreMascota;

    @FXML
    private Label lbRaza;

    @FXML
    private Label lbRazonSocial;

    @FXML
    private Label lbRolTrib;

    @FXML
    private Label lbRut;

    @FXML
    void buscarMascotaPressed(ActionEvent event) {
        Alert a = new Alert(AlertType.NONE);
        try {
            Ficha ficha;
            Persona propietario;
            if (cbTipoMascota.getSelectionModel().getSelectedItem().equals("Domestico")) {
                String nombreAnimal = entryNombreAnimal.getText();
                Domestico mascota = Domestico.getDomestico(nombreAnimal);
                ficha = Ficha.getFicha(mascota);
                propietario = ficha.getPropietario();
                String tipoDomestico = mascota.getTipoDomestico();

                entryTipoAnimal.setText(tipoDomestico);
                entryEdad.setText(""+mascota.getEdad());
                entryRaza.setText(mascota.getRaza());

            }else{
                int codigoAnimal = Integer.parseInt(entryCodigoAnimal.getText());
                Granja mascota = Granja.getGranja(codigoAnimal);
                ficha = Ficha.getFicha(mascota);
                propietario = ficha.getPropietario();
                String tipoGranja = mascota.getTipoGranja();
                entryTipoAnimal.setText(tipoGranja);
                entryEdad.setText(""+mascota.getEdad());
                entryRaza.setText(mascota.getRaza());
            }
            entryEmail.setText(propietario.getEmail());
            entryTelefono.setText(""+propietario.getTelefono());
            entryDireccion.setText(propietario.getDireccion());

            if (propietario instanceof Fisica) {
                entryTipoPersona.setText("Fisica");
                entryNombre.setText(((Fisica)propietario).getNombre());
                entryApellido.setText(((Fisica)propietario).getApellido());
                entryRUT.setText(""+((Fisica)propietario).getRut());
            }else{
                entryTipoPersona.setText("Juridica");
                entryRazonSocial.setText(((Juridica)propietario).getRazonSocial());
                entryRolTrib.setText(""+((Juridica)propietario).getRolTributario());
            }
            
        }catch (Exception e) {
            a.setAlertType(AlertType.ERROR);
            a.setContentText("Ingrese los datos correctamente");
            a.show();
        }
    }

    @FXML
    void eliminarMascotaPressed(ActionEvent event) {
        Alert a = new Alert(AlertType.NONE);
        try {
            if (cbTipoMascota.getSelectionModel().getSelectedItem().equals("Domestico")) {
                String nombreAnimal = entryNombreAnimal.getText();
                Domestico mascota = Domestico.getDomestico(nombreAnimal);
                Animal.animales.remove(mascota);
            }else{
                int codigoAnimal = Integer.parseInt(entryCodigoAnimal.getText());
                Granja mascota = Granja.getGranja(codigoAnimal);
                Animal.animales.remove(mascota);
            }
            a.setAlertType(AlertType.INFORMATION);
            a.setContentText("Eliminado con exito");
            a.show();
        }catch (Exception e) {
            a.setAlertType(AlertType.ERROR);
            a.setContentText("Ingrese los datos correctamente");
            a.show();
        }
    }

    @FXML
    void tipoMascotaPressed(){
        if (cbTipoMascota.getSelectionModel().getSelectedItem().equals("Domestico")) {
            lbNombreMascota.setStyle("-fx-text-fill: black");
            entryNombreAnimal.setDisable(false);
            lbCodigoMascota.setStyle("-fx-text-fill: grey");
            entryCodigoAnimal.setDisable(true);
        }else{
            lbNombreMascota.setStyle("-fx-text-fill: grey");
            entryNombreAnimal.setDisable(true);
            lbCodigoMascota.setStyle("-fx-text-fill: black");
            entryCodigoAnimal.setDisable(false);
        }
    }

    @FXML
    void volverPressed(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Ventanas\\PantallaPrincipal.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Menu Principal");
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

    @FXML
    void initialize() {
        List<String> list = new ArrayList<String>();
        list.add("Domestico");
        list.add("Granja");
        ObservableList<String> obList = FXCollections.observableList(list);
        cbTipoMascota.setItems(obList);
    }

}
