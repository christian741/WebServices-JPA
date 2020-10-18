/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.ServiceImplementaciones;


import java.util.List;
import javax.ejb.EJB;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import udec.edu.co.Entity.Autor;
import udec.edu.co.Entity.Libro;
import udec.edu.co.Repo.IAutorRepo;
import udec.edu.co.Service.IAutorService;

/**
 *
 * @author ASUS-PC
 */
@Stateless
public class AutorServiceImp implements IAutorService{

    @EJB
    private IAutorRepo repo;
    
    @Override
    public List<Autor> listar() {
        return repo.listar();        
    }

    @Override
    public Autor listarPorId(Integer id) throws  ObjectNotFoundException{
        Autor autor = repo.listarPorId(id);
        if(autor == null)
            throw new ObjectNotFoundException("Autor no existe.");
        else
            return autor;
    }

    @Override
    public void guardar(Autor autor) {
        if(autor.getListaLibros()!= null) {
            for(Libro libro: autor.getListaLibros()) {
                libro.setAutor(autor);
            }
        }
        repo.guardar(autor);
    }

    @Override
    public void editar(Autor autor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) throws  ObjectNotFoundException {
        Autor autor = this.listarPorId(id);
        repo.eliminar(autor);
    }

   
    
}
