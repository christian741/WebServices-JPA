/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.RepoImplementaciones;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import udec.edu.co.Entity.Profesor;
import udec.edu.co.Repo.IProfesorRepo;

/**
 *
 * @author Christian
 */
public class ProfesorRepoImplementacion implements IProfesorRepo {

    //Llamar a persistencia que se conecta con el pool de glashfish
    @PersistenceContext(unitName = "udec.edu.co_EjercicioJPA-ejb_ejb_1.0-SNAPSHOTPU")
    //Factory que se encarga de las operaciones en Base de Datos
    private EntityManager entity;

    @Override
    public List<Profesor> listarTodos() {
        TypedQuery<Profesor> listaProfesor = this.entity.createNamedQuery("profesor.listarTodo", Profesor.class);                
        return listaProfesor.getResultList();
    }

    @Override
    public Profesor listarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(Profesor profesor) {
       this.entity.persist(profesor);
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Profesor profesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer validarCedula(String cedula, Integer id) {
        Query query = this.entity.createNamedQuery("Profesor.validarCedula");
        query.setParameter("cedula", cedula);
        query.setParameter("id", id);
        return (Integer) query.getSingleResult();
    }

    @Override
    public Integer validarCorreo(String correo, Integer id) {
        Query query = this.entity.createNamedQuery("Profesor.validarCorreo");
        query.setParameter("correo", correo);
        query.setParameter("id", id);
        return (Integer) query.getSingleResult();
    }
    

}
