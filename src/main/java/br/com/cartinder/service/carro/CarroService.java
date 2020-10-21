package br.com.cartinder.service.carro;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cartinder.dto.carro.CarroEntradaDTO;
import br.com.cartinder.model.anuncio.Anuncio;
import br.com.cartinder.model.carro.Carro;
import br.com.cartinder.model.cliente.Cliente;
import br.com.cartinder.repository.carro.CarroRepository;
import br.com.cartinder.service.cliente.ClienteService;

@Service
public class CarroService {

	
	@Autowired
	CarroRepository carroRepository;
	
	
	ModelMapper modelMapper;
	
	public Carro insert(CarroEntradaDTO dto) {
		Carro carro = new Carro();
		carro.setModelo(dto.getModelo());
		return carroRepository.save(carro);
	}
	
	public List<Carro> list(){
		return carroRepository.findAll();
	}
	
	public Carro findById(Long id) {
		return carroRepository.findById(id).orElseThrow(() -> new RuntimeException("Carro não encontrado"));
	}
	
	public Carro updateAnuncioCarro(Anuncio anuncio) {
		Carro carro = findById(anuncio.getCarro().getId_carro());
		carro.setAnuncio(anuncio);
		return carroRepository.save(carro);
	}
	
	public Carro convertToCarro(CarroEntradaDTO dto){
		Carro carro = new Carro();
		carro.setModelo(dto.getModelo());
		return carro;
	}
}
