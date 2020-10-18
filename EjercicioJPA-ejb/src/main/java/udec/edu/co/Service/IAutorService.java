/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Service;


import java.util.List;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import udec.edu.co.Entity.Autor;

/**
 *
 * @author ASUS-PC
 */
@Local
public interface IAutorService {
    
    public List<Autor> listar();
    
    public Autor listarPorId(Integer id) throws ObjectNotFoundException;
    
    public void guardar(Autor autor);
    
    public void editar(Autor autor);
   
    public void eliminar(Integer id) throws  ObjectNotFoundException;
    
    
}
