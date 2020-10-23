package br.com.cartinder.template;

import lombok.Getter;
import lombok.Setter;


public class EmailTemplateDuvidaSugestao implements EmailTemplate{

	public EmailTemplateDuvidaSugestao(String emailComplemento){
		this.complementoEmail = emailComplemento;
	}
	
	private String complementoEmail;
	
	@Override
	public String getSubject() {
		return complementoEmail + "- Duvida ou Sugestão";
	}

	@Override
	public String getTemplate() {
		return "email-duvida-sugestao";
	}

}
