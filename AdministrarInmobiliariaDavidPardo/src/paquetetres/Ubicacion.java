package paquetetres;
import java.io.Serializable;

/**
 *
 * @author 0zzda
 */

public class Ubicacion implements Serializable{
    private String numeroCasa;
    private String nombreBarrio;
    private String referencia;
    
    public Ubicacion(String nCasa, String barr, String ref){
        numeroCasa=nCasa;
        nombreBarrio=barr;
        referencia=ref;
    }
    public Ubicacion(String barr, String ref){
        nombreBarrio=barr;
        referencia=ref;
    }    
    public void setNumeroCasa(String n){
        numeroCasa=n;
    }
    public String getNumeroCasa(){
        return numeroCasa;
    }
    public void setNombreBarrio(String n){
        nombreBarrio=n;
    }
    public String getNombreBarrio(){
        return nombreBarrio;
    }
    public void setReferencia(String n){
        referencia=n;
    }
    public String getReferencia(){
        return referencia;
    }

    public String toString() {
        return String.format("%s - %s - %s\n",numeroCasa,nombreBarrio,referencia);
    }
}
