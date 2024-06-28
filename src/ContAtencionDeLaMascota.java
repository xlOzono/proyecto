import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javax.swing.JOptionPane;

import Clases.Diagnostico;
import Clases.ElementoFicha;
import Clases.Personal.Auxiliar;
import Clases.Personal.Personal;
import Clases.Personal.Veterinaria;
import Persona.Ficha;
import Persona.Persona;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ContAtencionDeLaMascota {
    private Ficha fichaid;
    private Personal veterinaria;
    private Personal auxiliar;
    
    
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

    public void mostrarFicha(Ficha Ficha,Personal personal,Personal personal2){
        fichaid = Ficha;
        veterinaria = personal;
        auxiliar = personal2;

        AreaTextoFichaTecnica.appendText("\nFicha Numero: "+fichaid.getNumFicha());
        AreaTextoFichaTecnica.appendText("\n~~~~~~~~~~~~~~~~~~~~~~");
        if (fichaid.getConjElementos().size() == 0) {
            
            AreaTextoFichaTecnica.appendText("\nNo se ha registrado ningún elemento ficha" );

        }else{
            /*Se crea un for que recorre el ArrayList del elementoFicha puesto como atributo ConjElementos
             * elementoFicha es la variable que toma el valor del objeto ElementoFicha por lo cual 
             * se le pueden aplicar los distintos métodos correspondientes a ese objeto como es de
             * Obtener Fecha .getFecha
             * Obtener Tratamiento .getTratamiento
             * Obtener el objeto Veterinaria para luego aplicar sus métodos que es el de obtener nombre .getNombre
             */
            try {
                for(ElementoFicha elementoFicha: fichaid.getConjElementos()){
                    AreaTextoFichaTecnica.appendText("\nElemento de la ficha\n");
                    /*Imprimir información de la veterinaria llamando al atributo correspondiente de cada elemento 
                      que existe en el arraylist ConjElementos*/
                    AreaTextoFichaTecnica.appendText("\nVeterinaria: \n"+"Nombre: "+elementoFicha.getVeterinaria().getNombre()
                    +" "+elementoFicha.getVeterinaria().getApellido()
                    +"\nRut: "+elementoFicha.getVeterinaria().getRut()
                    +"\nEspecialidad: "+elementoFicha.getVeterinaria().getEspecialidad());
                    if (elementoFicha.getAuxiliar() != null) {
                        AreaTextoFichaTecnica.appendText("\n\nAuxiliar: \n"+"Nombre: "+elementoFicha.getAuxiliar().getNombre()
                    +" "+elementoFicha.getAuxiliar().getApellido()
                    +"\nRut: "+elementoFicha.getAuxiliar().getRut()
                    +"\nDestreza: "+elementoFicha.getAuxiliar().getDestrezaTecnica());      
                    }                           
                    AreaTextoFichaTecnica.appendText("\nFecha: "+elementoFicha.getFecha() +"\n");
                    AreaTextoFichaTecnica.appendText("\nDiagnostico: \n"+elementoFicha.getDiagnostico().getDescripcion());
                    AreaTextoFichaTecnica.appendText("\nTratamiento: \n\n"+elementoFicha.getTratamiento() );
                    AreaTextoFichaTecnica.appendText("\n~~~~~~~~~~~~~~~~~~~~~~");
                }
            } catch (Exception e) {
                
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
        try {
            ElementoFicha elemento = new ElementoFicha(fechaComoCadena, diagnostico, "Insumos para el animal\n:"+AreaTextoInsumos.getText()+"\nIndicaciones\n:"+AreaTextoIndicaciones.getText());
            fichaid.getConjElementos().add(elemento);
            elemento.setVeterinaria((Veterinaria)veterinaria);
            if (auxiliar != null) {elemento.setAuxiliar((Auxiliar) auxiliar);}
            else{elemento.setAuxiliar(null);}
            AreaTextoFichaTecnica.setText("");
            mostrarFicha(fichaid,veterinaria,auxiliar);
            Alert a = new Alert(AlertType.NONE);
            a.setAlertType(AlertType.CONFIRMATION);
            a.setContentText("Elemento de ficha creado exitosamente");
            a.show();
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = (AnchorPane)loader.load(getClass().getResource("\\Ventanas\\CobrarLaAtencion.fxml").openStream());
            ContCobrarLaAtención ContAtencionDeLaMascotainstancia = (ContCobrarLaAtención)loader.getController();
            ContAtencionDeLaMascotainstancia.mostrarFicha(fichaid);
            Stage stage = new Stage();
            stage.setTitle("Ventana Atención");
            stage.setScene(new Scene(root, 1029, 536));
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
   

        } catch (Exception e) {
            System.out.println(e);
                Alert a = new Alert(AlertType.NONE);
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Ingrese los datos correctamente");
                a.show(); 
        }
     

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
            root = FXMLLoader.load(getClass().getClassLoader().getResource("\\Ventanas\\AtencionDeLaMascotaIngresoDeIDficha.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Ingresar Mascota");
            stage.setScene(new Scene(root, 372, 338));
            stage.setResizable(false);
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
        AreaTextoFichaTecnica.setEditable(false);
        AreaTextoElementoFicha.setEditable(false);
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
