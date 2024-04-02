/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

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
}
