/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.Random;

/**
 *
 * @author daniel
 */
public class App {
    //insertamos atributos encapsulados
    private int codigo;
    private static int codSumatorio;
    private static String[] arrayString = {"jsfh", "fjh", "dh", 
        "sdh", "sdh", "hgdh", "sdgh", "sdh", "sdgh", "sdhd"};
    private String nombre;
    private String descripcion;
    private double tamañoKb;
    private int numDescargas;
    
    //constructor parametrizado
    public App(String nombre, String descripcion, double tamañoKb, int numDescargas) {
        this.codigo = codSumatorio++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamañoKb = tamañoKb;
        this.numDescargas = numDescargas;
    }
    
    //constructor por defecto
    public App() {
        Random r = new Random();
        this.codigo = codSumatorio++;
        this.nombre = "app"+this.codigo+ (char)r.nextInt(97,123);
        this.descripcion = arrayString[r.nextInt(10)];
        this.tamañoKb = r.doubles(1, 100.0, 1025.0).findFirst().getAsDouble();
        this.numDescargas = r.ints(1, 0, 50001).findFirst().getAsInt();
    }
    
    //insertamos getter y setter
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTamañoKb() {
        return tamañoKb;
    }

    public void setTamañoKb(double tamañoKb) {
        this.tamañoKb = tamañoKb;
    }

    public int getNumDescargas() {
        return numDescargas;
    }

    public void setNumDescargas(int numDescargas) {
        this.numDescargas = numDescargas;
    }
    
    //insertamos toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(codigo);
        sb.append(";").append(nombre);
        sb.append(";").append(descripcion);
        sb.append(";").append(tamañoKb);
        sb.append(";").append(numDescargas);
        return sb.toString();
    }
    
    
}
