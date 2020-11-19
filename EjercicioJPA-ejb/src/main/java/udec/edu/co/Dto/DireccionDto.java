/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Dto;

/**
 *
 * @author Christian
 */
public class DireccionDto {
   
    private Integer id;
    
    private String direccion;
    
    private String barrio;
    
    private AutorDto autor;

    public DireccionDto(Integer id, String direccion, String barrio, AutorDto autor) {
        this.id = id;
        this.direccion = direccion;
        this.barrio = barrio;
        this.autor = autor;
    }

    public AutorDto getAutor() {
        return autor;
    }

    public void setAutor(AutorDto autor) {
        this.autor = autor;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
     
   
}
