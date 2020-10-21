package br.com.cartinder.dto.anuncio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnuncioSaidaDTO {

	private Long idAnuncio;
	
	private Double preco;
	
	private String modelo;
	
	private String marca;
	
	private Integer ano;
	
	private Long quilometragem;
	
	private Double potenciaMotor;
	
	private String combustivel;
	
	private String cambio;
	
	private String direcao;
	
	private String cor;
	
	private Integer portas; 
}
