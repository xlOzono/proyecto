import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.*;
import Clases.ElementoFicha;
import Clases.Ficha.ElementoFactura;
import Clases.Ficha.Factura;
import Clases.Personal.Personal;
import Persona.Ficha;
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
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ContCobrarLaAtención {
    private Ficha fichaid;
    @FXML
    private ResourceBundle resources;

    @FXML
    private TextArea AreaTextoCantidadInsumos;


    @FXML
    private TextArea AreaTextoCantidadProcedimientos;

    @FXML
    private TextArea AreaTextoCantidadRemedios;

    @FXML
    private URL location;

    @FXML
    private TextArea AreaTextoConsulta;

    @FXML
    private TextArea AreaTextoCostos;

    @FXML
    private TextArea AreaTextoFichaTecnica;

    @FXML
    private TextArea AreaTextoInsumos;

    @FXML
    private TextArea AreaTextoProcedimientos;

    @FXML
    private TextArea AreaTextoRemedios;

    @FXML
    private TextArea AreaTextoIdCliente;

    @FXML
    private Label MedioFacturacion;

    @FXML
    private Button btGuardar;

    @FXML
    private Button btVolver;
    
    
    private boolean validadNumeros(String contenidoAreaTexto){
        return contenidoAreaTexto.matches("[0-9]+");
    }
    public void mostrarFicha(Ficha Ficha){
        fichaid = Ficha;

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

    public void ImprimirTexto(){

        /* Se definen las variables correspondiente con la información de texto extraídas de las áreas de texto con el método .get
         * para el ComboBox se obtiene la selección de tipo String mediante 2 métodos .getSelectionModel que te ubica en las selección 
         * y luego .getSelectedItem que selecciona el item en el que se encuentra el ComboBox*/
        
        String atInsumos  = AreaTextoInsumos.getText();
        String atRemedios = AreaTextoRemedios.getText();
        String atProcedimientos = AreaTextoProcedimientos.getText();
        String atConsulta = AreaTextoConsulta.getText();

        /*Al ejecutarse por primera vez los valores de las áreas se encuentran vacíos por lo que las variables se rellenan
          con un 0 */
        if (AreaTextoInsumos.getText() == "") {atInsumos = "0";}
        if (AreaTextoRemedios.getText() == "") {atRemedios = "0";}
        if (AreaTextoProcedimientos.getText() =="") {atProcedimientos = "0";}
        if (AreaTextoConsulta.getText() == "") {atConsulta = "0";}
        

        /* Se Agregan al area de texto los valores correspondientes a cada caja de texto mediante el método .appendText*/
        AreaTextoCostos.setText("");
        AreaTextoCostos.appendText("~~~~~~~~~~~~~~~~~~~~~~");
        AreaTextoCostos.appendText("\nInsumos");
        AreaTextoCostos.appendText("\nCantidad: "+AreaTextoCantidadInsumos.getText());
        AreaTextoCostos.appendText("\nValor insumos : " + atInsumos+"$");
        AreaTextoCostos.appendText("\n~~~~~~~~~~~~~~~~~~~~~~");
        AreaTextoCostos.appendText("\nRemedios");
        AreaTextoCostos.appendText("\nCantidad: "+AreaTextoCantidadRemedios.getText());
        AreaTextoCostos.appendText("\nValor remedios: " + atRemedios+"$");
        AreaTextoCostos.appendText("\n~~~~~~~~~~~~~~~~~~~~~~");
        AreaTextoCostos.appendText("\nConsulta");;
        AreaTextoCostos.appendText("\nCantidad: "+AreaTextoCantidadProcedimientos.getText());
        AreaTextoCostos.appendText("\nValor procedimiento: " + atProcedimientos+"$");
        AreaTextoCostos.appendText("\n~~~~~~~~~~~~~~~~~~~~~~");
        AreaTextoCostos.appendText("\nValor consulta: " + atConsulta+"$");
        AreaTextoCostos.appendText("\n~~~~~~~~~~~~~~~~~~~~~~");
        AreaTextoCostos.appendText("\nidCliente: " + AreaTextoIdCliente.getText());
        AreaTextoCostos.appendText("\n~~~~~~~~~~~~~~~~~~~~~~");
        AreaTextoCostos.appendText("\nidEmpresa: 00001");
                

        
    }


    @FXML
    void OnKeyPressedAreaTextoConsulta(KeyEvent event) {
        ImprimirTexto();
    }

    @FXML
    void OnKeyPressedAreaTextoInsumos(KeyEvent event) {
        ImprimirTexto();
    }

    @FXML
    void OnKeyPressedAreaTextoProcedimientos(KeyEvent event) {
        ImprimirTexto();
    }

    @FXML
    void OnKeyPressedAreaTextoRemedios(KeyEvent event) {
        ImprimirTexto();
    }
    @FXML
    void OnKeyPressedCantidadInsumos(KeyEvent event) {
        ImprimirTexto();
    }

    @FXML
    void OnKeyPressedCantidadProcedimientos(KeyEvent event) {
        ImprimirTexto();
    }

    @FXML
    void OnKeyPressedCantidadRemedios(KeyEvent event) {
        ImprimirTexto();
    }
    @FXML
    void KeyTypedAreaTextoIdCliente(KeyEvent event) {
        ImprimirTexto();
    }

    @FXML
    void GuardarPressed(ActionEvent event) {
        try {
            if (validadNumeros(AreaTextoIdCliente.getText().trim())
                && validadNumeros(AreaTextoCantidadInsumos.getText().trim()) 
                && validadNumeros(AreaTextoCantidadRemedios.getText().trim()) 
                && validadNumeros(AreaTextoCantidadProcedimientos.getText().trim())
                && validadNumeros(AreaTextoInsumos.getText().trim())
                && validadNumeros(AreaTextoRemedios.getText().trim())
                && validadNumeros(AreaTextoProcedimientos.getText().trim()) 
                && validadNumeros(AreaTextoConsulta.getText().trim())){
                Factura factura = new Factura(Integer.parseInt(AreaTextoIdCliente.getText()), 00001);
                ElementoFactura insumos = new ElementoFactura("insumos", Integer.parseInt(AreaTextoIdCliente.getText()), 
                Integer.parseInt(AreaTextoInsumos.getText()));
                ElementoFactura remedios =new ElementoFactura("remedios", Integer.parseInt(AreaTextoCantidadRemedios.getText()), 
                Integer.parseInt(AreaTextoRemedios.getText()));
                ElementoFactura procedimientos =new ElementoFactura("procedimientos", Integer.parseInt(AreaTextoCantidadProcedimientos.getText()), 
                Integer.parseInt(AreaTextoProcedimientos.getText()));
                factura.getElementoFacturas().add(insumos);
                factura.getElementoFacturas().add(remedios);
                factura.getElementoFacturas().add(procedimientos);
                Alert a = new Alert(AlertType.NONE);
                a.setAlertType(AlertType.CONFIRMATION);
                a.setContentText("Datos Guardados correctamente");
                a.show();

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
                else{
                    Alert a = new Alert(AlertType.NONE);
                    a.setAlertType(AlertType.WARNING);
                    a.setContentText("Ingrese Números");
                    a.show(); 
                } 
        } catch (Exception e) {
                Alert a = new Alert(AlertType.NONE);
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Ingrese los datos correctamente");
                a.show(); 
        }
        
    }

    @FXML
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
        AreaTextoFichaTecnica.setEditable(false);
        AreaTextoCostos.setEditable(false);
        ImprimirTexto();
        assert AreaTextoConsulta != null : "fx:id=\"AreaTextoConsulta\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert AreaTextoCostos != null : "fx:id=\"AreaTextoCostos\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert AreaTextoFichaTecnica != null : "fx:id=\"AreaTextoFichaTecnica\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert AreaTextoInsumos != null : "fx:id=\"AreaTextoInsumos\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert AreaTextoProcedimientos != null : "fx:id=\"AreaTextoProcedimientos\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert AreaTextoRemedios != null : "fx:id=\"AreaTextoRemedios\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert MedioFacturacion != null : "fx:id=\"MedioFacturacion\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert btGuardar != null : "fx:id=\"btGuardar\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert btVolver != null : "fx:id=\"btVolver\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";

    }

}

