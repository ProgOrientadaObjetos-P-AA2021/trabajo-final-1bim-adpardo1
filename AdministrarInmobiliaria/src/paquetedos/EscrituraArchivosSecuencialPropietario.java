package paquetedos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscrituraArchivosSecuencialPropietario {

    private String nombreArchivo;
    private ObjectOutputStream salida; // envía los datos a un archivo
    private Propietario registro;
    private ArrayList<Propietario> lista;
    //Variable en nulo para que no altere la salida
    private String idd=null;
    
    public EscrituraArchivosSecuencialPropietario(String nombreArc){
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
    public void establecerRegistro(Propietario p) {
        registro = p;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    // en el atributo listaPropietarios obtenemos los registros 
    // del archivo
    public void establecerLista(){
        LecturaArchivoSecuencialPropietario l = new 
        LecturaArchivoSecuencialPropietario(obtenerNombreArchivo(),idd);
        l.establecerListaPropietarios();
        lista = l.obtenerListaPropietarios();
    }

    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    
    public ArrayList<Propietario> obtenerLista() {
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
