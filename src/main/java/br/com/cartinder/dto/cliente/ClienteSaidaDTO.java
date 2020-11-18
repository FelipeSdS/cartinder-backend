package br.com.cartinder.dto.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteSaidaDTO {

	private Long idCliente;
	
	private String nome;
	
	private String email;
}
