/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author 0zzda
 */
public class EscrituraArchivosSecuencialesDepartamento {
    private String nombreArchivo;
    private ObjectOutputStream salida; // envía los datos a un archivo
    private Departamento registro;
    private ArrayList<Departamento> lista;
    //Variable en nulo para que no altere la salida
    private String id=null;
    public EscrituraArchivosSecuencialesDepartamento(String nombreArc){
        nombreArchivo = nombreArc;
        establecerLista(); // obtener los valores (objetos)
                                    // que tiene el archivo.
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerLista().size() > 0) {
                for (int i = 0; i < obtenerLista().size(); i++) {
                    establecerRegistro(obtenerLista().get(i));
                    establecerSalida();
                }
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        } // fin de catch
    }
    
    public void establecerNombreArchivo(String n){
        nombreArchivo = n;
    }
    // agrega registros al archivo
    public void establecerRegistro(Departamento p) {
        registro = p;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    // en el atributo listaDepartamentos los registros 
    // del archivores 
    public void establecerLista(){
        LecturaArchivosSecuencialesDepartamento l = new 
        LecturaArchivosSecuencialesDepartamento(obtenerNombreArchivo(),id);
        l.establecerListaDepartamentos();
        lista = l.obtenerListaDepartamentos();
    }

    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    
    public ArrayList<Departamento> obtenerLista() {
        return lista;
    }

    public ObjectOutputStream obtenerSalida(){
        return salida;
    }
    public void cerrarArchivo() {
        try // cierra el archivo
        {
            if (salida != null) {
                salida.close();
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");            
        } // fin de catch
    }
}
