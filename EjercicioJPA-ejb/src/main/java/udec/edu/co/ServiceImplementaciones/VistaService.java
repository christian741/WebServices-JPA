/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.ServiceImplementaciones;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import udec.edu.co.Entity.Vista;
import udec.edu.co.Repo.IVistaRepo;
import udec.edu.co.Service.IVistaService;

/**
 *
 * @author Christian
 */
@Stateless
public class VistaService implements IVistaService{
    
     @EJB
    private IVistaRepo repo;

    @Override
    public Vista listarPorId(Integer id) {
        Vista vista = repo.listarPorId(id);
         return vista;
    }
    @Override
    public List<Vista> listar(){
          return repo.listar();
          
    }
    @Override
     public List<Vista> listar2(){
          return repo.listar2();
          
    }

   
}
