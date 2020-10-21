package br.com.cartinder.model.email;

import br.com.cartinder.model.anuncio.Anuncio;
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
public class EmailInteresse {

	private String comprador;
	
	private String emailComprador;
	
	private String telefoneComprador;
	
	private String mensagemComprador;
	
	private Anuncio anuncio;
}
