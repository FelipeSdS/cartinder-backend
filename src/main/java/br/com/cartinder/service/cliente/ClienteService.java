package br.com.cartinder.service.cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cartinder.dto.cliente.ClienteAtualizaDTO;
import br.com.cartinder.dto.cliente.ClienteEntradaDTO;
import br.com.cartinder.dto.cliente.ClienteSaidaDTO;
import br.com.cartinder.model.cliente.Cliente;
import br.com.cartinder.repository.cliente.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente insert(ClienteEntradaDTO dto){
		return clienteRepository.save(convertToCliente(dto));
	}
	
	public List<ClienteSaidaDTO> list(){
		List<ClienteSaidaDTO> dto = new ArrayList<ClienteSaidaDTO>();
		List<Cliente> clientes = clienteRepository.findAll();
		clientes
			 .stream()
			 .forEach(cliente ->{
				 dto.add(convertToClienteSaidaDTO(cliente));
			 });
		return dto;
	}
	
	public Cliente findById(Long id){
		return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
	}
	
	public void updateCliente(ClienteAtualizaDTO dto){
		Optional<Cliente> optionalCliente = clienteRepository.findById(dto.getIdCliente());
		if(optionalCliente.isPresent()) {
			Cliente cliente = optionalCliente.get();
			cliente.setNome(dto.getNome());
			cliente.setEmail(dto.getEmail());
			clienteRepository.save(cliente);
		}
		else {
			throw new RuntimeException("Nenhum Cliente foi encontrado");
		}
	}
	
	public void deleteCliente(Long idCliente){
		clienteRepository.deleteById(idCliente);
	}
	
	private Cliente convertToCliente(ClienteEntradaDTO dto){
		Cliente cliente = new Cliente();
		cliente.setNome(dto.getNome());
		cliente.setEmail(dto.getEmail());
		return cliente;
	}
	
	private ClienteSaidaDTO convertToClienteSaidaDTO(Cliente cliente) {
		ClienteSaidaDTO dto = new ClienteSaidaDTO();
		dto.setIdCliente(cliente.getId_cliente());
		dto.setNome(cliente.getNome());
		dto.setEmail(cliente.getEmail());
		return dto;
	}
	
}
