
import javax.tools.Diagnostic;

import Clases.Diagnostico;
import Clases.Animales.Animal;
import Clases.Animales.TipoAnimal;
import Clases.Animales.Domesticos.Ave;
import Clases.Animales.Domesticos.Gato;
import Clases.Animales.Domesticos.Perro;
import Clases.Ficha.ElementoFicha;
import Clases.Ficha.Ficha;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Ventanas/PantallaPrincipal.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        

        new Perro(TipoAnimal.DOMESTICO,123,"pene","Pro");
        new Gato(TipoAnimal.DOMESTICO,123,"pene","Pro");
        new Ave(TipoAnimal.DOMESTICO,123,"pene");
        new Ficha(1);

        
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}