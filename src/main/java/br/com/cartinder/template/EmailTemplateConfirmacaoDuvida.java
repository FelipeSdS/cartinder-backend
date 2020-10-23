package br.com.cartinder.template;

public class EmailTemplateConfirmacaoDuvida implements EmailTemplate {

	@Override
	public String getSubject() {
		return "CarTinder - Dúdvida ou Sugestão";
	}

	@Override
	public String getTemplate() {
		return "email-confirmacao-duvida";
	}

}
