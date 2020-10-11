/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Service;

import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import udec.edu.co.Entity.Profesor;
import udec.edu.co.Excepcion.ParamRequiredException;
import udec.edu.co.Excepcion.ParamUsedException;
import udec.edu.co.Pojo.Mensaje;

/**
 *
 * @author Christian
 */
@Local
public interface IProfesorService {
    
    public Mensaje insertar(Profesor profesor);
    public Mensaje editar(Profesor profesor)throws ParamRequiredException,ParamUsedException,ObjectNotFoundException;
    public Mensaje eliminar(Integer cedula)throws ObjectNotFoundException;
    public Mensaje traerPorCedula(Integer cedula);
    public Mensaje traerTodos();
    public Mensaje traerId(Integer id) throws ObjectNotFoundException;
}
