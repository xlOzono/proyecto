package Clases.Animales;

import java.util.ArrayList;

public class Animal {
    public static ArrayList<Animal> animales = new ArrayList<>();
    private TipoAnimal tipo;
    private int edad;
    
    public Animal(TipoAnimal tipo, int edad) {
        this.tipo = tipo;
        this.edad = edad;
        animales.add(this);
        System.out.println(animales);
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
