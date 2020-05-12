package br.com.dstech.sistemajsf.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class FacesUtil {

	
	private FacesContext facescontext;
	
	public FacesUtil(){
		this.facescontext = FacesContext.getCurrentInstance();
		
	}
 	
	
	public void adicionaMenssagemDeErro(String msg) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,msg);
		facescontext.addMessage(null, facesMessage);
	
		
	}
	
	public void adicionaMenssagemDeSucesso(String msg) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,msg);
		facescontext.addMessage(null, facesMessage);
	
		
	}
	
}
