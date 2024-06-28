import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javax.swing.JOptionPane;

import Clases.Diagnostico;
import Clases.Ficha.ElementoFicha;
import Clases.Ficha.Ficha;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ContAtencionDeLaMascota {
    private Ficha fichaid;
    
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea AreaTextoElementoFicha;

    @FXML
    private TextArea AreaTextoFichaTecnica;

    @FXML
    private TextArea AreaTextoHipotesis;

    @FXML
    private TextArea AreaTextoIndicaciones;

    @FXML
    private TextArea AreaTextoInsumos;

    @FXML
    private Button btGuardarFicha;

    @FXML
    private Button btVolver;
    public void imprimirTexto(){
        AreaTextoElementoFicha.setText("");
        AreaTextoElementoFicha.appendText("Nuevo Elemento Ficha");
        AreaTextoElementoFicha.appendText("\n");
        AreaTextoElementoFicha.appendText("\nHipotesis: " + AreaTextoHipotesis.getText());
        AreaTextoElementoFicha.appendText("\nInsumos: " + AreaTextoInsumos.getText());
        AreaTextoElementoFicha.appendText("\nIndicaciones: " + AreaTextoIndicaciones.getText());
    }
    public void mostrarFicha(Ficha Ficha){
        fichaid = Ficha;
        AreaTextoFichaTecnica.appendText("──────────────────");
        AreaTextoFichaTecnica.appendText("\n Ficha Numero: "+fichaid.getNumFicha());
        AreaTextoFichaTecnica.appendText("\n──────────────────");
        if (fichaid.getConjElementos().size() == 0) {
            AreaTextoFichaTecnica.appendText("\n No se ha registrado ningún elemento ficha" );
            AreaTextoFichaTecnica.appendText("\n──────────────────");

        }else{
            for(ElementoFicha elementoFicha: fichaid.getConjElementos()){
                AreaTextoFichaTecnica.appendText("\n Fecha: "+elementoFicha.getFecha() );
                AreaTextoFichaTecnica.appendText("\n Diagnostico: "+elementoFicha.getDiagnostico().getDescripcion());
                AreaTextoFichaTecnica.appendText("\n Tratamiento: "+elementoFicha.getTratamiento() );
                
            }
        }
        }
    

    @FXML
    void GuardarFichaPressed(ActionEvent event) {
        
        SimpleDateFormat fecha = new SimpleDateFormat();
        String fechaComoCadena = fecha.format(new Date());

        //Se crea el elemento diagnostico
        Diagnostico diagnostico = new Diagnostico(fechaComoCadena, AreaTextoHipotesis.getText());

        //Se crea el objeto elemento ficha
        ElementoFicha elemento = new ElementoFicha(fechaComoCadena, diagnostico, "Insumos para el animal\n:"+AreaTextoInsumos.getText()+"\nIndicaciones\n:"+AreaTextoIndicaciones.getText());
        fichaid.getConjElementos().add(elemento);
    }

    @FXML
    void KeyTypedHipotesis(KeyEvent event) {
            imprimirTexto();  
    }

    @FXML
    void keyTypedIndicaciones(KeyEvent event) {
            imprimirTexto();
    }
    @FXML
    void keyTypedInsumos(KeyEvent event) {
            imprimirTexto();
    }

    @FXML
    void volverPressed(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Ventanas\\PantallaPrincipal.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Ingresar Mascota");
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
        imprimirTexto();
        assert AreaTextoElementoFicha != null : "fx:id=\"AreaTextoElementoFicha\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert AreaTextoFichaTecnica != null : "fx:id=\"AreaTextoFichaTecnica\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert AreaTextoHipotesis != null : "fx:id=\"AreaTextoHipotesis\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert AreaTextoIndicaciones != null : "fx:id=\"AreaTextoIndicaciones\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert AreaTextoInsumos != null : "fx:id=\"AreaTextoInsumos\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert btGuardarFicha != null : "fx:id=\"btGuardarFicha\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert btVolver != null : "fx:id=\"btVolver\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
         
    }

}
