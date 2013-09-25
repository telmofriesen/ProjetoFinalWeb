/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmate.faces.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Wilson
 */
@FacesValidator("CNPJValidator")
public class CNPJValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
            String cnpj = String.format("%014d", (Long) o);
        if (!cnpj.matches("\\d{14}")) {        
            throw new ValidatorException(new FacesMessage("CNPJ \'" + cnpj + "\' em formato incorreto."));
        } else {
            if (Long.parseLong(cnpj)/1000000 <= 0 || (Long.parseLong(cnpj)/100) % 10000 <= 0) {
                throw new ValidatorException(new FacesMessage("CNPJ \'" + cnpj + "\' em formato incorreto."));
            }
            
//            RevendedorJpaController rjc = new RevendedorJpaController();
//            if (rjc.exists(Long.parseLong(cnpj))) {
//                throw new ValidatorException(new FacesMessage("CNPJ já cadastrado."));
//            }
            
            //DigitoVerificadorCPF dvcpf = new DigitoVerificadorCPF(cpf.substring(0, 9));
            //int dv = Integer.parseInt(cpf.substring(9, 11));
            //if (!dvcpf.isValido(dv)) {
             //   throw new ValidatorException(new FacesMessage("CPF \'" + cpf + "\' inválido"));
            //}
        }
    }
    
}
