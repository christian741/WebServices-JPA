/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Christian
 */
@Entity
@Table(name = "autor")
@NamedQueries({
    @NamedQuery(name = "Autor.listarTodo", query = "SELECT a FROM Autor a"),
    @NamedQuery(name = "Autor.listarSoloAutor", query = "SELECT a.id, a.nombre, a.apellido, a.fecha FROM Autor a")
})

/*@NamedNativeQueries({
    @NamedNativeQuery(name = "Autor.listarTodoConsultaNativo", query = "select a.id, a.nombre, a.apellido, a.fecha from public.autor a", resultClass = Autor.class)
})*/
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "Nombre requerido")
    @Size(min = 3, max = 20, message = "Nombre Tamaño Equivocado")
    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;

    @NotNull(message = "Apellido requerido")
    @Size(min = 3, max = 20, message = "Apellido Tamaño Equivocado")
    @Column(name = "apellido", length = 20, nullable = false)
    private String apellido;
    
    @Temporal(TemporalType.TIMESTAMP)
    @JsonbDateFormat(value = "dd-mm-yyyy",locale = "es")
    private LocalDate fecha;
    
    //Lazy se encarga de traer una
    //Eager se encarga de todo
    @OneToMany(mappedBy = "autor" ,cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Libro> listaLibros;

    public Autor() {
    }

    public Autor(Integer id, String nombre, String apellido, LocalDate fecha, List<Libro> listaLibros) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.listaLibros = listaLibros;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

  
    
}
