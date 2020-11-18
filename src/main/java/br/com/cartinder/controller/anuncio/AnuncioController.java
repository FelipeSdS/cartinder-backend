package br.com.cartinder.controller.anuncio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cartinder.dto.anuncio.AnuncioAtualizaDTO;
import br.com.cartinder.dto.anuncio.AnuncioEntradaDTO;
import br.com.cartinder.dto.anuncio.AnuncioFiltros;
import br.com.cartinder.dto.anuncio.AnuncioSaidaDTO;
import br.com.cartinder.model.anuncio.Anuncio;
import br.com.cartinder.service.anuncio.AnuncioService;

@RestController
@RequestMapping("anuncio")
public class AnuncioController {

	@Autowired
	AnuncioService anuncioService;
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody AnuncioEntradaDTO dto){
		return new ResponseEntity<Anuncio>(anuncioService.insert(dto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<?>> list(){
		return new ResponseEntity<List<?>>(anuncioService.list(), HttpStatus.OK);
	}
	
	@GetMapping("/id")
	public ResponseEntity<?> buscaAnuncioPorId(@RequestParam Long param){
		return new ResponseEntity<AnuncioSaidaDTO>(anuncioService.buscaAnuncioPorId(param), HttpStatus.OK);
	}
	
	@GetMapping("/marca")
	public ResponseEntity<List<?>> buscaAnuncioPorMarca(@RequestParam String param){
		return new ResponseEntity<List<?>>(anuncioService.buscaAnuncioPorMarca(param), HttpStatus.OK);
	}
	
	@DeleteMapping("/reset")
	public ResponseEntity<?> deleteAllAnuncios(){
		anuncioService.deleteAllAnuncio();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAnuncio(@PathVariable(name="id") Long id){
		anuncioService.deleteAnuncio(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAnuncio(@PathVariable(name="id") Long id, @RequestBody AnuncioAtualizaDTO dto ){
		anuncioService.updateAnuncio(id,dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
