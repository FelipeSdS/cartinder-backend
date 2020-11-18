package br.com.cartinder.model.anuncio;

import java.util.Date;

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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.cartinder.model.carro.Carro;
import br.com.cartinder.model.cliente.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tab_anuncio")
public class Anuncio {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id_anuncio")
	private Long id_anuncio;
	
	@Column(name="vl_preco")
	private Double preco;
	
	@Column(name="dt_criacao")
	private Date dataCriacao;
	
	
	@OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name="carro_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Carro carro;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_cliente", nullable = false)
	private Cliente cliente;
}
