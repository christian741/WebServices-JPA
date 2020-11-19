/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.RepoImplementaciones;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import udec.edu.co.Entity.Libro;
import udec.edu.co.Repo.AbstractFacade;
import udec.edu.co.Repo.ILibroRepo;

/**
 *
 * @author ASUS-PC
 */
@Stateless
public class LibroRepoImpl extends AbstractFacade<Libro, Integer> implements ILibroRepo{
    
    @PersistenceContext(unitName = "udec.edu.co_EjercicioJPA-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;

    public LibroRepoImpl() {
        super(Libro.class);
    }
    

    @Override
    public List<Libro> listar() {
        this.entity.getEntityManagerFactory().getCache().evictAll();
        TypedQuery<Libro> listaAutor = this.entity.createNamedQuery("Libro.listarTodo", Libro.class);                
        return listaAutor.getResultList();        
    }

    @Override
    public Libro listarPorId(Integer id) {
        return this.entity.find(Libro.class, id);
    }

    @Override
    public void guardar(Libro libro) {
        this.entity.persist(libro);
    }

    @Override
    public void editar(Libro libro) {
            this.entity.merge(libro);
    }

    @Override
    public void eliminar(Libro libro) {
        this.entity.remove(libro);
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
