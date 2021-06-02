package paqueteuno;

import java.io.IOException;
import paquetecinco.Constructora;
import paquetecinco.EscrituraArchivosSecuencialConstructora;
import paquetecinco.LecturaArchivoSecuencialConstructora;
import paquetecuatro.Ciudad;
import paquetecuatro.EscrituraArchivosSecuencialCiudad;
import paquetecuatro.LecturaArchivoSecuencialCiudad;
import paquetedos.Propietario;
import paquetedos.EscrituraArchivosSecuencialPropietario;
import paquetedos.LecturaArchivoSecuencialPropietario;
import paqueteseis.Casa;
import paqueteseis.EscrituraArchivosSecuencialesCasa;
import paqueteseis.LecturaArchivosSecuencialesCasa;
import paqueteseis.Departamento;
import paqueteseis.EscrituraArchivosSecuencialesDepartamento;
import paqueteseis.LecturaArchivosSecuencialesDepartamento;
import paquetetres.Ubicacion;
import paquetetres.EscrituraArchivosSecuencialUbicacion;
import paquetetres.LecturaArchivoSecuencialUbicacion;
import java.util.Scanner;

/**
 *
 * @author 0zzda
 */
public class Ejecutor {    
    Scanner read = new Scanner(System.in);    
    public static void main(String[] args){       
        Scanner read = new Scanner(System.in);    
        int op1, op2, op3, op4;
        System.out.println("Programa de Administracion Inmobiliaria");
        System.out.println("---------------------------------------");
        System.out.println("Ingrese la opcion que requiera\n1.-Ingresar datos"
                + "\n2.-Revisar los datos");
        op1=read.nextInt();
        /*Una bandera para entrar en un ciclo hasta que se decida salir con la
        opcion 7 en cada switch*/         
        boolean band =false;
        while(band == false){
        switch(op1){
            case 1:              
                System.out.println("Ingrese la opcion de ingreso\n1.-Propietario"
                        + "\n2.-Ubicaciones\n3.-Ciudad\n4.-Constructora"
                        + "\n5.-Casa\n6.-Departamento\n7.- Salir del registro");
                op2= read.nextInt();
                switch(op2){
                    case 1:
                        //Ingreso de datos del propietario
                        String nombreArchivoProp = "Propietarios.txt";
                        System.out.println("Nombre");String nomb = read.next();
                        System.out.println("Apellido");String ape=read.next();
                        System.out.println("Identificacion");String iden=read.next();
                        //Se crea un objeto propietario
                        Propietario propietario = new Propietario(nomb, ape, iden);
                        Propietario[] listapr={propietario};    
                        //Se serealiza el propietario
                        EscrituraArchivosSecuencialPropietario archivoProp = new
                        EscrituraArchivosSecuencialPropietario(nombreArchivoProp);
                        for (int i = 0; i < listapr.length; i++) {
                            // establecer el valor del atributo registro
                            archivoProp.establecerRegistro(listapr[i]);
                            // establecer en el archivo el atributo del registro
                            archivoProp.establecerSalida();
                        }
                        archivoProp.cerrarArchivo();
                        break;
                    case 2:
                        System.out.println("1.-Ubicacion Casa\n2.-Ubicacion"
                                + "departamento");
                        op4=read.nextInt();
                        if(op4==1){
                            String nombreArchivoUbiC = "Ubicaciones.txt";
                            //Ingreso de datos del de ubicacion
                            System.out.println("Numero de casa");String ncasa = read.next();
                            System.out.println("Nombre del barrio");String nobarr=read.next();
                            System.out.println("Color del edificio");String red=read.next();
                            //Se crea un objeto ubicacion
                            Ubicacion ubicacion = new Ubicacion(ncasa, nobarr, red);
                            Ubicacion[] listauC={ubicacion};
                            //Se serealiza la ubicaion
                            EscrituraArchivosSecuencialUbicacion archivoUbiC = new
                            EscrituraArchivosSecuencialUbicacion(nombreArchivoUbiC);
                            for (int i = 0; i < listauC.length; i++) {
                                // establecer el valor del atributo registro
                                archivoUbiC.establecerRegistro(listauC[i]);
                                // establecer en el archivo el atributo del registro
                                archivoUbiC.establecerSalida();
                            }
                            archivoUbiC.cerrarArchivo();
                        }else if(op4==2){
                            String nombreArchivoUbiC = "Ubicaciones.txt";
                            //Ingreso de datos del de ubicacion
                            System.out.println("Nombre del barrio");String nobarr=read.next();
                            System.out.println("Color de la casa");String red=read.next();
                            //Se crea el objeto ubicacon 
                            Ubicacion ubicacion = new Ubicacion(nobarr, red);
                            Ubicacion[] listauC={ubicacion};
                            //Se serealiza la ubicaion
                            EscrituraArchivosSecuencialUbicacion archivoUbiC = new
                            EscrituraArchivosSecuencialUbicacion(nombreArchivoUbiC);
                            for (int i = 0; i < listauC.length; i++) {
                                // establecer el valor del atributo registro
                                archivoUbiC.establecerRegistro(listauC[i]);
                                // establecer en el archivo el atributo del registro
                                archivoUbiC.establecerSalida();
                            }
                            archivoUbiC.cerrarArchivo();
                        }
                        break;
                    case 3:
                        String nombreArchivoCui = "Ciudades.txt";
                        //Ingreso de datos del de Ciudades
                        System.out.println("Nombre de la ciudad");String nombC = read.next();
                        System.out.println("Nombre de la provincia");String nomPr=read.next();
                        //Se crea el objeto ciudad 
                        Ciudad ciudad = new Ciudad(nombC, nomPr);
                        Ciudad[] listaCiu={ciudad};             
                        //Se serealiza la ciudad
                        EscrituraArchivosSecuencialCiudad archivoCiu = new
                        EscrituraArchivosSecuencialCiudad(nombreArchivoCui);
                        for (int i = 0; i < listaCiu.length; i++) {
                            // establecer el valor del atributo registro
                            archivoCiu.establecerRegistro(listaCiu[i]);
                            // establecer en el archivo el atributo del registro
                            archivoCiu.establecerSalida();
                        }
                        archivoCiu.cerrarArchivo();
                        break;
                    case 4:
                        String nombreArchivoCons = "Constructoras.txt";
                        //Ingreso de datos del de Constructoras
                        System.out.println("Nombre de la constructora");String nombCons = read.next();
                        System.out.println("Id de la empresa");String id=read.next();
                        Constructora constructora = new Constructora(nombCons, id);
                        //Se crea el objeto Constructora
                        Constructora[] listaCons={constructora};     
                        //Se serealiza la Constructoras
                        EscrituraArchivosSecuencialConstructora archivoCons = new
                        EscrituraArchivosSecuencialConstructora(nombreArchivoCons);
                        for (int i = 0; i < listaCons.length; i++) {
                            // establecer el valor del atributo registro
                            archivoCons.establecerRegistro(listaCons[i]);
                            // establecer en el archivo el atributo del registro
                            archivoCons.establecerSalida();
                        }
                        archivoCons.cerrarArchivo();
                        break;
                    case 5:
                        String nombreArchivoCasas = "Casas.txt";
                        //Se extrae el propietario por identificaion
                        String nombreArchivo = "Propietarios.txt";                        
                        System.out.println("Ingrese la identificicacion");
                        String idd = read.next();                        
                        LecturaArchivoSecuencialPropietario lectura = new 
                        LecturaArchivoSecuencialPropietario(nombreArchivo, idd);
                        lectura.establecerListaPropietarios();
                        //Se piden datos
                        System.out.println("Ingrese el precio por metro cuadrado");
                        double pcm2=read.nextDouble();
                        System.out.println("Ingrese el numero de metros cuadrados");
                        double nmetrosc=read.nextDouble();
                        //Se extrae la ubicacion por referencia
                        String nombreArchivoUbiC = "Ubicaciones.txt";                        
                        System.out.println("Ingrese la referencia");
                        String ref = read.next();                        
                        LecturaArchivoSecuencialUbicacion lecturaUbi = new 
                        LecturaArchivoSecuencialUbicacion(nombreArchivoUbiC, ref);
                        lecturaUbi.establecerListaUbicaciones();
                        //Se extrae la ciudad y provincia por medio de la ciudad
                        String nombreArchivoCiu = "Ciudades.txt";                        
                        System.out.println("Ingrese la ciudad");
                        String cc = read.next();                        
                        LecturaArchivoSecuencialCiudad lecturaCiu = new 
                        LecturaArchivoSecuencialCiudad(nombreArchivoCiu, cc);
                        lecturaCiu.establecerListaCiudades();
                        //Se piden datos
                        System.out.println("Ingrese el numero de cuartos");
                        int ncuartos=read.nextInt();
                        //se extrae la constructora por medio de la id 
                        String nombreArchivoConsex = "Constructoras.txt";                        
                        System.out.println("Ingrese el id de la empresa");
                        String idde = read.next();                        
                        LecturaArchivoSecuencialConstructora lecturaCons = new 
                        LecturaArchivoSecuencialConstructora(nombreArchivoConsex, idde);
                        lecturaCons.establecerListaCosntructoras();
                        
                        //Se crea al objeto casa
                        
                        Casa casa = new Casa(lectura.toString(),pcm2, nmetrosc,
                        lecturaUbi.toString(),lecturaCiu.toString(),
                        ncuartos,lecturaCons.toString());
                        Casa[] listaCasa={casa};  
                        EscrituraArchivosSecuencialesCasa archivoCasa = new
                        EscrituraArchivosSecuencialesCasa(nombreArchivoCasas);
                        for (int i = 0; i < listaCasa.length; i++) {
                            // establecer el valor del atributo registro
                            archivoCasa.establecerRegistro(listaCasa[i]);
                            // establecer en el archivo el atributo del registro
                            archivoCasa.establecerSalida();
                        }
                        archivoCasa.cerrarArchivo();
                        break;
                    case 6:
                        String nombreArchivodepa = "Departamentos.txt";
                        //Se extrae el propietario por identificaion
                        String nombreArchivode = "Propietarios.txt";                        
                        System.out.println("Ingrese la identificicacion");
                        String idden = read.next();                        
                        LecturaArchivoSecuencialPropietario lecturap = new 
                        LecturaArchivoSecuencialPropietario(nombreArchivode, idden);
                        lecturap.establecerListaPropietarios();
                        //Se piden datos
                        System.out.println("Ingrese el precio por metro cuadrado");
                        double pcme=read.nextDouble();
                        System.out.println("Ingrese el numero de metros cuadrados");
                        double nmetrsc=read.nextDouble();
                        System.out.println("Ingrese el valor de alicuota mensual");
                        double valAli=read.nextDouble();
                        System.out.println("Ingrese el precio");
                        double presio=read.nextDouble();
                        //Se extrae la ubicacion por referencia
                        String nombreArchivoUbC = "Ubicaciones.txt";                        
                        System.out.println("Ingrese la referencia");
                        String refe = read.next();                        
                        LecturaArchivoSecuencialUbicacion lecturaUbic = new 
                        LecturaArchivoSecuencialUbicacion(nombreArchivoUbC, refe);
                        lecturaUbic.establecerListaUbicaciones();
                        //Se extrae la ciudad y provincia por medio de la ciudad
                        String nombreArchivoCiud = "Ciudades.txt";                        
                        System.out.println("Ingrese la ciudad");
                        String ciud = read.next();                        
                        LecturaArchivoSecuencialCiudad lecturaCiud = new 
                        LecturaArchivoSecuencialCiudad(nombreArchivoCiud, ciud);
                        lecturaCiud.establecerListaCiudades();
                        //Se piden datos
                        System.out.println("Ingrese el nombre del edificio");
                        String nomedi=read.next();
                        System.out.println("Ingrese la ubicacion del "
                                + "departamento en el edificio");
                        String ubiEdi=read.next();
                        //se extrae la constructora por medio de la id 
                        String nombreArchivoConstrr = "Constructoras.txt";                        
                        System.out.println("Ingrese el id de la empresa");
                        String iddee = read.next();                        
                        LecturaArchivoSecuencialConstructora lecturaConss = new 
                        LecturaArchivoSecuencialConstructora(nombreArchivoConstrr, iddee);
                        lecturaConss.establecerListaCosntructoras();
                        
                        //Se genera el objeto departamento 
                        
                        Departamento departa = new Departamento(lecturap.toString(),pcme, nmetrsc,
                        valAli,presio, lecturaUbic.toString(),lecturaCiud.toString(),
                        nomedi,ubiEdi,lecturaConss.toString());
                        
                        Departamento[] listaDepa={departa};  
                        EscrituraArchivosSecuencialesDepartamento archivoDepa = new
                        EscrituraArchivosSecuencialesDepartamento(nombreArchivodepa);
                        for (int i = 0; i < listaDepa.length; i++) {
                            // establecer el valor del atributo registro
                            archivoDepa.establecerRegistro(listaDepa[i]);
                            // establecer en el archivo el atributo del registro
                            archivoDepa.establecerSalida();
                        }
                        archivoDepa.cerrarArchivo();
                    case 7:
                        band =true;
                        break;      
                }
                break;
            case 2:
                System.out.println("Ingrese la opcion de lectura\n1.-Propietario"
                        + "\n2.-Ubicaciones\n3.-Ciudad\n4.-Constructora"
                        + "\n5.-Casa\n6.-Departamento\n7.-Terminar revision");
                op3= read.nextInt();
 
                switch(op3){
                    //Se leen los datos extraidos de sus lectores correspondientes
                    case 1:
                        String nombreArchivo = "Propietarios.txt";                        
                        System.out.println("Ingrese la identificicacion");
                        String id = read.next();                        
                        LecturaArchivoSecuencialPropietario lectura = new 
                        LecturaArchivoSecuencialPropietario(nombreArchivo, id);
                        lectura.establecerListaPropietarios();
                        System.out.println(lectura);
                        break;
                    case 2:
                        String nombreArchivoUbiC = "Ubicaciones.txt";                        
                        System.out.println("Ingrese la referencia");
                        String ref = read.next();                        
                        LecturaArchivoSecuencialUbicacion lecturaUbi = new 
                        LecturaArchivoSecuencialUbicacion(nombreArchivoUbiC, ref);
                        lecturaUbi.establecerListaUbicaciones();
                        System.out.println(lecturaUbi);
                        break;
                    case 3:
                        String nombreArchivoCiu = "Ciudades.txt";                        
                        System.out.println("Ingrese la ciudad");
                        String cc = read.next();                        
                        LecturaArchivoSecuencialCiudad lecturaCiu = new 
                        LecturaArchivoSecuencialCiudad(nombreArchivoCiu, cc);
                        lecturaCiu.establecerListaCiudades();
                        System.out.println(lecturaCiu);
                        break;
                    case 4:
                        String nombreArchivoCons = "Constructoras.txt";                        
                        System.out.println("Ingrese el id de la empresa");
                        String idd = read.next();                        
                        LecturaArchivoSecuencialConstructora lecturaCons = new 
                        LecturaArchivoSecuencialConstructora(nombreArchivoCons, idd);
                        lecturaCons.establecerListaCosntructoras();
                        System.out.println(lecturaCons);
                        break;
                    case 5:
                        String nombreArchivoCasa = "Casas.txt";                        
                        System.out.println("Ingrese el id de la empresa");
                        String iden = read.next();                        
                        LecturaArchivosSecuencialesCasa lecturaCasa = new 
                        LecturaArchivosSecuencialesCasa(nombreArchivoCasa, iden);
                        lecturaCasa.establecerListaCasas();
                        System.out.println(lecturaCasa);
                        break;
                    case 6:
                        String nombreArchivoDeps = "Departamentos.txt";                        
                        System.out.println("Ingrese el id de la empresa");
                        String ideen = read.next();                        
                        LecturaArchivosSecuencialesDepartamento lecturaDepa = new 
                        LecturaArchivosSecuencialesDepartamento(nombreArchivoDeps, ideen);
                        lecturaDepa.establecerListaDepartamentos();
                        System.out.println(lecturaDepa);   
                        break;                        
                    case 7:
                        band=true;
                        break;                
            }
        }
        }
    }    
}