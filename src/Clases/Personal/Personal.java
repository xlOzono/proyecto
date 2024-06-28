package Clases.Personal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Personal {
    private int rut;
    private String nombre;
    private String apellido;
    private String fechaContratacion;
    public static ArrayList<Personal> personal = new ArrayList<>();
    
    public Personal(int rut, String nombre, String apellido) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        SimpleDateFormat fecha = new SimpleDateFormat();
        String fechaComoCadena = fecha.format(new Date());
        this.fechaContratacion = fechaComoCadena;
        personal.add(this);
    }

    public static Personal getTrabajador(int rut) {
        for(Personal trabajador: personal){
            if (trabajador.getRut() == rut) {
                return trabajador;
            }
        }
        return null;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
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

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public static ArrayList<Personal> getPersonal() {
        return personal;
    }

    public static void setPersonal(ArrayList<Personal> personal) {
        Personal.personal = personal;
    }

    
}
