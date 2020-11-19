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
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import udec.edu.co.Entity.Vista;
import udec.edu.co.Repo.IVistaRepo;

/**
 *
 * @author Christian
 */
@Stateless
public class VistaRepoImpl implements IVistaRepo{
    
    @PersistenceContext(unitName = "udec.edu.co_EjercicioJPA-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;

    @Override
    public Vista listarPorId(Integer id) {
       
        this.entity.getEntityManagerFactory().getCache().evictAll();
        Query query  = this.entity.createNamedQuery("Select * from prueba_3", Vista.class);  
        query.setParameter("id", id);
        return (Vista) query.getSingleResult();  
    }

    @Override
    public List<Vista> listar() {
        
        this.entity.getEntityManagerFactory().getCache().evictAll();
        Query vista =   this.entity.createNativeQuery("Vista.listarVista");  
        //query.setParameter("id", id);
        return vista.getResultList();
    }
    
    @Override
      public List<Vista> listar2() {
        
        this.entity.getEntityManagerFactory().getCache().evictAll();
        TypedQuery<Vista> vista =   this.entity.createNamedQuery("Vista.listarVista",Vista.class);  
        //query.setParameter("id", id);
        return vista.getResultList();
    }
    
}
