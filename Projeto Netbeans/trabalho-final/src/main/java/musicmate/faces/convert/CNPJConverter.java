/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmate.faces.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Wilson
 */
@FacesConverter("CNPJConverter")
public class CNPJConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return string == null || string.trim().isEmpty() ? null : Long.valueOf(string.replace("-", "").replace("/", "").replace(".", ""));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Long cnpj = (Long) o;
        long p1 = cnpj;
        long p2 = p1/100;
        long p3 = p2/10000;
        long p4 = p3/1000;
        long p5 = p4/1000;
        return String.format("%02d.%03d.%03d/%04d-%02d", p5%100, p4%1000, p3%1000, p2%10000, p1%100);
    }   
}
