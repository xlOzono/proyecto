
import Clases.Animales.TipoAnimal;
import Clases.Animales.Domesticos.Ave;
import Clases.Animales.Domesticos.Gato;
import Clases.Animales.Domesticos.Perro;
import Clases.Ficha.Ficha;
import Clases.Personal.Auxiliar;
import Clases.Personal.Veterinaria;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Ventanas/PantallaPrincipal.fxml"));
        primaryStage.setTitle("Menu Principal");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        

        new Perro(TipoAnimal.DOMESTICO,123,"","pitbul");
        new Gato(TipoAnimal.DOMESTICO,123,"","epico");
        new Ave(TipoAnimal.DOMESTICO,123,"etc");
        new Ficha();
        new Veterinaria(1, "Juan", "Perez", "Medico Veterinario", "Animales exoticos");
        new Auxiliar(2, "Diego", "Martinez", "Esterilización");
        

        
        
    }

 
    public static void main(String[] args) {
        launch(args);
    }
}