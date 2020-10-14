/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Pojo;

import java.io.Serializable;
import java.time.Instant;


/**
 *
 * @author Christian
 */
public class ErrorWraper implements Serializable{
    
    private String mensaje;
    private String codigo;
    private String nombreCodigo;
    private Instant Timestamp;

    public ErrorWraper() {
    }
    

    public ErrorWraper(String mensaje, String codigo, String nombreCodigo) {
        this.mensaje = mensaje;
        this.codigo = codigo;
        this.nombreCodigo = nombreCodigo;
        this.Timestamp = Instant.now();
    }

    
    public Instant getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Instant Timestamp) {
        this.Timestamp = Timestamp;
    }

   
    
    public String getError() {
        return mensaje;
    }

    public void setError(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCodigo() {
        return nombreCodigo;
    }

    public void setNombreCodigo(String nombreCodigo) {
        this.nombreCodigo = nombreCodigo;
    }

    
    
    
}
