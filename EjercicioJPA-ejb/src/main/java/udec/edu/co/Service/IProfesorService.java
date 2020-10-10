/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Service;

import javax.ejb.Local;
import udec.edu.co.Entity.Profesor;
import udec.edu.co.Pojo.Mensaje;

/**
 *
 * @author Christian
 */
@Local
public interface IProfesorService {
    
    public Mensaje insertarProfesor(Profesor profesor);
    public Mensaje editarProfesor(Profesor profesor);
    public Mensaje eliminarProfesor(long id);
    public Mensaje traerUsuario(long id);
    public Mensaje traerUsuarios();
}
