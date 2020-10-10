/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.ServiceImplementaciones;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import udec.edu.co.Entity.Profesor;
import udec.edu.co.Pojo.ErrorWraper;
import udec.edu.co.Pojo.Mensaje;
import udec.edu.co.Repo.IProfesorRepo;
import udec.edu.co.Service.IProfesorService;

/**
 * Clase encargada de la logica pesada
 * @author Christian
 */
@Stateless
public class ProfesorServiceImplementaciones implements IProfesorService{

    //Llama por inyeccion a la capa repo de la BD
    @EJB
    private IProfesorRepo repo;

    @Override
    public Mensaje insertar(Profesor profesor) {
        this.repo.insertar(profesor);
        return new Mensaje(new ErrorWraper("Se ha creado Correctamente","200","Created"), null);
    }

    @Override
    public Mensaje editar(Profesor profesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mensaje eliminar(Integer cedula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mensaje traerPorCedula(Integer cedula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mensaje traerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    


   
}
