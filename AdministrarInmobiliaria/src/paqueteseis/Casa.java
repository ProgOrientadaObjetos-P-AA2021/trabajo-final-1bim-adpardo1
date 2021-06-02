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
public class Casa implements Serializable{  
    
    private String propietarioCasa;
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrados;
    private double costoFinal;
    private String ubicacioCasa;
    private String ciudadCasa;
    private int numeroCuartos;
    private String constructoraCasa;
    
    public Casa(String prop, double pMeC, double numMeC,String ubi,
            String ciu,int nCuar, String consCasa) {
        propietarioCasa = prop;
        precioMetroCuadrado = pMeC;
        numeroMetrosCuadrados = numMeC;
        ubicacioCasa = ubi;
        ciudadCasa = ciu;
        numeroCuartos = nCuar;
        constructoraCasa = consCasa;
    }
    public void setPropietario(String n) {
        propietarioCasa = n;
    }

    public String getPropietario() {
        return propietarioCasa;
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

    public void setPrecioFinal() {
        costoFinal = (numeroMetrosCuadrados * precioMetroCuadrado);
    }

    public double getPrecioFinal() {
        return costoFinal;
    }

    public void setUbicacionCasa(String n) {
        ubicacioCasa = n;
    }

    public String getUbicacionCasa() {
        return ubicacioCasa;
    }

    public void setCiudadCasa(String n) {
        ciudadCasa = n;
    }

    public String getCiudadCasa() {
        return ciudadCasa;
    }
    
    public void setNumeroCuartos(int n){
        numeroCuartos=n;
    }
    
    public int getNumeroCuartos(){
        return numeroCuartos;
    }
    
    public void setConstruntoraCasa(String n) {
        constructoraCasa = n;
    }

    public String getConstructoraCasa() {
        return constructoraCasa;
    }

    public String toString() {
        return String.format("Propietario\n%s\nPrecio por metro cuadrado %s, "
                + "Numero de metros cuadrados %s\nCosto final %s\n"
                + "Ubicacion:\n%s\nCiudad:\n%s\nNumero de cuartos: %s"
                + "\nConstructora:\n%s\n", getPropietario(), 
                getPrecioMEtroCuadrado(), getNumeroMetrosCuadrados(), 
                getPrecioFinal(),getUbicacionCasa(), getCiudadCasa(),
                getNumeroCuartos(), getConstructoraCasa());
    }
    
}
