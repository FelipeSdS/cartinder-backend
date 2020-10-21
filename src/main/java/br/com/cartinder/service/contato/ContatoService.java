package br.com.cartinder.service.contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cartinder.model.anuncio.Anuncio;
import br.com.cartinder.model.email.EmailInteresseConfirmacao;
import br.com.cartinder.model.email.EmailDuvidaSugestao;
import br.com.cartinder.model.email.EmailInteresse;
import br.com.cartinder.model.email.FormularioInteresse;
import br.com.cartinder.repository.anuncio.AnuncioRepository;
import br.com.cartinder.service.email.SendEmailService;

@Service
public class ContatoService {

	@Autowired
	AnuncioRepository anuncioRepository;
	
	@Autowired
	SendEmailService emailService;
	
	public void tenhoInteresse(FormularioInteresse anuncioInteresse) throws Exception{
		Anuncio anuncio = anuncioRepository.findById(anuncioInteresse.getId_anuncio()).orElseThrow(
		() -> new RuntimeException("Anuncio não encontrado"));
		
		EmailInteresse emailInteresse = new EmailInteresse();
		emailInteresse.setAnuncio(anuncio);
		emailInteresse.setComprador(anuncioInteresse.getNome());
		emailInteresse.setEmailComprador(anuncioInteresse.getEmail());
		emailInteresse.setTelefoneComprador(anuncioInteresse.getTelefone());
		emailInteresse.setMensagemComprador(anuncioInteresse.getMensagem());
		
		EmailInteresseConfirmacao emailConfirmacao = new EmailInteresseConfirmacao();
		emailConfirmacao.setNome(anuncioInteresse.getNome());
		emailConfirmacao.setEmail(anuncioInteresse.getEmail());
		
		
		if(emailService.enviarEmailInteresse(emailInteresse, anuncio.getCliente().getEmail())){
			emailService.enviarEmailInteresseConfirmacao(emailConfirmacao);
		}else {
			
		}
	}
	
	public void duvidasSugestoes(EmailDuvidaSugestao duvidaSugestao){
		if(emailService.enviarEmailDuvidaSugestao(duvidaSugestao)){
			
		}
	}
}
