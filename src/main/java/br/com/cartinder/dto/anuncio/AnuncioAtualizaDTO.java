package br.com.cartinder.dto.anuncio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioAtualizaDTO {
	
	private Double preco;
	
	private String modelo;
	
	private String marca;
	
	private Integer ano;
	
	private Long quilometragem;
	
	private String potenciaMotor;
	
	private String combustivel;
	
	private String cambio;
	
	private String direcao;
	
	private String cor;
	
	private Integer portas; 
	
}
