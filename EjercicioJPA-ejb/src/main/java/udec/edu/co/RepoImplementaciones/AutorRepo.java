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
import udec.edu.co.Entity.Autor;
import udec.edu.co.Repo.IAutorRepo;

/**
 *
 * @author ASUS-PC
 */
@Stateless
public class AutorRepo implements IAutorRepo{
    
    @PersistenceContext(unitName = "co.edu.unicundi_proyectoEAR-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;

    @Override
    public List<Autor> listar() {
        TypedQuery<Autor> listaAutor = this.entity.createNamedQuery("Profesor.listarTodo", Autor.class);                
        return listaAutor.getResultList();        
    }

    @Override
    public Autor listarPorId(Integer id) {
        return this.entity.find(Autor.class, id);
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
