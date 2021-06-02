package paqueteseis;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author 0zzda
 */
public class LecturaArchivosSecuencialesCasa {
    private ObjectInputStream entrada;
    private ArrayList<Casa> Casas;
    private String nombreArchivo;
    /*Variable id para la busqueda de la casa ingresando la id del propietario
    Variable l para enivar la informacion requerida o si un mensaje de que no 
    se econtro nada*/
    private String id;
    private int l;
    public LecturaArchivosSecuencialesCasa(String n,String idd) {
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

    public void establecerListaCasas() {
        // 
        Casas = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Casa registro = (Casa) entrada.readObject();
                    Casas.add(registro);
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

    public ArrayList<Casa> obtenerListaCasas() {
        return Casas;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Casa\n";
        for (int i = 0; i < obtenerListaCasas().size(); i++) {
            Casa p = obtenerListaCasas().get(i);
            /*Mediante un if y un .equals se busca si la clase tiene 
            o no esa informacion en dicha posicion y de no serlo se envia un
            mensaje de que no existe*/
            if(obtenerListaCasas().get(i).getPropietario().equals(id))
            cadena = String.format("%s %s",cadena, p.toString());
            l=1;
        }
        if(l!=1){
            cadena="No hay casa a esa identificacion";
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
