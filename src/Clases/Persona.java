package Clases;

import java.util.ArrayList;

public class Persona {
    private String email;
    private int telefono;
    private String direccion;
    public static ArrayList<Persona> propietarios = new ArrayList<>();
    
    public Persona(String email, int telefono, String direccion) {
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
}
