/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Pojo;

import java.util.ArrayList;
import udec.edu.co.Entity.Profesor;

/**
 *
 * @author Christian
 */
public class Mensaje {
    
    private ErrorWraper error;
    private ArrayList<Object> objeto;

    public Mensaje(){
        
    }
    
    public Mensaje(ErrorWraper error, ArrayList<Object> objeto) {
        this.error = error;
        this.objeto = objeto;
    }

  

    public ErrorWraper getError() {
        return error;
    }

    public void setError(ErrorWraper error) {
        this.error = error;
    }

    public ArrayList<Object> getObjeto() {
        return objeto;
    }

    public void setObjeto(ArrayList<Object> objeto) {
        this.objeto = objeto;
    }
    
    
    
}
