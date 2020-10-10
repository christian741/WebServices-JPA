/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Repo;

import java.util.List;
import javax.ejb.Local;
import udec.edu.co.Entity.Profesor;

/**
 *
 * @author Christian
 */
@Local
public interface IProfesorRepo {
    
    public List<Profesor> listarProfesor();
    public Profesor listarId(Integer id);
    public void guardar(Profesor profesor);
    public void eliminar(Integer id);
    public void editar(Profesor profesor);
    
    
}
