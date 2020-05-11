package br.com.triadworks.bugtracker.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("senhaForte")
public class ValidaSenha implements Validator{

	@Override
	public void validate(FacesContext ctx, UIComponent c, Object valor)
			throws ValidatorException {

		String senha = valor.toString();
		if(!senha.contains("@")){
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"O campo senha não é forte o bastante",
					"Deve conter @"));
			

			
		}
		
		
	}

}
