/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Repo;


import java.util.List;
import javax.ejb.Local;
import udec.edu.co.Entity.Autor;

/**
 *
 * @author ASUS-PC
 */
@Local
public interface IAutorRepo {
    
    public List<Autor> listar();
    
    public List<Autor> listarOpcion2();

    public List<Autor> listarOpcion3();
    
    public Integer contarAutor();
    
    public List<Autor> listarPaginado(Integer limite,Integer lugar);
    
    public Autor listarPorId(Integer id);
    
    public void guardar(Autor autor);
    
    public void editar(Autor autor);
   
    public void eliminar(Autor autor);

    
    
    
}
