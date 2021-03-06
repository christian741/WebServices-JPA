/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Excepcion;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import udec.edu.co.Pojo.ErrorWraper;

/**
 *
 * @author Christian
 */
@Provider
public class ValidationEliminarExceptionFilter implements ExceptionMapper<ValidationEliminarException>{
   

    @Override
    public Response toResponse(ValidationEliminarException exception) {
        ErrorWraper error = new ErrorWraper(exception.getMessage(), "400", "BAD REQUEST");
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
    
}
