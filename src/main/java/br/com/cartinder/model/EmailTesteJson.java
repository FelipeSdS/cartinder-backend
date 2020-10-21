package br.com.cartinder.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailTesteJson implements Serializable {
	private static final long serialVersionUID = 3849202931471772272L;
	
	private String teste;
	private String teste1;
}
