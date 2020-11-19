/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Dto;

import udec.edu.co.Entity.Libro;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 *
 * @author ASUS-PC
 */
public class AutorDto implements Serializable{
    
    private Integer id;
    
    private String nombre;
    
    private String apellido;
    
    private Date fecha;
    
    private List<LibroDto> libro;
    
    private DireccionDto direccion;
    
    

    public AutorDto() {
    
    }

    public AutorDto(Integer id, String nombre, String apellido, Date fecha, List<LibroDto> libro, DireccionDto direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.libro = libro;
        this.direccion = direccion;
    }
    
    

    public DireccionDto getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDto direccion) {
        this.direccion = direccion;
    }
    
    

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<LibroDto> getLibro() {
        return libro;
    }

    public void setLibro(List<LibroDto> libro) {
        this.libro = libro;
    }            
}
