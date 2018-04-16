/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.auxiliares;

import java.time.LocalTime;
import javafx.util.converter.LocalTimeStringConverter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author recursive
 */
@FacesConverter(value = "conversorTime")
public class ConversorTime implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        LocalTime tempo = new LocalTimeStringConverter().fromString(value);
        return tempo;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        LocalTime tempo = (LocalTime) value;
        return tempo.toString();
    }
    
}
