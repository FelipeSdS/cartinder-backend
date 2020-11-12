package br.com.cartinder.controller.contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cartinder.model.email.EmailDuvidaSugestao;
import br.com.cartinder.model.email.EmailVender;
import br.com.cartinder.model.email.FormularioInteresse;
import br.com.cartinder.service.contato.ContatoService;

@RestController
@RequestMapping("contato")
public class ContatoController {
	
	@Autowired
	ContatoService contatoService;
	
	@PostMapping("/interesse")
	public ResponseEntity<?> tenhoInteresse(@RequestBody FormularioInteresse anuncioInteresse) throws Exception{
		contatoService.tenhoInteresse(anuncioInteresse);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/duvidaSugestao")
	public ResponseEntity<?> duvidaSugestao(@RequestBody EmailDuvidaSugestao emailDuvidaSugestao){
		contatoService.duvidasSugestoes(emailDuvidaSugestao);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/vender")
	public ResponseEntity<?> vender(@RequestBody EmailVender emailVender){
		contatoService.vender(emailVender);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	


}
