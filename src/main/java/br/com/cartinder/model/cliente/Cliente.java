package br.com.cartinder.model.cliente;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import br.com.cartinder.model.anuncio.Anuncio;
import br.com.cartinder.model.carro.Carro;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tab_cliente")
public class Cliente {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id_cliente")
	private Long id_cliente;
	
	@Column(name="tx_nome")
	private String nome;
	
	@Column(name="tx_cnpj")
	private String cnpj;	
	
	@Column(name="tx_email")
	private String email;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Anuncio> anuncios;
}
