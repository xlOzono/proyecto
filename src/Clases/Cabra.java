package Clases;

public class Cabra extends Granja{
    private String raza;

    public Cabra(TipoAnimal tipo, int edad, int codigo, String raza) {
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
