package Clases;

public class Fisica extends Persona {
    private String nombre;
    private String apellido;
    private int rut;

    public Fisica(String email, int telefono, String direccion, String nombre, String apellido, int rut) {
        super(email, telefono, direccion);
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }
    


}
