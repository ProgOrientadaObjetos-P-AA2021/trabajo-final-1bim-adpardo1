package paquetetres;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecturaArchivoSecuencialUbicacion {

    private ObjectInputStream entrada;
    private ArrayList<Ubicacion> Ubicaciones;
    private String nombreArchivo;
    /*Variable ref para la busqueda de la ubicacion ingresando la referemcia de la propidad
    Variable l para enivar la informacion requerida o si un mensaje de que no 
    se econtro nada*/
    private String ref;
    private int l;
    public LecturaArchivoSecuencialUbicacion(String n, String ff) {
        nombreArchivo = n;
        ref=ff;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaUbicaciones() {
        // 
        Ubicaciones = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Ubicacion registro = (Ubicacion) entrada.readObject();
                    Ubicaciones.add(registro);
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    // System.err.println("No hay datos en el archivo: " + ex);
                    break;
                }
            }
        }

    }

    public ArrayList<Ubicacion> obtenerListaUbicaciones() {
        return Ubicaciones;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    @Override
    public String toString() {
        String cadena = "Ubicacion\n";
        for (int i = 0; i < obtenerListaUbicaciones().size(); i++) {
            Ubicacion p = obtenerListaUbicaciones().get(i);
            /*Mediante un if y un .equals se busca si la clase tiene 
            o no esa informacion en dicha posicion y de no serlo se envia un
            mensaje de que no existe*/
            if(obtenerListaUbicaciones().get(i).getReferencia().equals(ref)){
                cadena = String.format("%sNumero casa: %s\n Nombre barrio: %s\n"
                        + "Referemcia: %s\n", cadena,
                p.getNumeroCasa(), p.getNombreBarrio(), p.getReferencia());
                l=1;
            }            
        }
        if(l!=1){
            cadena="No hay ubicacion a esa referencia";
        }
        return cadena;
    }
    // cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } 
    } 
}
