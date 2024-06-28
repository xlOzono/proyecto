package Clases.Ficha;

import java.util.ArrayList;

public class Factura {
    private int idCliente;
    private int idEmpresa;
    private int numFactura;
    private ArrayList<Factura> facturas = new ArrayList<Factura>();
    private ArrayList<ElementoFactura> conjFacturas;

    public Factura(int idCliente, int idEmpresa) {
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
        if (facturas.isEmpty()) {
            this.numFactura = 1;
        }else{
            this.numFactura = facturas.size()+1;
        
        }
        conjFacturas = new ArrayList<>();
    }
    public ArrayList<Factura> getFacturas() {
        return facturas;
    }
    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public int getNumFactura() {
        return numFactura;
    }
    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }
    public ArrayList<ElementoFactura> getElementoFacturas() {
        return conjFacturas;
    }
    public void setElementoFacturas(ArrayList<ElementoFactura> elementoFacturas) {
        this.conjFacturas = elementoFacturas;
    }

}
