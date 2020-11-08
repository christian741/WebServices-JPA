/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import udec.edu.co.Entity.Libro;

/**
 *
 * @author Christian
 */
public abstract class AbstractFacade<T, V> {

    private Class<T> entityClass;
    public AbstractFacade(Class<T> entityClass ){
        this.entityClass = entityClass;
    }
    protected abstract EntityManager getEntityManager();
    protected abstract String getQuery();
    
   /* private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }*/
    
    
    public List<T> listar() {
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        //TypedQuery<Libro> listaAutor = this.entity.createNamedQuery("Libro.listarTodo", Libro.class);  
        TypedQuery<T> lista = getEntityManager().createNamedQuery(this.getQuery(), entityClass);                
        return lista.getResultList();     
        //Tarea
    }

    public T listarPorId(V id) {
        return getEntityManager().find(entityClass, id);
    }

    public void guardar(T entity) {
        getEntityManager().persist(entity);
    }

    public void editar(T entity) {
        getEntityManager().merge(entity);
    }

    public void eliminar(T entity) {
        getEntityManager().remove(entity);
    }

}
