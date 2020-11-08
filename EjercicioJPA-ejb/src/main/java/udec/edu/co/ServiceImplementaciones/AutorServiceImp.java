/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.ServiceImplementaciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import org.modelmapper.ModelMapper;

import udec.edu.co.Dto.AutorDto;
import udec.edu.co.Dto.LibroDto;
import udec.edu.co.Entity.Autor;
import udec.edu.co.Entity.Libro;
import udec.edu.co.Excepcion.ParamRequiredException;
import udec.edu.co.Excepcion.ValidationEliminarException;
import udec.edu.co.Repo.IAutorRepo;
import udec.edu.co.Service.IAutorService;

/**
 *
 * @author ASUS-PC
 */
@Stateless
public class AutorServiceImp implements IAutorService {

    @EJB
    private IAutorRepo repo;

    @Override
    public List<AutorDto> listar(Integer listar) throws ParamRequiredException {

        if (listar == 1) {
            List<Autor> listaAutor = repo.listar();
            List<AutorDto> listaAutorDto = new ArrayList<>();
            for (Autor lista : listaAutor) {
                ModelMapper modelMapper = new ModelMapper();
                AutorDto autorDto = modelMapper.map(lista, AutorDto.class);
                listaAutorDto.add(autorDto);
            }
            for (AutorDto aut : listaAutorDto) {
                aut.setLibro(null);
            }
            return listaAutorDto;

        } else if (listar == 2) {

            List<Autor> listaAutor = repo.listar();
            List<AutorDto> listaAutorDto = new ArrayList<>();
            for (Autor lista : listaAutor) {
                ModelMapper modelMapper = new ModelMapper();
                AutorDto autorDto = modelMapper.map(lista, AutorDto.class);

                ModelMapper modelMapper2 = new ModelMapper();
                List<LibroDto> listaLibroDto = new ArrayList<>();
                for (Libro listalibros : lista.getListaLibros()) {
                    LibroDto libroDto = modelMapper2.map(listalibros, LibroDto.class);
                    listaLibroDto.add(libroDto);
                }
                for (LibroDto auxLibrodto : listaLibroDto) {
                    auxLibrodto.setAutor(null);
                }
                autorDto.setLibro(listaLibroDto);
                
                listaAutorDto.add(autorDto);
            }

            return listaAutorDto;

        } else {
            throw new ParamRequiredException("Se requiere confirmacion de la lista");
        }

    }

    @Override
    public List<Autor> listarOpcion2(Integer listar) {
        //List<Autor> listaAutor = repo.listarOpcion2();
        //List<Autor> listaAutorDto = new ArrayList<>();

        //for (Autor lista : listaAutor) {
        //listaAutorDto.add(lista);
        //}
        return repo.listarOpcion2();
    }

    @Override
    public List<Autor> listarOpcion3(Integer listar) throws ParamRequiredException {

        //if (listar != 1 || listar != 2 || listar == 0) {
        // throw new ParamRequiredException("Se requiere confirmacion de la lista");
        //}
        if (listar == 1) {
            List<Autor> listaAutor = repo.listarOpcion3();
            for (Autor lista : listaAutor) {
                lista.setListaLibros(null);
            }
            return listaAutor;

        } else if (listar == 2) {
            List<Autor> listaAutor = repo.listarOpcion3();
            return listaAutor;
        } else {
            throw new ParamRequiredException("Se requiere confirmacion de la lista");
        }

    }

    @Override
    public Autor listarPorId(Integer id) throws ObjectNotFoundException {
        Autor autor = repo.listarPorId(id);
        if (autor == null) {
            throw new ObjectNotFoundException("Autor no existe.");
        } else {
            return autor;
        }
    }

    @Override
    public void guardar(Autor autor) {

        if (autor.getListaLibros() != null) {
            for (Libro libro : autor.getListaLibros()) {
                libro.setAutor(autor);
            }
        }
        repo.guardar(autor);
    }

    @Override
    public void editar(Autor autor) throws ParamRequiredException, ObjectNotFoundException {
        if (autor.getId() == null) {
            throw new ParamRequiredException("Id es requerido para edición");
        } else {
            Autor autorAux = repo.listarPorId(autor.getId());

            if (autorAux == null) {
                throw new ObjectNotFoundException("Autor no existe.");
            }

            autorAux.setApellido(autor.getApellido());
            autorAux.setNombre(autor.getNombre());
            autorAux.setFecha(autor.getFecha());

            repo.editar(autorAux);
        }
    }

    @Override
    public void eliminar(Integer id) throws ObjectNotFoundException {
        Autor autor = repo.listarPorId(id);
        if (autor == null) {
            throw new ObjectNotFoundException("Autor no existe.");
        }

        repo.eliminar(autor);
    }

    @Override
    public void eliminarOpcion2(Integer id) throws ObjectNotFoundException, ValidationEliminarException {
        Autor autor = repo.listarPorId(id);

        if (autor == null) {
            throw new ObjectNotFoundException("Autor no existe.");
        }
        if (!autor.getListaLibros().isEmpty()) {
            throw new ValidationEliminarException("Elimine Por Favor sus libros");
        }

        repo.eliminar(autor);
    }

}
