/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.edu.co.Converter;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Christian
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, java.sql.Date>{

    @Override
    public Date convertToDatabaseColumn(LocalDate date) {
        return date == null ? null :Date.valueOf(date);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return date == null ? null : new Date(date.getTime()).toLocalDate();
    }
    
}
