/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CatalogoApp {
    
    //le decirle el nombre del catálogo
    @XmlElementWrapper(name = "catalogo")
    
    @XmlElement(name = "app")
    private ArrayList<App> lista;
    
    private String descripcion;

    public CatalogoApp() {
    }

    public ArrayList<App> getLista() {
        return lista;
    }

    public void setLista(ArrayList<App> lista) {
        this.lista = lista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
