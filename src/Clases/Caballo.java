package Clases;

public class Caballo extends Granja{
    private String raza;

    public Caballo(TipoAnimal tipo, int edad, int codigo, String raza) {
        super(tipo, edad, codigo);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    
}
