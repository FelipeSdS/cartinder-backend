package br.com.cartinder.template;

public class EmailTemplateConfirmacao  implements EmailTemplate{

	@Override
	public String getSubject() {
		return "Confirmação de Email - CarTinder";
	}

	@Override
	public String getTemplate() {
		return "email-confirmacao";
	}

}
