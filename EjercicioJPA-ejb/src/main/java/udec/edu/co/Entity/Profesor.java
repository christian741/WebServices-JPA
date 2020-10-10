/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author Christian
 */
@Entity
@Table(name = "profesor")

public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Nombre requerido")
    @Size(min = 3, max = 20, message = "Nombre Tamaño Equivocado")
    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;

    @NotNull(message = "Apellido requerido")
    @Size(min = 3, max = 20, message = "Apellido Tamaño Equivocado")
    @Column(name = "apellido", length = 20, nullable = false)
    private String apellido;

    @NotNull(message = "Cedula requerida")
    @Size(min = 9, max = 11, message = "Cedula Tamaño Equivocado")
    @Column(name = "cedula", length = 11, nullable = false)
    private String cedula;

    @NotNull(message = "Edad requerida")
    @Column(name = "edad", nullable = false)
    private short edad;

    public Profesor() {
    }

    public Profesor(long id, String nombre, String apellido, String cedula, short edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

}
