/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

/**
 *
 * @author Christian
 */
@Entity
@Table(name = "direccion")
public class Direccion {
    
    @Id
    private Integer id;

    @NotNull(message = "Direccion requerido")
    @Size(min = 3, max = 50, message = "Direccion Tamaño Equivocado")
    @Column(name = "direccion", length = 20, nullable = false)
    private String direccion;
    
    @NotNull(message = "Barrio requerido")
    @Size(min = 3, max = 30, message = "Barrio Tamaño Equivocado")
    @Column(name = "barrio", length = 20, nullable = false)
    private String barrio;
     
    @OneToOne
    @MapsId
    @XmlInverseReference(mappedBy="direccion")
    private Autor autor;

    public Direccion() {
    }

    public Direccion(Integer id, String direccion, String barrio, Autor autor) {
        this.id = id;
        this.direccion = direccion;
        this.barrio = barrio;
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
    @JsonIgnore
     
    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    
    
    
}
