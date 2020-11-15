package br.com.cartinder.service.contato;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cartinder.model.anuncio.Anuncio;
import br.com.cartinder.model.email.EmailConfirmacao;
import br.com.cartinder.model.email.EmailDuvidaSugestao;
import br.com.cartinder.model.email.EmailInteresse;
import br.com.cartinder.model.email.EmailVender;
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
		Anuncio anuncio = anuncioRepository.findById(anuncioInteresse.getIdAnuncio()).orElseThrow(
		() -> new RuntimeException("Anuncio não encontrado"));
		
		EmailInteresse emailInteresse = new EmailInteresse();
		emailInteresse.setAnuncio(anuncio);
		emailInteresse.setComprador(anuncioInteresse.getNome());
		emailInteresse.setEmailComprador(anuncioInteresse.getDuvidaEmail());
		emailInteresse.setTelefoneComprador(anuncioInteresse.getTelefone());
		emailInteresse.setMensagemComprador(anuncioInteresse.getMensagem());
		
		EmailConfirmacao emailConfirmacao = new EmailConfirmacao();
		emailConfirmacao.setNome(anuncioInteresse.getNome());
		emailConfirmacao.setEmailUsuario(anuncioInteresse.getDuvidaEmail());
		
		
		if(emailService.enviarEmailInteresse(emailInteresse, anuncio.getCliente().getEmail())){
			emailService.enviarEmailInteresseConfirmacao(emailConfirmacao);
		}else {
			throw new RuntimeException("Erro ao enviar o email");
		}
	}
	
	public void duvidasSugestoes(EmailDuvidaSugestao duvidaSugestao){
		EmailConfirmacao emailConfirmacao = new EmailConfirmacao();
		emailConfirmacao.setNome(duvidaSugestao.getNome());
		emailConfirmacao.setEmailUsuario(duvidaSugestao.getDuvidaEmail());
		if(emailService.enviarEmailDuvidaSugestao(duvidaSugestao)){
			emailService.enviarEmailDuvidaSugestaoConfirmacao(emailConfirmacao);
		}else {
			throw new RuntimeException("Erro ao enviar o email");
		}
	}
	
	public void vender(EmailVender vender){


		if(emailService.enviarEmailVender(vender)){

		}else {
			throw new RuntimeException("Erro ao enviar o email");
		}
	}
}
