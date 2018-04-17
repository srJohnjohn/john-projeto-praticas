/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.auxiliares;

import java.time.DayOfWeek;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author recursive
 */
@Converter(autoApply = true)
public class ConversorDiaDaSemanaJPA implements AttributeConverter<Integer, DayOfWeek>{

    @Override
    public DayOfWeek convertToDatabaseColumn(Integer attribute) {
        return DayOfWeek.of(attribute);
    }

    @Override
    public Integer convertToEntityAttribute(DayOfWeek dbData) {
        return dbData.getValue();
    }

}
