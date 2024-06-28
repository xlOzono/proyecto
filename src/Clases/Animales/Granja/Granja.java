package Clases.Animales.Granja;

import Clases.Animales.Animal;
import Clases.Animales.TipoAnimal;

public class Granja extends Animal{
    private int codigo;

    public Granja(TipoAnimal tipo, int edad, int codigo) {
        super(tipo, edad);
        this.codigo = codigo;
    }

    public static boolean containsCodigo(int codigo) {
        for(Animal animal: Animal.animales){
            if(animal instanceof Granja && ((Granja)animal).getCodigo() == codigo){
                return true;
            }
        }
        return false;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public static Granja getGranja(int codigo) {
        for(Animal animal: Animal.animales){
            if(animal instanceof Granja && ((Granja)animal).getCodigo() == codigo){
                return (Granja) animal;
            }
        }
        return null;
    }

    
}
