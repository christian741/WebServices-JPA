/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.ServiceImplementaciones;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import org.modelmapper.ModelMapper;
import udec.edu.co.Dto.LibroDto;
import udec.edu.co.Entity.Autor;
import udec.edu.co.Entity.Libro;
import udec.edu.co.Excepcion.ParamRequiredException;
import udec.edu.co.Repo.ILibroRepo;
import udec.edu.co.Service.ILibroService;

/**
 *
 * @author ASUS-PC
 */
@Stateless
public class LibroServiceImpl implements ILibroService {

    @EJB
    private ILibroRepo repo;
    
    @Override
    public List<LibroDto> listar() {
        List<Libro> listaLibro = repo.listar();
        List<LibroDto> libroDto = new ArrayList<>();
        
        for (Libro libro: listaLibro) {
            ModelMapper modelMapper = new ModelMapper();
            LibroDto dto = modelMapper.map(libro, LibroDto.class);   
            libroDto.add(dto);            
        }
        
        for (LibroDto dto : libroDto) {
            //dto.setAutor(null);
            dto.getAutor().getLibro().clear();
        }
        
        return libroDto;
    }

    @Override
    public LibroDto listarPorId(Integer id) throws ObjectNotFoundException {
        Libro libro =  repo.listarPorId(id);
        
        if(libro == null)
            throw new ObjectNotFoundException("Libro no existe.");
        
        ModelMapper modelMapper = new ModelMapper();
        LibroDto dto = modelMapper.map(libro, LibroDto.class);   
        
        //dto.setAutor(null);
        dto.getAutor().getLibro().clear();
        
        return dto;
    }

    @Override
    public void guardar(Libro libro)throws ParamRequiredException{
        
        if(libro.getAutor()==null)
            throw new ParamRequiredException("Se requiere el Id del Autor");
        repo.guardar(libro);
    }

    @Override
    public void editar(Libro libro) throws ParamRequiredException,ObjectNotFoundException{
        if(libro.getId() == null)    
            throw new ParamRequiredException("Id es requerido para edición");
        else {
            Libro libroAux = repo.listarPorId(libro.getId());
            
            if(libroAux == null)
                throw new ObjectNotFoundException("Autor no existe.");
            
            libroAux.setNombre(libro.getNombre());
            libroAux.setEditorial(libro.getEditorial());
                    
            repo.editar(libroAux);
        }
    }

    @Override
    public void eliminar(Integer id)throws ObjectNotFoundException{
        
        Libro libro = repo.listarPorId(id);
        if (libro == null) {
            throw new ObjectNotFoundException("Libro no existe.");
        }
        repo.eliminar(libro);
    }

    
    
}
