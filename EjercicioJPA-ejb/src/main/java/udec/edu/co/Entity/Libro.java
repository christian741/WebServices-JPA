/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Entity;

import org.codehaus.jackson.annotate.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

/**
 * @OneToOne – Default fetch type is EAGER
 * @OneToMany – Default fetch type is LAZY.
 * @ManyToOne – Default fetch type is EAGER.
 * @ManyToMany – Default fetch type is LAZY.
 * @ElementCollection – Default fetch type is EAGER.
 * @author Christian
 */
@Entity
@Table(name = "libro")
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Nombre requerido")
    @Size(min = 3, max = 20, message = "Nombre Tamaño Equivocado")
    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;

    @NotNull(message = "Editorial requerida")
    @Size(min = 3, max = 20, message = "Editorial Tamaño Equivocado")
    @Column(name = "editorial", length = 20, nullable = false)
    private String editorial;

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    //Hace que no se llame inversamente otra clase
    @XmlInverseReference(mappedBy="listaLibros")
    private Autor autor;

    public Libro() {
    }

    public Libro(Integer id, String nombre, String editorial, Autor autor) {
        this.id = id;
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
    }

  

   

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @JsonIgnore
    public Autor getAutor() {
        return autor;
    }
    public String getEditorial() {
        return editorial;
    }

}
