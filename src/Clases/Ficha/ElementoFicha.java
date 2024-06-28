package Clases.Ficha;

import Clases.Diagnostico;
import Clases.Personal.Auxiliar;
import Clases.Personal.Veterinaria;

public class ElementoFicha {
    private Veterinaria veterinaria;
    private Auxiliar auxiliar;
    private String fecha;
    private Diagnostico diagnostico;
    private String tratamiento;

    
    public Auxiliar getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(Auxiliar auxiliar) {
        this.auxiliar = auxiliar;
    }

    
    public Veterinaria getVeterinaria() {
        return veterinaria;
    }

    public void setVeterinaria(Veterinaria veterinaria2) {
        this.veterinaria = veterinaria2;
    }

    
    public ElementoFicha(String fecha, Diagnostico diagnostico, String tratamiento) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        
    }

    public String toString() {
        String linea = String.format("Fecha: %s\n Diagnostico:%s\nTratamiento: %s",fecha,diagnostico.getDescripcion(),tratamiento);
        return linea;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    
}
