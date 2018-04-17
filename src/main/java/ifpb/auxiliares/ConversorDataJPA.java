/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.auxiliares;

import java.time.LocalDate;
import java.sql.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Converter;

/**
 *
 * @author recursive
 */
@Converter(autoApply = true)
public class ConversorDataJPA implements AttributeConverter<Date, LocalDate>{

    @Override
    public LocalDate convertToDatabaseColumn(Date attribute) {
        if(attribute != null) {
            return attribute.toLocalDate();
        }
        return null;
        }

    @Override
    public Date convertToEntityAttribute(LocalDate dbData) {
        if(dbData != null) {
            return Date.valueOf(dbData);
        }
        return null;
    }

}
