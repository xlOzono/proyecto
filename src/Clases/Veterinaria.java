package Clases;


public class Veterinaria extends Personal {
    private String titulo;
    private String especialidad;
    public Veterinaria(int rut, String nombre, String apellido, String titulo, String especialidad) {
        super(rut, nombre, apellido);
        this.titulo = titulo;
        this.especialidad = especialidad;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
    
}