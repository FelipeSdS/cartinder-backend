package br.com.cartinder.template;

public class TesteTemplate implements EmailTemplate{

	@Override
	public String getSubject() {
		return "Test";
	}

	@Override
	public String getTemplate() {
		return "email-teste";
	}
}
