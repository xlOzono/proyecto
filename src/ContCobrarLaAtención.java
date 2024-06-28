import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class ContCobrarLaAtención {
    @FXML
    private ResourceBundle resources;

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
    private ComboBox<String> ComboBoxBoletaFactura;

    @FXML
    private Label MedioFacturacion;

    @FXML
    private Button btGuardar;

    @FXML
    private Button btVolver;

    public void ImprimirTexto(){

        /* Se definen las variables correspondiente con la información de texto extraídas de las áreas de texto con el método .get
         * para el ComboBox se obtiene la selección de tipo String mediante 2 métodos .getSelectionModel que te ubica en las selección 
         * y luego .getSelectedItem que selecciona el item en el que se encuentra el ComboBox*/
        String ComboBox = ComboBoxBoletaFactura.getSelectionModel().getSelectedItem();
        String atInsumos  = AreaTextoInsumos.getText();
        String atRemedios = AreaTextoRemedios.getText();
        String atProcedimientos = AreaTextoProcedimientos.getText();
        String atConsulta = AreaTextoConsulta.getText();
        System.out.println(AreaTextoInsumos.getText());

        /*Al ejecutarse por primera vez los valores de las áreas se encuentran vacíos por lo que las variables se rellenan
          con un 0 */
        if (AreaTextoInsumos.getText() == "") {atInsumos = "0";}
        if (AreaTextoRemedios.getText() == "") {atRemedios = "0";}
        if (AreaTextoProcedimientos.getText() =="") {atProcedimientos = "0";}
        if (AreaTextoConsulta.getText() == "") {atConsulta = "0";}
        if (ComboBoxBoletaFactura.getSelectionModel().getSelectedItem() == null) {ComboBox = "No se ha definido medio de facturación";}

        /* Se Agregan al area de texto los valores correspondientes a cada caja de texto mediante el método .appendText*/
        AreaTextoCostos.setText("");
        AreaTextoCostos.appendText("\n"+ComboBox+"\n");
        AreaTextoCostos.appendText("\nValor Insumos : " + atInsumos+"$");
        AreaTextoCostos.appendText("\nValor remedios: " + atRemedios+"$");
        AreaTextoCostos.appendText("\nValor procedimiento: " + atProcedimientos+"$");
        AreaTextoCostos.appendText("\nValor consulta: " + atConsulta+"$");
        

        
    }

    @FXML
    void OnActionComboBoxBoletaFactura(ActionEvent event) {
        MedioFacturacion.setText(ComboBoxBoletaFactura.getSelectionModel().getSelectedItem());
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
    void keyTypedInsumos(KeyEvent event) {

    }

    @FXML
    void volverPressed(ActionEvent event) {

    }

    @FXML
    void GuardarPressed(ActionEvent event) {

    }


    @FXML
    void initialize() {
        ImprimirTexto();
        ComboBoxBoletaFactura.getItems().setAll("Boleta","Factura");
        assert AreaTextoConsulta != null : "fx:id=\"AreaTextoConsulta\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert AreaTextoCostos != null : "fx:id=\"AreaTextoCostos\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert AreaTextoFichaTecnica != null : "fx:id=\"AreaTextoFichaTecnica\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert AreaTextoInsumos != null : "fx:id=\"AreaTextoInsumos\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert AreaTextoProcedimientos != null : "fx:id=\"AreaTextoProcedimientos\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert AreaTextoRemedios != null : "fx:id=\"AreaTextoRemedios\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert ComboBoxBoletaFactura != null : "fx:id=\"ComboBoxBoletaFactura\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert MedioFacturacion != null : "fx:id=\"MedioFacturacion\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert btGuardar != null : "fx:id=\"btGuardar\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";
        assert btVolver != null : "fx:id=\"btVolver\" was not injected: check your FXML file 'AtencionDeLaMascota.fxml'.";

    }

}

