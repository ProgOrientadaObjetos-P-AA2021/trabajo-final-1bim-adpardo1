package paquetecuatro;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class LecturaArchivoSecuencialCiudad {

    private ObjectInputStream entrada;
    private ArrayList<Ciudad> Ciudades;
    private String nombreArchivo;
    /*Variable ciudad para la busqueda de la ciudad y provincia ingresando la ciudad
    Variable l para enivar la informacion requerida o si un mensaje de que no 
    se econtro nada*/
    private String ciudad;
    private int l;
    public LecturaArchivoSecuencialCiudad(String n, String cc) {
        nombreArchivo = n;
        ciudad = cc;
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

    public void establecerListaCiudades() {
        // 
        Ciudades = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    Ciudades.add(registro);
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

    public ArrayList<Ciudad> obtenerListaCiudades() {
        return Ciudades;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Lista de ciudades\n";
        for (int i = 0; i < obtenerListaCiudades().size(); i++) {
            Ciudad p = obtenerListaCiudades().get(i);
            /*Mediante un if y un .equals se busca si la clase tiene 
            o no esa informacion en dicha posicion y de no serlo se envia un
            mensaje de que no existe*/
            if(obtenerListaCiudades().get(i).getNombreCiudad().equals(ciudad)){
                cadena = String.format("%s %s\n", cadena,p.toString());
                l=1;
            }
        }
        if(l!=1){
            cadena="No hay ciudad";
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
