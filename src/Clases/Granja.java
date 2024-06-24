package Clases;

public class Granja extends Animal{
    private int codigo;

    public Granja(TipoAnimal tipo, int edad, int codigo) {
        super(tipo, edad);
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
}
