/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Service;


import java.util.List;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import udec.edu.co.Dto.LibroDto;
import udec.edu.co.Entity.Libro;
import udec.edu.co.Excepcion.ParamRequiredException;

/**
 *
 * @author ASUS-PC
 */
@Local
public interface ILibroService {
    
    public List<LibroDto> listar();
        
    public LibroDto listarPorId(Integer id) throws ObjectNotFoundException;
    
    public void guardar(Libro libro)throws ParamRequiredException;
    
    public void editar(Libro libro)throws ParamRequiredException,ObjectNotFoundException;
   
    public void eliminar(Integer id)throws ObjectNotFoundException;
    
}
