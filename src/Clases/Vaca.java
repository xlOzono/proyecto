package Clases;

public class Vaca extends Granja{
    private String raza;

    public Vaca(TipoAnimal tipo, int edad, int codigo, String raza) {
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
