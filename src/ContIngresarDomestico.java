
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ContIngresarDomestico {

    @FXML
    private ComboBox<String> cbTipo;

    @FXML
    private TextField entryEdad;

    @FXML
    private TextField entryNombreAnimal;

    @FXML
    private TextField entryRaza;

    public void initCombos() {
        List<String> list = new ArrayList<String>();
        list.add("Caballo");
        list.add("Cabra");
        list.add("Vaca");
        ObservableList<String> obList = FXCollections.observableList(list);
        cbTipo.getItems().clear();
        cbTipo.getItems().addAll(obList);
        cbTipo.setItems(obList);
    }

    @FXML
    void initialize() {
        assert cbTipo != null : "fx:id=\"cbTipo\" was not injected: check your FXML file 'IngresarDomestico.fxml'.";
        assert entryNombreAnimal != null : "fx:id=\"entryNombreAnimal\" was not injected: check your FXML file 'IngresarDomestico.fxml'.";
        initCombos();
    }
}
