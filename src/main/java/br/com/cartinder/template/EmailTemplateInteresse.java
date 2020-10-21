package br.com.cartinder.template;

public class EmailTemplateInteresse implements EmailTemplate{

	@Override
	public String getSubject() {
		return "CarTinder - Anuncio";
	}

	@Override
	public String getTemplate() {
		return "email-interesse";
	}

}
