package br.com.cartinder.service.email;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import br.com.cartinder.model.email.EmailInteresseConfirmacao;
import br.com.cartinder.model.email.EmailDuvidaSugestao;
import br.com.cartinder.model.email.EmailInteresse;
import br.com.cartinder.model.genericEmail.Email;
import br.com.cartinder.model.genericEmail.EmailFrom;
import br.com.cartinder.model.genericEmail.EmailRecipient;
import br.com.cartinder.model.genericEmail.IEmail;
import br.com.cartinder.template.EmailTemplate;
import br.com.cartinder.template.EmailTemplateConfirmacao;
import br.com.cartinder.template.EmailTemplateDuvidaSugestao;
import br.com.cartinder.template.EmailTemplateInteresse;

@Service
public class SendEmailService {
	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender emailSender;
	
	public Boolean enviarEmailInteresse(EmailInteresse emailInteresse, String destinatario){
		try {
			 enviarEmail(emailInteresse, destinatario, new EmailTemplateInteresse());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Boolean enviarEmailInteresseConfirmacao(EmailInteresseConfirmacao emailConfirmacao) {
		try {
			enviarEmail(emailConfirmacao, emailConfirmacao.getEmail(), new EmailTemplateConfirmacao());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Boolean enviarEmailDuvidaSugestao(EmailDuvidaSugestao emailDuvidaSugestao) {
		try {
			enviarEmail(emailDuvidaSugestao, "equipecartinder@gmail.com", new EmailTemplateDuvidaSugestao());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	private Boolean enviarEmail(Object data, String destinatario, EmailTemplate template) throws Exception {
		
		Email email = new Email();
		
		try {
			EmailFrom from = new EmailFrom();
			from.setEmail("equipecartinder@gmail.com");
			from.setName("CarTinder");
			
			EmailRecipient recipient = new EmailRecipient();
			recipient.setTo(Arrays.asList(destinatario).toArray(new String [0]));
			recipient.setCkReceiveCopy(false);
			
			email.setFrom(from);
			email.setRecipient(recipient);
			email.setData(data);
			
			sendSimpleEmail(email, template);
		}catch(RuntimeException e) {
			return false;
		}	
		return true;
	}
	
	private void sendSimpleEmail(Email emailParam, EmailTemplate template) throws Exception{
		Map<String, Object> data = new HashMap<>();
		data.put("data", emailParam.getData());
		final Context ctx = new Context(Locale.getDefault(), data);

		final MimeMessage mimeMessage = this.emailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");

		message.setSubject(template.getSubject());
		
		message.setFrom(new InternetAddress(emailParam.getFrom().getEmail(), emailParam.getFrom().getName()));
		
		final String htmlContent = this.templateEngine.process(template.getTemplate(), ctx);
		message.setText(htmlContent, true);
		message.setTo(emailParam.getRecipient().getTo());
		
		if(emailParam.getRecipient().isCkReceiveCopy()) {
			message.addCc(emailParam.getFrom().getEmail());
		}
		
		
		if(emailParam.getRecipient().getCc() != null) {
			for(String email : emailParam.getRecipient().getCc()) {
				message.addCc(email);
			}
		}
		this.emailSender.send(mimeMessage);
	}
}
