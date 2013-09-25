/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmate.faces.validator;

import musicmate.faces.mngbeans.CadastroBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import utfpr.util.DigitoVerificadorCPF;

/**
 *
 * @author Wilson
 */
@FacesValidator("EstadoValidator")
public class EstadoValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {

        if (((String) o).equals(CadastroBean.TOPLEVEL_LOOKUP_VALUE)) {
            // Selecione selecionado
            throw new ValidatorException(new FacesMessage("Estado invalido"));
        }
    }
    
}
