/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.RepoImplementaciones;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import udec.edu.co.Entity.Autor;
import udec.edu.co.Repo.IAutorRepo;

/**
 *
 * @author ASUS-PC
 */
@Stateless
public class AutorRepo implements IAutorRepo {

    //@PersistenceContext(unitName = "udec.edu.co_EjercicioJPA-ejb_ejb_1.0-SNAPSHOTPU",synchronization = SynchronizationType.UNSYNCHRONIZED)
    @PersistenceContext(unitName = "udec.edu.co_EjercicioJPA-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;
    //private EntityTransaction tx;
    //private EntityManagerFactory emf;
    //private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("udec.edu.co_EjercicioJPA-ejb_ejb_1.0-SNAPSHOTPU");
    //private EntityManager entitymanager = emfactory.createEntityManager( );
   
     @Override
    public List<Autor> listar() {
        this.entity.getEntityManagerFactory().getCache().evictAll();
        TypedQuery<Autor> listaAutor = this.entity.createNamedQuery("Autor.listarTodo", Autor.class);                
        return listaAutor.getResultList();        
    }
    
     @Override
    public List<Autor> listarOpcion2() {
        this.entity.getEntityManagerFactory().getCache().evictAll();
        TypedQuery<Autor> listaAutor = this.entity.createNamedQuery("Autor.listarSoloAutor", Autor.class);                
        return listaAutor.getResultList();        
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Autor> listarOpcion3() {
        TypedQuery<Autor> listaAutor = this.entity.createNamedQuery("Autor.listarTodo", Autor.class);                
        return listaAutor.getResultList();                
    }
    
    @Override
    public List<Autor> listarOpcion4() {
         Query q = this.entity.createNativeQuery("select id, nombre, apellido from public.autor", Autor.class);
         return q.getResultList();
    }    

    @Override
    //@Transactional(Transactional.TxType.SUPPORTS)
    public Autor listarPorId(Integer id) {
        //EntityManager entity = emf.createEntityManager();
        Autor autor;
        //try {
            //entitymanager.getTransaction().begin();
            //autor = this.entitymanager.find(Autor.class, id);
             autor = this.entity.find(Autor.class, id);
            //autor = entity.find(Autor.class, id);
            //entitymanager.getTransaction().commit();
            //entitymanager.close();
            //emfactory.close();
            return autor;
            
        //} catch (Exception e) {
            //entity.getTransaction().rollback();
        //}
    }

    @Override
    public void guardar(Autor autor) {
        this.entity.persist(autor);
    }

    @Override
    public void editar(Autor autor) {
        this.entity.merge(autor);
    }

    @Override
    public void eliminar(Autor autor) {
        this.entity.remove(autor);
    }

  
}
