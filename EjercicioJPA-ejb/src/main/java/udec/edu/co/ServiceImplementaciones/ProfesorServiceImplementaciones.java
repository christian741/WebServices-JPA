/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.ServiceImplementaciones;

import java.util.ArrayList;
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
    public Mensaje insertar(Profesor profesor) {
        this.repo.insertar(profesor);
        return new Mensaje(new ErrorWraper("Se ha creado Correctamente", "200", "Created"), null);
    }

    @Override
    public Mensaje editar(Profesor profesor) throws ParamRequiredException,ParamUsedException , ObjectNotFoundException{
        if(profesor.getId()== null){
            throw new ParamRequiredException("Id es requerido para edición");
        }else {
            this.traerId(profesor.getId()); 
            this.validarCamposEdicion(profesor);
            repo.editar(profesor);
        }    
        return new Mensaje(new ErrorWraper("Se ha editado Correctamente", "202", "Modifed"), null);
    }

    @Override
    public Mensaje eliminar(Integer cedula) throws ObjectNotFoundException{
        Mensaje mensaje = this.traerId(cedula);
        Profesor profesor = (Profesor) mensaje.getObjeto().get(0);
        repo.eliminar(profesor);
        return new Mensaje(new ErrorWraper("Se ha eliminado Correctamente", "202", "Modifed"), null);
    }

    @Override
    public Mensaje traerPorCedula(Integer cedula) {
       return new Mensaje(new ErrorWraper("No ha cambiado esta", "202", "Modifed"), null);
    }

    @Override
    public Mensaje traerTodos() {
        ArrayList<Profesor> listaProfesor = (ArrayList<Profesor>) repo.listarTodos();
        Mensaje mensaje = new Mensaje(new ErrorWraper("Se ha creado Correctamente", "200", "Created"), castLista(listaProfesor));
        return mensaje;
    }

    @Override
    public Mensaje traerId(Integer id)  throws ObjectNotFoundException {
        Profesor profesor = repo.listarPorId(id);
        if(profesor != null) 
            return new Mensaje(new ErrorWraper("Busqueda correcta", "200", "Created"),castObjeto(profesor));
        else
            throw new ObjectNotFoundException("Profesor no existe.");

    }
    
    /**
     * Castear Lista a Objetos A Profesores
     * @param listaVieja
     * @return 
     */
    private ArrayList<Object> castLista(ArrayList<Profesor> listaVieja) {
        
        ArrayList<Object> nuevaListaCasteada = new ArrayList<>();
        for (Profesor listObject : listaVieja) {
            nuevaListaCasteada.add((Object) listObject);
        }
        return nuevaListaCasteada;
    }

    private ArrayList<Object> castObjeto(Profesor profesor){
        ArrayList<Object> nuevaListaCasteada = new ArrayList<>();
        nuevaListaCasteada.add(profesor);
        return nuevaListaCasteada;
    }
    
    private void validarCamposEdicion(Profesor profesor) throws ParamUsedException{
            Integer validacion = repo.validarCedula(profesor.getCedula(), profesor.getId());
            if(validacion != 0)
                throw new ParamUsedException("Cédula ya se encuentra registrada");
    
            validacion = repo.validarCorreo(profesor.getCorreo(), profesor.getId());
            if(validacion != 0)
                throw new ParamUsedException("Correo ya se encuentra registradao");            
    }  
}
