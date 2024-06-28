package Clases.Animales.Domesticos;

import Clases.Animales.TipoAnimal;

public class Ave extends Domestico{
    public Ave(TipoAnimal tipo,int edad,String nombre){
        super(tipo, edad, nombre);
    }
    @Override
    public String getRaza() {
        return "";
    }
}
