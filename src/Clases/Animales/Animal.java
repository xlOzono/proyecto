package Clases.Animales;
import java.util.ArrayList;

public class Animal {
    private TipoAnimal tipo;
    private int edad;
    public static ArrayList<Animal> animales = new ArrayList<Animal>();
    
    public Animal(TipoAnimal tipo, int edad) {
        this.tipo = tipo;
        this.edad = edad;
        animales.add(this);

    }
    public static ArrayList<Animal> getArrayList(){
        return animales;
    }
    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
