package Clases.Ficha;

import Clases.Diagnostico;

public class ElementoFicha {
    private String fecha;
    private Diagnostico diagnostico;
    private String tratamiento;
    
    public ElementoFicha(String fecha, Diagnostico diagnostico, String tratamiento) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        
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
