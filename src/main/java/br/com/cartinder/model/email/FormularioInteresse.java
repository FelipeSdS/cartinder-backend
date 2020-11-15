package br.com.cartinder.model.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormularioInteresse {

	private Long idAnuncio;
	
	private String nome;
	
	private String duvidaEmail;
	
	private String telefone;
	
	private String mensagem;
}
