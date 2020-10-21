package br.com.cartinder.model.genericEmail;

public interface IEmail {
	public EmailFrom getFrom();
	public void setFrom(EmailFrom emailFrom);

	public EmailRecipient getRecipient();
	public void setRecipient(EmailRecipient emailRecipient);
	
	public Object getData();
	void setData(Object t);
}
