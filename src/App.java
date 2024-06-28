
import Clases.Animales.TipoAnimal;
import Clases.Animales.Domesticos.Ave;
import Clases.Animales.Domesticos.Gato;
import Clases.Animales.Domesticos.Perro;
import Clases.Personal.Auxiliar;
import Clases.Personal.Veterinaria;
import Persona.Ficha;
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
        

        new Perro(TipoAnimal.DOMESTICO,123,"","pitbul");
        new Gato(TipoAnimal.DOMESTICO,123,"","epico");
        new Ave(TipoAnimal.DOMESTICO,123,"etc");
        new Ficha();
        new Veterinaria(1, "fabian", "quezada", "pixula loca", "paja");
        new Auxiliar(2, "joshua", "jara klein", "pajear sin las manos");
        

        
        
    }

 
    public static void main(String[] args) {
        launch(args);
    }
}