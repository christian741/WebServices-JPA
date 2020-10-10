/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Implementaciones;

import javax.ejb.Stateless;
import udec.edu.co.Entity.Profesor;
import udec.edu.co.Pojo.Mensaje;
import udec.edu.co.Service.IProfesorService;

/**
 *
 * @author Christian
 */
@Stateless
public class ProfesorServiceImplementaciones implements IProfesorService{

    @Override
    public Mensaje insertarProfesor(Profesor profesor) {
        return null;
    }

    @Override
    public Mensaje editarProfesor(Profesor profesor) {
        return null;
    }

    @Override
    public Mensaje eliminarProfesor(long id) {
        return null;
    }

    @Override
    public Mensaje traerUsuario(long id) {
        return null;
    }

    @Override
    public Mensaje traerUsuarios() {
        return null;
    }

    
   
}
