/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecinco;

import java.io.Serializable;

/**
 *
 * @author 0zzda
 */
public class Constructora implements Serializable{
    private String nombreConstructora;
    private String idEmpresa;
    public Constructora(String nom, String id){
        nombreConstructora= nom;
        idEmpresa= id;
    }
    public void setNombreConstructora(String n){
        nombreConstructora=n;
    }
    public String getNombnreConstructora(){
        return nombreConstructora;
    }
    public void setIdEmpresa(String n){
        idEmpresa=n;
    }
    public String getIdEmpresa(){
        return idEmpresa;
    }
    public String toString() {
        return String.format("%s - %s\n", idEmpresa, nombreConstructora );
    }
}
