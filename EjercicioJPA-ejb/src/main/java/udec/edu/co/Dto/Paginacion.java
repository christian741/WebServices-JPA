/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Dto;

import java.util.List;

/**
 *
 * @author Christian
 */
public class Paginacion<T> {
    
       public List<T> contenido;
       public Integer totalResultados;
       public Integer totalPaginas;
    
}
