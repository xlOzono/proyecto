package Clases.Animales.Domesticos;

import Clases.Animales.Animal;
import Clases.Animales.TipoAnimal;

public class Domestico extends Animal{
    private String nombre;

    public Domestico(TipoAnimal tipo, int edad, String nombre) {
        super(tipo, edad);
        this.nombre = nombre;
    }

    public static boolean containsName(String nombre) {
        for(Animal animal: Animal.animales){
            if(animal instanceof Domestico && ((Domestico)animal).getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }
    public static Domestico getDomestico(String nombre) {
        for(Animal animal: Animal.animales){
            if(animal instanceof Domestico && ((Domestico)animal).getNombre().equals(nombre)){
                return (Domestico) animal;
            }
        }
        return null;
    }

    public String getTipoDomestico() {
        if (this instanceof Perro) {
            return "Perro";
        }else if (this instanceof Gato) {
            return "Gato";
        }else if (this instanceof Ave) {
            return "Ave";
        }
        return null;
    }

    public String getRaza() {
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}
