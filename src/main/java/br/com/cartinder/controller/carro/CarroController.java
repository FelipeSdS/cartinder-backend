package br.com.cartinder.controller.carro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cartinder.dto.carro.CarroEntradaDTO;
import br.com.cartinder.model.carro.Carro;
import br.com.cartinder.service.carro.CarroService;

@RestController
@RequestMapping("carro")
public class CarroController {

	@Autowired
	CarroService carroService;
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody CarroEntradaDTO dto){
		return new ResponseEntity<Carro>(carroService.insert(dto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<?>> list(){
		return new ResponseEntity<List<?>>(carroService.list(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<?> findById(@PathVariable(name="id") Long id){
		return new ResponseEntity<Carro>(carroService.findById(id), HttpStatus.OK);
	}
}
