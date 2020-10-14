/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.ServiceImplementaciones;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.ejb.EJB;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;

import udec.edu.co.Entity.Profesor;
import udec.edu.co.Excepcion.ParamRequiredException;
import udec.edu.co.Excepcion.ParamUsedException;
import udec.edu.co.Pojo.ErrorWraper;
import udec.edu.co.Pojo.Mensaje;
import udec.edu.co.Repo.IProfesorRepo;
import udec.edu.co.Service.IProfesorService;

/**
 * Clase encargada de la logica pesada
 *
 * @author Christian
 */
@Stateless
public class ProfesorServiceImplementaciones implements IProfesorService {

    //Llama por inyeccion a la capa repo de la BD
    @EJB
    private IProfesorRepo repo;

    @Override
    public Mensaje insertar(Profesor profesor)throws ParamRequiredException{
        if (repo.validarCedulaRegistro(profesor.getCedula())!=0) {
            throw new ParamRequiredException("Cedula ya se encuentra Registrada");
        }
        if(repo.validarCorreoRegistro(profesor.getCorreo())!=0){
            throw new ParamRequiredException("Correo ya se encuentra Registrado");
        }
        this.repo.insertar(profesor);
        return new Mensaje(new ErrorWraper("Insertado Correctamente", "204", "Created"),null);
    }

    @Override
    public Mensaje editar(Profesor profesor) throws ParamRequiredException,ParamUsedException , ObjectNotFoundException{
        if(profesor.getId()== null){
            throw new ParamRequiredException("Id es requerido para edición");
        }else {
            Profesor profesor1 = this.traerId(profesor.getId()); 
            this.validarCamposEdicion(profesor1);
            repo.editar(profesor);
        }    
        return  new Mensaje(new ErrorWraper("Modificado Correctamente", "200", "Ok"),null);
    }

    @Override
    public Mensaje eliminar(String cedula) throws ObjectNotFoundException{
        Profesor profesor = this.traerPorCedula(cedula);
        repo.eliminar(profesor);
        return new Mensaje(new ErrorWraper("Eliminado Correctaente","204", "NoContent"),null);
    }
      @Override
    public Mensaje eliminarPorId(Integer id) throws ObjectNotFoundException {
        Profesor profesor = this.traerId(id);
        repo.eliminar(profesor);
        return new Mensaje(new ErrorWraper("Eliminado Correctaente","204", "NoContent"),null);
    }

    @Override
    public Profesor traerPorCedula(String cedula) {
       return repo.listarPorCedula(cedula);
    }

    @Override
    public List<Profesor> traerTodos() throws ObjectNotFoundException{
        List<Profesor> listaProfesor =  repo.listarTodos();
         
        if(listaProfesor.isEmpty()){
           throw new ObjectNotFoundException("No hay nada en la lista");
        }else{
           return listaProfesor;
        }
        
    }

    @Override
    public Profesor traerId(Integer id)  throws ObjectNotFoundException {
        Profesor profesor = repo.listarPorId(id);
        if(profesor != null) 
            return profesor;
        else
            throw new ObjectNotFoundException("No se encontro el id.");

    }
   
    
    private void validarCamposEdicion(Profesor profesor) throws ParamUsedException{
            Integer validacion = repo.validarCedula(profesor.getCedula(), profesor.getId());
            System.out.println(validacion);
            if(validacion != 0)
                throw new ParamUsedException("Cédula ya se encuentra registrada");
    
            validacion = repo.validarCorreo(profesor.getCorreo(), profesor.getId());
            if(validacion != 0)
                throw new ParamUsedException("Correo ya se encuentra registradao");            
    }  

  
    
    

  
     
 
}
