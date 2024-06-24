package Clases.Animales.Domesticos;

import Clases.Animales.TipoAnimal;

public class Gato extends Domestico{
    private String raza;

    public Gato(TipoAnimal tipo, int edad, String nombre, String raza) {
        super(tipo, edad, nombre);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    
    
}
