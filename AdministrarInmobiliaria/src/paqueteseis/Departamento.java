/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import java.io.Serializable;
import paquetecinco.Constructora;
import paquetecuatro.Ciudad;
import paquetedos.Propietario;
import paquetetres.Ubicacion;

/**
 *
 * @author 0zzda
 */
public class Departamento implements Serializable{

    private String propietarioDepa;
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrados;
    private double valorAlicuotaMensual;
    private double costoFinal;
    private double precio;
    private String ubicacio;
    private String ciudadDepa;
    private String nombreEdificio;
    private String ubicacionEdificio;
    private String constructoraDepa;

    public Departamento(String prop, double pMeC, double numMeC,
            double valAlM, double pre, String ubi, String ciuDep,
            String nomEd, String ubiEdi, String consDepa) {
        propietarioDepa = prop;
        precioMetroCuadrado = pMeC;
        numeroMetrosCuadrados = numMeC;
        valorAlicuotaMensual = valAlM;
        precio = pre;
        ubicacio = ubi;
        ciudadDepa = ciuDep;
        nombreEdificio = nomEd;
        ubicacionEdificio = ubiEdi;
        constructoraDepa = consDepa;
    }

    public void setPropietario(String n) {
        propietarioDepa = n;
    }

    public String getPropietario() {
        return propietarioDepa;
    }

    public void setPrecioMEtroCuadrado(double n) {
        precioMetroCuadrado = n;
    }

    public double getPrecioMEtroCuadrado() {
        return precioMetroCuadrado;
    }

    public void setNumeroMetrosCuadrados(double n) {
        numeroMetrosCuadrados = n;
    }

    public double getNumeroMetrosCuadrados() {
        return numeroMetrosCuadrados;
    }

    public void setValorAlicuotaMensual(double n) {
        valorAlicuotaMensual = n;
    }

    public double getValorAlicuotaMensual() {
        return valorAlicuotaMensual;
    }

    public void setPrecioFinal() {
        costoFinal = (numeroMetrosCuadrados * precioMetroCuadrado)
                + (valorAlicuotaMensual * 12);
    }

    public double getPrecioFinal() {
        return costoFinal;
    }

    public void setPrecio(double n) {
        precio = n;
    }

    public double getPrecio() {
        return precio;
    }

    public void setUbicacionDepartamento(String n) {
        ubicacio = n;
    }

    public String getUbicacionDepartamento() {
        return ubicacio;
    }

    public void setCiudadDepartamento(String n) {
        ciudadDepa = n;
    }

    public String getCiudadDepartamento() {
        return ciudadDepa;
    }

    public void setNombreEdificio(String n) {
        nombreEdificio = n;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setUbicacionEdificio(String n) {
        ubicacionEdificio = n;
    }

    public String getUbicacionEdificio() {
        return ubicacionEdificio;
    }

    public void setConstruntoraDepartamento(String n) {
        constructoraDepa = n;
    }

    public String getConstructoraDepartamento() {
        return constructoraDepa;
    }
    public String toString() {
        return String.format("Propietario\n%s\nPrecio por metro cuadrado %s, "
                + "Numero de metros cuadrados %s\nValor alicuota mensual %s\n"
                + "Costo final %s, precio: %s\nUbicacion:\n%s\nCiudad:\n%s\n"
                + "Nombre del edificio: %s, ubicacion del departamento en "
                + "edificio %s\nConstructora:\n%s\n", getPropietario(), 
                getPrecioMEtroCuadrado(), getNumeroMetrosCuadrados(), 
                getValorAlicuotaMensual(), getPrecioFinal(), getPrecio(), 
                getUbicacionDepartamento(), getCiudadDepartamento(),
                getNombreEdificio(), getUbicacionEdificio(), 
                getConstructoraDepartamento());
    }
    
}
