package br.com.cartinder.model.carro;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.cartinder.model.anuncio.Anuncio;
import br.com.cartinder.model.cliente.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tab_carro")
public class Carro {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id_carro")
	private Long id_carro;
	
	@Column(name="tx_modelo")
	private String modelo;
	
	@Column(name="tx_marca")
	private String marca;
	
	@Column(name="vl_ano")
	private Integer ano;
	
	@Column(name="vl_quilometragem")
	private Long quilometragem;
	
	@Column(name="tx_potencia")
	private String potenciaMotor;
	
	@Column(name="tx_combustivel")
	private String combustivel;
	
	@Column(name="tx_cambio")
	private String cambio;
	
	@Column(name="tx_direcao")
	private String direcao;
	
	@Column(name="tx_cor")
	private String cor;
	
	@Column(name="qtd_portas")
	private Integer portas;
	
	@Column(name="tx_foto")
	private String foto;
		
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true )
	@JoinColumn(name="anuncio_id")
	private Anuncio anuncio;
}
