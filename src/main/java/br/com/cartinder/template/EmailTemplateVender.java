package br.com.cartinder.template;

public class EmailTemplateVender implements EmailTemplate {
	
	public EmailTemplateVender(String emailComplemento){
		this.complementoEmail = emailComplemento;
	}
	
	private String complementoEmail;
	
	@Override
	public String getSubject() {
		return "CarTinder - Novo Anuncio - " + complementoEmail;
	}

	@Override
	public String getTemplate() {
		return "email-vender";
	}

}
