/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author Christian
 */
@Entity
@Table(name = "profesor")
@NamedQueries({
    // Name por buena practica colocar la clase entity despues.
    // FROM escoger La entity Profesor no la de base de datos
    @NamedQuery(name = "Profesor.listarTodo", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.validarCedula", query = "SELECT COUNT(p.cedula)  FROM Profesor p WHERE p.cedula = :cedula AND p.id <> :id"),
    @NamedQuery(name = "Profesor.validarCorreo", query = "SELECT COUNT(p.correo)  FROM Profesor p WHERE p.correo = :correo AND p.id <> :id"),
    @NamedQuery(name = "Profesor.validarCorreoRegistro", query = "SELECT COUNT(p.correo)  FROM Profesor p WHERE p.correo = :correo"),
    @NamedQuery(name = "Profesor.validarCedulaRegistro", query = "SELECT COUNT(p.cedula)  FROM Profesor p WHERE p.cedula = :cedula"),
    @NamedQuery(name = "Profesor.listarPorCedula", query = "SELECT p FROM Profesor p WHERE p.cedula= :cedula")
})
public class Profesor implements Serializable {

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

    @NotNull(message = "Cedula requerida")
    @Size(min = 9, max = 11, message = "Cedula Tamaño Equivocado")
    @Column(name = "cedula", length = 11, nullable = false)
    private String cedula;

    @NotNull(message = "Edad requerida")
    @Column(name = "edad", nullable = false)
    private short edad;

    @NotNull(message = "Correo requerida")
    @Size(min = 5, max = 40, message = "Correo Tamaño Equivocado")
    @Column(name = "correo", length = 40, nullable = false)
    private String correo;

    @NotNull(message = "Fecha requerida")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    public Profesor() {
    }

    public Profesor(Integer id, String nombre, String apellido, String cedula, short edad, String correo, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }
   
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
