package Clases.Animales.Granja;
import Clases.Animales.TipoAnimal;

public class Vaca extends Granja{
    private String raza;

    public Vaca(TipoAnimal tipo, int edad, int codigo, String raza) {
        super(tipo, edad, codigo);
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
