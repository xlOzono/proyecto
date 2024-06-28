package Clases.Ficha;

import java.util.ArrayList;

import Clases.Diagnostico;


public class Ficha {
    public static ArrayList<Ficha> fichas = new ArrayList<Ficha>();
    private int numFicha;
    private ArrayList<ElementoFicha> conjElementos = new ArrayList<ElementoFicha>();

    public Ficha(int numFicha) {
        this.numFicha = numFicha;

        fichas.add(this);

    }
    public static ArrayList<Ficha> getArrayList(){
        return fichas;
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

