package paquetecinco;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecturaArchivoSecuencialConstructora {

    private ObjectInputStream entrada;
    private ArrayList<Constructora> Constructoras;
    private String nombreArchivo;
    /*Variable id para la busqueda de la constructora ingresando el id
    Variable l para enivar la informacion requerida o si un mensaje de que no 
    se econtro nada*/
    private String id;
    private int l;
    public LecturaArchivoSecuencialConstructora(String n, String idd) {
        nombreArchivo = n;
        id=idd;
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

    public void establecerListaCosntructoras() {
        // 
        Constructoras = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    Constructoras.add(registro);
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

    public ArrayList<Constructora> obtenerListaConstructoras() {
        return Constructoras;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Empresa Constructora\n";
        for (int i = 0; i < obtenerListaConstructoras().size(); i++) {
            Constructora p = obtenerListaConstructoras().get(i);
            /*Mediante un if y un .contains se busca si la clase tiene 
            o no esa informacion en dicha posicion y de no serlo se envia un
            mensaje de que no existe
            */
            if(obtenerListaConstructoras().get(i).getIdEmpresa().contains(id)){
                cadena = String.format("%s %s - %s\n", cadena,
                    p.getIdEmpresa(), p.getNombnreConstructora());
                l=1;
            }            
        }
        if(l!=1){
            cadena="No hay propietario a esa identificacion";
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
