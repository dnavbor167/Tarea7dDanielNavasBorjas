/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemAlreadyExistsException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;

/**
 *
 * @author daniel
 */
public class Main {

    public static void main(String[] args) throws JAXBException, FileNotFoundException, IOException {
        //creamos 50 aplicaciones usando constructor por defecto y lo guardamos
        //en una lista
        List<App> lista = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            lista.add(new App());
        }
        //imprimimos por consola la lista de 50 elementos
        lista.forEach(System.out::println);

        //guardar los datos de todas las apps de la lista en un fichero de
        //texto llamado aplicacionestxt.csv dentro del directorio ./appscsv
        try {
            Directorios.crearDirectorio("./appscsv");
        } catch (FileSystemAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        readWrite.write("./appscsv/aplicacionestxt.csv", lista);

        //Crea un directorio, "./appscsv2", donde se guarden en archivos 
        //individuales CSV, los datos de cada una de las aplicaciones. 
        //En este directorio deben generarse 50 ficheros con el nombre 
        //que tenga la aplicación en su atributo.
        Directorios.crearDirectorio("./appscsv2");
        for (int i = 0; i < lista.size(); i++) {
            readWrite.write("./appscsv2/" + lista.get(i).getNombre() + ".csv", lista.get(i).toString());
        }

        try {
            Directorios.crearDirectorio("./appsxml");
        } catch (FileSystemAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        //método para escribir en un xml los datos de la lista
        readWrite.writeXml("aplicacionesxml.xml", lista);

        //método para leer el xml
        readWrite.readXml("aplicacionesxml.xml").forEach(System.out::println);

        try {
            Directorios.crearDirectorio("./appjson");
        } catch (FileSystemAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        readWrite.writeJson("aplicacionesxml.json", lista);

        Directorios.crearDirectorio("./copias");

        //llamamos a los métodos para hacer una copia
        Directorios.copiarFicheros("./appjson/aplicacionesxml.json",
                "./copias/copiaAplicacionesxml.json");

        Directorios.copiarFicheros("./appscsv/aplicacionestxt.csv",
                "./copias/copiaAplicacionestxt.csv");

        //vamos a mirar cuantos ficheros hay en el direcctorio appscsv2
        //para hacer la copia
        File carpeta = new File("./appscsv2");
        File[] array = carpeta.listFiles();

        for (File file : array) {
            try {
                Directorios.copiarFicheros("./appscsv2/" + file.getName(), "./copias/" + file.getName());
            } catch (FileSystemAlreadyExistsException e) {
                System.out.println(e.getMessage());
            }

        }

        //creamos una carpeta aplicaciones que contendrá .txt de la lista de apps
        try {
            Directorios.crearDirectorio("./aplicaciones");
        } catch (FileSystemAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        
        for (App app : lista) {
            readWrite.write("./aplicaciones/" + app.getNombre(), app.toString());
        }
    }
}
