/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Repo;

import java.util.List;
import javax.ejb.Local;
import udec.edu.co.Entity.Autor;
import udec.edu.co.Entity.Vista;

/**
 *
 * @author Christian
 */
@Local
public interface IVistaRepo {
    
     public Vista listarPorId(Integer id);
     
     public List<Vista> listar();
     public List<Vista> listar2();
     
    
}
