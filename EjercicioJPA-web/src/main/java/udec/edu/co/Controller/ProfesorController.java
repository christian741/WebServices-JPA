/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Controller;

//imports EJB
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import udec.edu.co.Entity.Profesor;
import udec.edu.co.Pojo.Mensaje;

//Imports de Validaciones
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//Imports de Servicios
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
import udec.edu.co.Excepcion.ParamRequiredException;
import udec.edu.co.Excepcion.ParamUsedException;
import udec.edu.co.Service.IProfesorService;

/**
 *
 * @author Christian
 */
@Stateless
@Path("/profesores")
public class ProfesorController {

    @EJB
    private IProfesorService service;

    @Path("/insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON) //Trae Respuesta
    @Consumes(MediaType.APPLICATION_JSON) //Consume algo
    public Response insertar(@Valid Profesor profesor) throws ParamRequiredException {
        Mensaje mensaje = service.insertar(profesor);
        return Response.status(Response.Status.CREATED).entity(mensaje).build();
    }

    @Path("/editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@Valid Profesor profesor) throws ParamRequiredException, ParamUsedException, ObjectNotFoundException {
        Mensaje mensaje = service.editar(profesor);
        return Response.status(Response.Status.OK).entity(mensaje).build();
    }

    /**
     * ______________________________________________________________________________
     *
     * NO VALIDADO POR URL
     * ______________________________________________________________________________
     *
     * @param cedula
     * @return
     */
    @Path("/retornarPorCedulaN/{cedula}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response traerPorCedula(@PathParam("cedula") String cedula) throws ObjectNotFoundException {
       Profesor profesor = service.traerPorCedula(cedula);
        return Response.status(Response.Status.OK).entity(profesor).build();
    }

    /**
     * ______________________________________________________________________________
     *
     * VALIDADO POR URL
     * ______________________________________________________________________________
     *
     * @param cedula
     * @return
     */
    @Path("/retornarPorCedulaV/{cedula}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response retornarPorCedula(@PathParam("cedula")
            @Size(min = 9,max = 11 , message = "Maximo 11 caracteres y Minimo 9")
            @NotNull(message = "Cedula Requerida") String cedula) throws ObjectNotFoundException {
        Profesor profesor = service.traerPorCedula(cedula);
        return  Response.status(Response.Status.OK).entity(profesor).build();
    }

    /*@Path("/retornarMateria/{materia}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response traerPorMateria(@PathParam("materia")
            @NotNull(message = "Campo materia Requerido")
            @Size(min = 3, max = 100, message = "Tamaño Incorrecto") String materia
    ) {
        Mensaje mensaje;
        return null;
    }*/

    @Path("/retornarTodos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response traerTodos() throws ObjectNotFoundException {
         List<Profesor> lista=  service.traerTodos();
        return Response.status(Response.Status.OK).entity(lista).build();
    }
     @Path("eliminarId/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarId(@PathParam("id")
           Integer id) throws ObjectNotFoundException {
        Mensaje mensaje = service.eliminarPorId(id);
        return Response.status(Response.Status.OK).entity(mensaje).build();
    }

    @Path("eliminar/{cedula}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("cedula")
            @Min(value = 9, message = "Minimo 9 Caracteres")
            @Max(value = 11, message = "Maximo 11 Caracteres")
            @NotNull(message = "Cedula Requerida") String cedula) throws ObjectNotFoundException {
        Mensaje mensaje = service.eliminar(cedula);
        return Response.status(Response.Status.OK).entity(mensaje).build();
    }
}
