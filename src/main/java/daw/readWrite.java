/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author daniel
 */
public class readWrite {

    //metodo para escribir en un fichero dado el nombre del fichero y dado
    //una palabra o conjunto de palabras
    public static void write(String file, List<App> lista) {
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < lista.size(); i++) {
                //escribimos en el fichero la palabra pasada por parámetro del método
                flujo.write(lista.get(i).toString());
                flujo.newLine();
            }
            //guardamos los cambios en el disco
            flujo.flush();
        } catch (IOException w) {
            System.out.println(w.getMessage());
        }
    }

    public static void write(String file, String word) {
        try {
            Files.write(Paths.get(file), word.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Error creando el fichero");
        }
    }

    //método para leer el fichero de la raíz
    public static List<String> read(String file) {
        List<String> lineas = new ArrayList<>();

        try {
            lineas = Files.readAllLines(Paths.get(file),
                    StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero " + file);
        }

        return lineas;
    }
    
    //metodo para escribir en xml
    public static void writeXml(String file, List<App> listaList) throws JAXBException {
        CatalogoApp catalogo = new CatalogoApp();
        ArrayList<App> listaArray = new ArrayList<>(listaList);
        catalogo.setLista(listaArray);
        catalogo.setDescripcion("Mis apps");
        
        // Crea el contexto JAXB. Se encarga de definir los objetos 
        // que vamos a guardar. En nuestro caso sólo el tipo CatalogoMuebles
        JAXBContext contexto = JAXBContext.newInstance(CatalogoApp.class);
        
        // El contexto JAXB permite crear un objeto Marshaller, que sirve para
        // generar la estructura del fichero XML 
        // El proceso de pasar objetos Java (CatalogoMuebles) a ficheros XML 
        // se conoce como "marshalling" o "serialización"
        Marshaller serializador = contexto.createMarshaller();
        
        // Especificamos que la propiedad del formato de salida
        // del serializador sea true, lo que implica que el formato se 
        // realiza con indentación y saltos de línea
        serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Llamando al método de serialización marshal (sobrecargado) se pueden
        // serializar objetos java en formato XML y volcarlos donde necesitemos:
        // consola, ficheros. El proceso consiste en que el contexto es el 
        // encargo de leer los objetos java, pasarlos al serializador y éste 
        // crear la salida de serialización
        
        // Serialización y salida por consola
        serializador.marshal(catalogo, System.out);

        // Volcado al fichero xml
        serializador.marshal(catalogo, new File("./appsxml/" + file));
    }
    
    //método para lees en xml
    public static ArrayList<App> readXml(String file) throws JAXBException, 
            FileNotFoundException{
        // Crea el contexto JAXB 
        JAXBContext contexto = JAXBContext.newInstance(CatalogoApp.class);
        // Crea el objeto Unmarshaller
        Unmarshaller um = contexto.createUnmarshaller();

        // Llama al método de unmarshalling
        CatalogoApp catalogo = (CatalogoApp) um.unmarshal(new File("./appsxml/" + file));

        ArrayList<App> listaApps = catalogo.getLista();

        return listaApps;
    }
}
