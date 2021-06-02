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
public class LecturaArchivosSecuencialesDepartamento {
    private ObjectInputStream entrada;
    private ArrayList<Departamento> Departamentos;
    private String nombreArchivo;
    /*Variable ide para la busqueda del departamento ingresando la id del propietario
    Variable l para enivar la informacion requerida o si un mensaje de que no 
    se econtro nada*/
    private String idee;
    private int l;
    
    public LecturaArchivosSecuencialesDepartamento(String n, String id) {
        nombreArchivo = n;
        idee=id;
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

    public void establecerListaDepartamentos() {
        // 
        Departamentos = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    Departamentos.add(registro);
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

    public ArrayList<Departamento> obtenerListaDepartamentos() {
        return Departamentos;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Casa\n";
        for (int i = 0; i < obtenerListaDepartamentos().size(); i++) {
            Departamento p = obtenerListaDepartamentos().get(i);
            /*Mediante un if y un .contains se busca si la clase tiene 
            o no esa informacion en dicha posicion y de no serlo se envia un
            mensaje de que no existe*/
            if(obtenerListaDepartamentos().get(i).getPropietario().contains(idee)){
                cadena = String.format("%s %s - %s - %s - %s - %s - %s - %s - %s - %s - %s - %s\n", cadena,
                    p.getPropietario(), p.getPrecioMEtroCuadrado(), p.getNumeroMetrosCuadrados()
            ,p.getValorAlicuotaMensual(), p.getPrecioFinal(), p.getPrecio(),p.getUbicacionDepartamento(),
            p.getCiudadDepartamento(),p.getNombreEdificio(),p.getConstructoraDepartamento());
                l=1;
            }            
        }
        if(l!=1){
            cadena="No hay departamento a esa identificacion";
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
