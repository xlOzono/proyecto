package Clases;

import java.util.ArrayList;

public class Ficha {
    private int numFicha;
    private ArrayList<ElementoFicha> conjElementos;

    public Ficha(int numFicha) {
        this.numFicha = numFicha;

    }

    public int getNumFicha() {
        return numFicha;
    }

    public void setNumFicha(int numFicha) {
        this.numFicha = numFicha;
    }

    public ArrayList<ElementoFicha> getConjElementos() {
        return conjElementos;
    }

    public void setConjElemento(ArrayList<ElementoFicha> conjElementos) {
        this.conjElementos = conjElementos;
    }

    public void agregarElemento(String fecha, Diagnostico diagnostico, String tratamiento) {
        conjElementos.add(new ElementoFicha(fecha, diagnostico, tratamiento));
    }
    
}

