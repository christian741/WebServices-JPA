/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import udec.edu.co.Dto.AutorDto;
import udec.edu.co.Entity.Autor;
import udec.edu.co.Excepcion.ParamRequiredException;
import udec.edu.co.Excepcion.ValidationEliminarException;
import udec.edu.co.Service.IAutorService;

/**
 *
 * @author Christian
 */
@Stateless
@Path("/autores")
public class AutorController {
    
    @EJB
    private IAutorService service;
    
    @Path("/listar/{listar}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@PathParam("listar") Integer listar) throws ParamRequiredException  {
        List<AutorDto> listarAutor = service.listar(listar);
        return Response.status(Response.Status.OK).entity(listarAutor).build();       
    }        
    
     @Path("/listarOpcion2/{listar}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarOpcion2(@PathParam("listar") Integer listar)  {
        List<Autor> listarAutor = service.listarOpcion2(listar);
        return Response.status(Response.Status.OK).entity(listarAutor).build();       
    }        

    @Path("/listarOpcion3/{listar}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarOpcion3(@PathParam("listar") Integer listar) throws ParamRequiredException  {
        List<Autor> listarAutor = service.listarOpcion3(listar);
        return Response.status(Response.Status.OK).entity(listarAutor).build();       
    }       
    
     @Path("/listarPaginado/{limite}/{paginas}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPaginado(@PathParam("limite") Integer limite,@PathParam("paginas") Integer paginas) throws ParamRequiredException  {
        List<Autor> listarAutor = service.listarPaginado(limite, paginas);
        return Response.status(Response.Status.OK).entity(listarAutor).build();       
    }       
    
   
    
    @Path("/retornarPorId/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarPorId(@PathParam("id" ) Integer id) throws ObjectNotFoundException {
        Autor autor = service.listarPorId(id);
        return Response.status(Response.Status.OK).entity(autor).build();       
    }      
    
    @Path("/guardar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(@Valid Autor autor) {
        service.guardar(autor);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @Path("/editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@Valid Autor autor) throws ParamRequiredException, ObjectNotFoundException {
        service.editar(autor);
        return Response.status(Response.Status.OK).build();
    }
    
    @Path("/eliminar/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id" ) Integer id) throws ObjectNotFoundException {
        service.eliminar(id);
        return Response.status(Response.Status.NO_CONTENT).build();       
    }     
    
    @Path("/eliminarOpcion2/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarOpcion2(@PathParam("id" ) Integer id) throws ObjectNotFoundException, ValidationEliminarException {
        service.eliminarOpcion2(id);
        return Response.status(Response.Status.NO_CONTENT).build();       
    }     
    
    
    
}
