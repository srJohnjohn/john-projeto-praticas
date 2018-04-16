/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.auxiliares;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.AttributeConverter;

/**
 *
 * @author recursive
 */
@FacesConverter(value = "conversorData")
public class ConversorData implements Converter{

//    @Override
//    public LocalDate convertToDatabaseColumn(String attribute) {
//        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate data = LocalDate.parse(attribute, formato);
//        return data;
//    }
//
//    @Override
//    public String convertToEntityAttribute(LocalDate dbData) {
//        String formato = dbData.getDayOfMonth()+"/"+dbData.getMonthValue()+"/"+dbData.getYear();
//        //return formato.replaceAll("-", "/");
//        return formato;
//    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(value, formato);
        return data;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        LocalDate dbData = (LocalDate) value;
        String formato = dbData.getDayOfMonth()+"/"+dbData.getMonthValue()+"/"+dbData.getYear();
        //return formato.replaceAll("-", "/");
        return formato;
    }
    
}
