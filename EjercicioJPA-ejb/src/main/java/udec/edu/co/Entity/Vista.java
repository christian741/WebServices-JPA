/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import jdk.nashorn.internal.ir.annotations.Immutable;


/**
 *
 * @author Christian
 */
@Entity
@Immutable
/*@NamedQueries({
    @NamedQuery(name = "Vista.listarVista2", query = "SELECT * FROM prueba_3"),
})*/

@NamedNativeQueries({
    @NamedNativeQuery(name = "Vista.listarVista", query = "select * from public.vista()", resultClass = Vista.class)
    //@NamedNativeQuery(name = "Vista.listarVista", query = "select * from public.prueba3", resultClass = Vista.class)


})
public class Vista implements Serializable {
    
   
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    
  
    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;

    
    @Column(name = "apellido", length = 20, nullable = false)
    private String apellido;
    
    @Temporal(TemporalType.TIMESTAMP)
    @JsonbDateFormat(value = "dd-mm-yyyy",locale = "es")
    private LocalDate fecha;
    
    @Column(name = "barrio", length = 20, nullable = false)
    private String barrio;

    
    @Column(name = "direccion", length = 20, nullable = false)
    private String direccion;
    
    @Column(name = "autor_id", length = 20, nullable = false)
    private Integer autor_id;

    
    @Column(name = "count", length = 20, nullable = false)
    private Integer count;

 
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(Integer autor_id) {
        this.autor_id = autor_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
    
    
    
}
