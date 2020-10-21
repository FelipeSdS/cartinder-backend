package br.com.cartinder.service.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cartinder.dto.cliente.ClienteEntradaDTO;
import br.com.cartinder.model.cliente.Cliente;
import br.com.cartinder.repository.cliente.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente insert(ClienteEntradaDTO dto){
		return clienteRepository.save(convertToCliente(dto));
	}
	
	public List<Cliente> list(){
		return clienteRepository.findAll();
	}
	
	public Cliente findById(Long id){
		return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
	}
	
	private Cliente convertToCliente(ClienteEntradaDTO dto){
		Cliente cliente = new Cliente();
		cliente.setNome(dto.getNome());
		cliente.setEmail(dto.getEmail());
		return cliente;
	}
	
}
