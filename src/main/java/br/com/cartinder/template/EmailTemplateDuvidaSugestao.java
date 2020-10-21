package br.com.cartinder.template;

public class EmailTemplateDuvidaSugestao implements EmailTemplate{

	@Override
	public String getSubject() {
		return "CarTinder - Duvida ou Sugestão";
	}

	@Override
	public String getTemplate() {
		return "email-duvida-sugestao";
	}

}
