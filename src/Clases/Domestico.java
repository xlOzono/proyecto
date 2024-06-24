package Clases;

public class Domestico extends Animal{
    private String nombre;

    public Domestico(TipoAnimal tipo, int edad, String nombre) {
        super(tipo, edad);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}
