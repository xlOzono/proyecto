package Clases.Animales.Domesticos;

import Clases.Animales.TipoAnimal;

public class Perro extends Domestico{
    private String raza;

    public Perro(TipoAnimal tipo, int edad, String nombre, String raza) {
        super(tipo, edad, nombre);
        this.raza = raza;
    }
    
    @Override
    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    
    
}
