/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecuatro;

import java.io.Serializable;

/**
 *
 * @author 0zzda
 */
public class Ciudad implements Serializable{
    private String nombreCiudad;
    private String nombreProvincia;
    public Ciudad(String nCiud, String nProv){
        nombreCiudad=nCiud;
        nombreProvincia= nProv;

    }
    public void setNombreCiudad(String n){
        nombreCiudad= n;
    }
    public String getNombreCiudad(){
        return nombreCiudad;
    }
    public void setNombreProvincia(String n){
        nombreProvincia=n;
    }
    public String getNombreProvincia(){
        return nombreProvincia;
    }   
    public String toString() {
        return String.format("%s - %s \n", nombreCiudad, nombreProvincia);
    }
}
