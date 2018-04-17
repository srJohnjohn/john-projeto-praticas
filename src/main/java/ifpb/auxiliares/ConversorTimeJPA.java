/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.auxiliares;

import java.sql.Time;
import java.time.LocalTime;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author recursive
 */
@Converter(autoApply = true)
public class ConversorTimeJPA implements AttributeConverter<LocalTime, Time>{

    @Override
    public Time convertToDatabaseColumn(LocalTime attribute) {
        return (attribute == null ? null : Time.valueOf(attribute));
    }

    @Override
    public LocalTime convertToEntityAttribute(Time dbData) {
        return (dbData == null ? null : LocalTime.of(dbData.getHours(), dbData.getMinutes()));
    }
    
}
