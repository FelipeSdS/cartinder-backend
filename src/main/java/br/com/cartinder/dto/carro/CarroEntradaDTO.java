package br.com.cartinder.dto.carro;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarroEntradaDTO {

	private Long cliente;
	
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
