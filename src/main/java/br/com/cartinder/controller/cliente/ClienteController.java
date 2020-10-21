package br.com.cartinder.controller.cliente;

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

import br.com.cartinder.dto.cliente.ClienteEntradaDTO;
import br.com.cartinder.model.cliente.Cliente;
import br.com.cartinder.service.cliente.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody ClienteEntradaDTO dto){
		return new ResponseEntity<Cliente>(clienteService.insert(dto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<?>> list(){
		return new ResponseEntity<List<?>>(clienteService.list(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(name="id") Long id){
		return new ResponseEntity<Cliente>(clienteService.findById(id), HttpStatus.OK);
	}
}
