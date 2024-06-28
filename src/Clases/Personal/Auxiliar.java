package Clases.Personal;

public class Auxiliar extends Personal {
    private String destrezaTecnica;

    public Auxiliar(int rut, String nombre, String apellido, String destrezaTecnica) {
        super(rut, nombre, apellido);
        this.destrezaTecnica = destrezaTecnica;
    }

    public String getDestrezaTecnica() {
        return destrezaTecnica;
    }

    public void setDestrezaTecnica(String destrezaTecnica) {
        this.destrezaTecnica = destrezaTecnica;
    }

    
}
