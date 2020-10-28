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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import udec.edu.co.Dto.LibroDto;
import udec.edu.co.Service.ILibroService;

/**
 *
 * @author ASUS-PC
 */
@Stateless
@Path("/libros")
public class LibroController {

    @EJB
    private ILibroService service;
    
    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar()  {
        List<LibroDto> listarLibro = service.listar();
        return Response.status(Response.Status.OK).entity(listarLibro).build();       
    }        

    @Path("/retornarPorId/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarPorId(@PathParam("id" ) Integer id) throws ObjectNotFoundException {
        LibroDto libro = service.listarPorId(id);
        return Response.status(Response.Status.OK).entity(libro).build();       
    }      
    
    
}
