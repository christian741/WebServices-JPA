/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Controller;

//imports EJB
import javax.ejb.EJB;
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

/**
 *
 * @author Christian
 */
@Stateless
@Path("/profesores")
public class ProfesorController {

    @EJB
    //private IProfesorService service;

    @Path("/insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON) //Trae Respuesta
    @Consumes(MediaType.APPLICATION_JSON) //Consume algo
    public Response insertarProfesor(@Valid Profesor profesor) {
        Mensaje mensaje;
        return null;
    }

    @Path("/editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editarProfesor(@Valid Profesor profesor) {
        Mensaje mensaje;
        return null;
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
    public Response traerProfesorCedula(@PathParam("cedula") Integer cedula) {
        Mensaje mensaje;
        return null;
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
    public Response retornarProfesorCedula(@PathParam("cedula")
            @Min(value = 9, message = "Minimo 9 Caracteres")
            @Max(value = 11, message = "Maximo 11 Caracteres")
            @NotNull(message = "Cedula Requerida") Integer cedula) {
        Mensaje mensaje;
        return null;
    }

    @Path("/retornarMateria/{materia}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response traerProfesorMateria(@PathParam("materia")
            @NotNull(message = "Campo materia Requerido")
            @Size(min = 3, max = 100, message = "Tamaño Incorrecto") String materia
    ) {
        Mensaje mensaje;
        return null;
    }

    @Path("/retornarTodos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response traerTodosProfesores() {
        return null;
    }

    @Path("eliminar/{cedula}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarProfesor(@PathParam("cedula")
            @Min(value = 9, message = "Minimo 9 Caracteres")
            @Max(value = 11, message = "Maximo 11 Caracteres")
            @NotNull(message = "Cedula Requerida") Integer cedula) {
        Mensaje mensaje;
        return null;
    }
}
