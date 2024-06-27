package Clases.Ficha;

import java.util.ArrayList;

import Clases.Diagnostico;
import Clases.Persona;
import Clases.Animales.Animal;
import Clases.Animales.Domesticos.Domestico;

public class Ficha {
    public static ArrayList<Ficha> fichas = new ArrayList<>();
    private int numFicha;
    private Animal mascota;
    private Persona propietario;
    private ArrayList<ElementoFicha> conjElementos;

    public Ficha() {
        if (fichas.isEmpty()) {
            this.numFicha = 1;
        }else{
            this.numFicha = fichas.size()+1;
        }
        System.out.println(this.numFicha);
        fichas.add(this);
        System.out.println(fichas);
        conjElementos = new ArrayList<>();
    }

    public static Ficha getFicha(Animal mascota) {
        for(Ficha ficha: fichas){
            if (ficha.mascota == mascota) {
                return ficha;
            }
        }
        return null;
    }
    
//* public String toString() {
//    if (mascota instanceof Domestico) {
//        String linea = String.format("Numero de Ficha: %s \nNombre Mascota: %s\nNombre Propietario", numFicha,((Domestico)mascota).getNombre(),propietario.);
//    }else{
//        String linea = String.format("Numero de Ficha: %s \nNombre Mascota: %s\nNombre Propietario", numFicha);
//    }
//    return linea;
//  }
    

    public int getNumFicha() {
        return numFicha;
    }

    public void setNumFicha(int numFicha) {
        this.numFicha = numFicha;
    }

    public ArrayList<ElementoFicha> getConjElementos() {
        return conjElementos;
    }
    
    public void addElemento(ElementoFicha elemento) {
        this.conjElementos.add(elemento);
    }

    public void setConjElemento(ArrayList<ElementoFicha> conjElementos) {
        this.conjElementos = conjElementos;
    }

    public void agregarElemento(String fecha, Diagnostico diagnostico, String tratamiento) {
        conjElementos.add(new ElementoFicha(fecha, diagnostico, tratamiento));
    }

    public static ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public static void setFichas(ArrayList<Ficha> fichas) {
        Ficha.fichas = fichas;
    }

    public Animal getMascota() {
        return mascota;
    }

    public void setMascota(Animal mascota) {
        this.mascota = mascota;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public void setConjElementos(ArrayList<ElementoFicha> conjElementos) {
        this.conjElementos = conjElementos;
    }
    
}

