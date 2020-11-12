package br.com.cartinder.service.anuncio;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cartinder.dto.anuncio.AnuncioEntradaDTO;
import br.com.cartinder.dto.anuncio.AnuncioFiltros;
import br.com.cartinder.dto.anuncio.AnuncioSaidaDTO;
import br.com.cartinder.model.anuncio.Anuncio;
import br.com.cartinder.model.carro.Carro;
import br.com.cartinder.model.cliente.Cliente;
import br.com.cartinder.model.email.EmailConfirmacao;
import br.com.cartinder.model.email.EmailInteresse;
import br.com.cartinder.model.email.FormularioInteresse;
import br.com.cartinder.repository.anuncio.AnuncioRepository;
import br.com.cartinder.service.carro.CarroService;
import br.com.cartinder.service.cliente.ClienteService;
import br.com.cartinder.service.email.SendEmailService;


@Service
public class AnuncioService {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	SendEmailService emailService;
	
	@Autowired
	AnuncioRepository anuncioRepository;
	
	public Anuncio insert(AnuncioEntradaDTO anuncioEntradaDTO) {
		Anuncio anuncio = convertAnuncio(anuncioEntradaDTO);
		anuncioRepository.save(anuncio);
		return anuncio;
	}
	
	public List<AnuncioSaidaDTO> list(){
		List<AnuncioSaidaDTO> listAnuncioSaidaDTO = new ArrayList<>();
		List<Anuncio> listAnuncio = anuncioRepository.findAll();
		if(!listAnuncio.isEmpty()) {
			listAnuncio.forEach(anuncio ->{
				listAnuncioSaidaDTO.add(convertAnuncioSaidaDTO(anuncio));
			});
		}
		return listAnuncioSaidaDTO;
	}
	
	public AnuncioSaidaDTO buscaAnuncioPorId(Long id){
		Anuncio anuncio = anuncioRepository.findById(id).orElseThrow(() -> new RuntimeException("Anuncio não encontrado"));
		AnuncioSaidaDTO anuncioSaidaDTO = convertAnuncioSaidaDTO(anuncio);
		return anuncioSaidaDTO;
	}
	
	public List<AnuncioSaidaDTO> buscaAnuncioPorMarca(String marca){
		List<AnuncioSaidaDTO> listAnuncioSaidaDTO = new ArrayList<>();
		List<Anuncio> listAnuncio = anuncioRepository.buscaAnuncioPorMarca(marca);
		if(!listAnuncio.isEmpty()) {
			listAnuncio.forEach(anuncio ->{
				listAnuncioSaidaDTO.add(convertAnuncioSaidaDTO(anuncio));
			});
		}else {
			throw new RuntimeException("Nenhum carro encontrado com esta marca");
		}
		return listAnuncioSaidaDTO;
	}
	
	public List<AnuncioSaidaDTO> buscaComFiltro(AnuncioFiltros filtros){
		List<Anuncio> resultAnuncio = new ArrayList<>();
		
		if((filtros.getMarca() != null && !filtros.getMarca().isEmpty()) && (filtros.getAno() != null && filtros.getAno() != 0)) {
			resultAnuncio = anuncioRepository.buscaAnuncioPorMarcaAno(filtros.getMarca(), filtros.getAno());
		}
		else if(filtros.getMarca() != null && !filtros.getMarca().isEmpty()){
			resultAnuncio = anuncioRepository.buscaAnuncioPorMarca(filtros.getMarca());
		}
		else if(filtros.getAno() != null && filtros.getAno() != 0){
			resultAnuncio = anuncioRepository.buscaAnuncioPorAno(filtros.getAno());
		}
		
		if(resultAnuncio.isEmpty()){
			throw new RuntimeException("Nenhum carro encontrado");
		}else {
			List<AnuncioSaidaDTO> anuncioSaidaDTO  = new ArrayList<>();
			resultAnuncio.forEach(f->{
				anuncioSaidaDTO.add(convertAnuncioSaidaDTO(f));
			});
			return anuncioSaidaDTO;
		}
	}
	
	public void deleteAllAnuncio() {
		anuncioRepository.deleteAll();
	}
	
	private Anuncio convertAnuncio(AnuncioEntradaDTO anuncioEntradaDTO){
		 ModelMapper modelMapper = new ModelMapper();
		 Anuncio anuncio = new Anuncio();
		 anuncio.setPreco(anuncioEntradaDTO.getPreco());
		 anuncio.setDataCriacao(new Date());
		 Cliente cliente = clienteService.findById(anuncioEntradaDTO.getId_cliente());
		 anuncio.setCliente(cliente);
		 Carro carro = modelMapper.map(anuncioEntradaDTO, Carro.class);
		 carro.setAnuncio(anuncio);
		 anuncio.setCarro(carro);
		 return anuncio;
	}
	
	private AnuncioSaidaDTO convertAnuncioSaidaDTO(Anuncio anuncio){
		ModelMapper modelMapper = new ModelMapper();
		AnuncioSaidaDTO anuncioSaidaDTO = new AnuncioSaidaDTO();
		anuncioSaidaDTO = modelMapper.map(anuncio.getCarro(), AnuncioSaidaDTO.class);
		anuncioSaidaDTO.setIdAnuncio(anuncio.getId_anuncio());
		anuncioSaidaDTO.setPreco(anuncio.getPreco());
		return anuncioSaidaDTO;
	}

}
