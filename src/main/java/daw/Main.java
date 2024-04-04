/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;

/**
 *
 * @author daniel
 */
public class Main {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
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
        readWrite.write("./appscsv/aplicacionestxt.csv", lista);
        
        //Crea un directorio, "./appscsv2", donde se guarden en archivos 
        //individuales CSV, los datos de cada una de las aplicaciones. 
        //En este directorio deben generarse 50 ficheros con el nombre 
        //que tenga la aplicación en su atributo.
        for(int i = 0; i < lista.size(); i++) {
            readWrite.write("./appscsv2/" + lista.get(i).getNombre() + ".csv", lista.get(i).toString());
        }
        
        //método para escribir en un xml los datos de la lista
        readWrite.writeXml("aplicacionesxml.xml", lista);
        
        //método para leer el xml
        readWrite.readXml("aplicacionesxml.xml").forEach(System.out::println);
    }
}
