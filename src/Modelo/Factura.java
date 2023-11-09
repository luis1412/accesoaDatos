/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Factura {
    int numLinea;
    int numFactura;
    String nifCliente, nifEmisor, numCuenta;
    double base, iva, total, pagada;
    int codNeumatico;
    String concepto;
    int numNeumaticos;
    double precio;
    LocalDate fechaSistema;

    public Factura() {
    }

    public Factura(int numLinea, int numFactura, String nifCliente, String nifEmisor, String numCuenta, double base, double iva, double total, double pagada, int codNeumatico, String concepto, int numNeumaticos, double precio, LocalDate fechaSistema) {
        this.numLinea = numLinea;
        this.numFactura = numFactura;
        this.nifCliente = nifCliente;
        this.nifEmisor = nifEmisor;
        this.numCuenta = numCuenta;
        this.base = base;
        this.iva = iva;
        this.total = total;
        this.pagada = pagada;
        this.codNeumatico = codNeumatico;
        this.concepto = concepto;
        this.numNeumaticos = numNeumaticos;
        this.precio = precio;
        this.fechaSistema = fechaSistema;
    }
    
    public Factura(int numLinea, int numFactura, int codNeumatico, String concepto, int numNeumatico, double precio) {
        this.numLinea = numLinea;
        this.numFactura = numFactura;
        this.codNeumatico = codNeumatico;
        this.concepto = concepto;
        this.numNeumaticos = numNeumatico;
        this.precio = precio;
    }
    
    public Factura(int numFactura, String nifCliente, String nifEmisor,LocalDate fechaSistema, double base, double iva, double total, double pagada, String numCuenta) {
        this.numFactura = numFactura;
        this.nifCliente = nifCliente;
        this.nifEmisor = nifEmisor;
        this.fechaSistema = fechaSistema;
        this.base = base;
        this.iva = iva;
        this.total = total;
        this.pagada = pagada;
        this.numCuenta = numCuenta;
    }

    public int getNumLinea() {
        return numLinea;
    }

    public void setNumLinea(int numLinea) {
        this.numLinea = numLinea;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public String getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(String nifCliente) {
        this.nifCliente = nifCliente;
    }

    public String getNifEmisor() {
        return nifEmisor;
    }

    public void setNifEmisor(String nifEmisor) {
        this.nifEmisor = nifEmisor;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPagada() {
        return pagada;
    }

    public void setPagada(double pagada) {
        this.pagada = pagada;
    }

    public int getCodNeumatico() {
        return codNeumatico;
    }

    public void setCodNeumatico(int codNeumatico) {
        this.codNeumatico = codNeumatico;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getNumNeumaticos() {
        return numNeumaticos;
    }

    public void setNumNeumaticos(int numNeumaticos) {
        this.numNeumaticos = numNeumaticos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaSistema() {
        return fechaSistema;
    }

    public void setFechaSistema(LocalDate fechaSistema) {
        this.fechaSistema = fechaSistema;
    }
    
    
    
    
}
