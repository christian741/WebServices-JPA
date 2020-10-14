/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Pojo;

import java.util.List;


/**
 *
 * @author Christian
 */
public class Mensaje {
    
    private ErrorWraper mensaje;
    private List<List<String>> lista;

    public Mensaje() {
    }

    public Mensaje(ErrorWraper mensaje, List<List<String>> lista) {
        this.mensaje = mensaje;
        this.lista = lista;
    }

    public ErrorWraper getMensaje() {
        return mensaje;
    }

    public void setMensaje(ErrorWraper mensaje) {
        this.mensaje = mensaje;
    }

    public List<List<String>> getLista() {
        return lista;
    }

    public void setLista(List<List<String>> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "mensaje=" + mensaje + ", lista=" + lista + '}';
    }


  

    
    
   
    
}
