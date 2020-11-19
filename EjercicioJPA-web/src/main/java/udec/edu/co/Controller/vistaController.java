/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import udec.edu.co.Dto.AutorDto;
import udec.edu.co.Entity.Vista;

import udec.edu.co.Excepcion.ParamRequiredException;
import udec.edu.co.Service.IVistaService;

/**
 *
 * @author Christian
 */
@Stateless
@Path("/vista")
public class vistaController {
    
    
    @EJB
    private IVistaService service;
    
    @Path("/listarId/{listar}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarId(@PathParam("listar") Integer listar) throws ParamRequiredException  {
        Vista vista = service.listarPorId(listar);
        return Response.status(Response.Status.OK).entity(vista).build();          
    }    
    
    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() throws ParamRequiredException  {
        List<Vista> vista = service.listar();
        return Response.status(Response.Status.OK).entity(vista).build();          
    }    
    
    
    @Path("/listar2")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar2() throws ParamRequiredException  {
        List<Vista> vista = service.listar2();
        return Response.status(Response.Status.OK).entity(vista).build();          
    }    
    
}
