package paquetedos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class LecturaArchivoSecuencialPropietario {

    private ObjectInputStream entrada;
    private ArrayList<Propietario> Propietarios;
    private String nombreArchivo;
    /*Variable id para la busqueda del propietario ingresando la id
    Variable l para enivar la informacion requerida o si un mensaje de que no 
    se econtro nada*/
    private String id;
    private int l;
    private Propietario propietarioBuscado;
    public LecturaArchivoSecuencialPropietario(String n, String ide){
        nombreArchivo = n;
        id=ide;
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
    public void setPropietarioBuscado(String id){
        for(int i=0; i<= obtenerListaPropietarios().size();i++){
            if(obtenerListaPropietarios().get(i).getIdentificacion().equals(id)){
                propietarioBuscado=obtenerListaPropietarios().get(i);
            }
        }
    }
    public Propietario getPropietarioBuscado(){
        return propietarioBuscado;
    }
    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaPropietarios() {
        // 
        Propietarios = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    Propietarios.add(registro);
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

    public ArrayList<Propietario> obtenerListaPropietarios() {
        return Propietarios;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    @Override
    public String toString() {
        String cadena = "Propietario\n";
        for (int i = 0; i < obtenerListaPropietarios().size(); i++) {
            Propietario p = obtenerListaPropietarios().get(i);
            /*Mediante un if y un .equals se busca si la clase tiene 
            o no esa informacion en dicha posicion y de no serlo se envia un
            mensaje de que no existe*/
            if(obtenerListaPropietarios().get(i).getIdentificacion().equals(id)){
                cadena = String.format("%s%s - %s \nId: %s\n", cadena,
                        p.getNombre(), p.getApellidos(), p.getIdentificacion());
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
