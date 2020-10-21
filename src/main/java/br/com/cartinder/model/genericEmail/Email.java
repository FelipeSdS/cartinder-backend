package br.com.cartinder.model.genericEmail;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email implements IEmail{
	
	private EmailFrom from;
	
	private EmailRecipient recipient;
	
	private Object data;


}
