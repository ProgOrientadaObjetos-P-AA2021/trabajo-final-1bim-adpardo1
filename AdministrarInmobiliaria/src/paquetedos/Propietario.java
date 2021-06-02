package paquetedos;

import java.io.Serializable;

/**
 * 
 * @author 0zzdaa
 */

public class Propietario implements Serializable {
    private String nombres;
    private String apellidos;
    private String identificacion;
    
    public Propietario(String nom, String apell, String id){
        nombres=nom;
        apellidos=apell;
        identificacion=id;
    }
    public void settNombre(String n){
        nombres=n;
    }
    public String getNombre(){
        return nombres;
    }
    public void settApellidos(String n){
        apellidos=n;
    }
    public String getApellidos(){
        return apellidos;
    }
    public void setIdentificacion(String n){
        identificacion=n;
    }
    public String getIdentificacion(){
        return identificacion;
    }
    public String toString() {
        return String.format("%s - %s - %s\n",identificacion,nombres,apellidos);
    }
}


