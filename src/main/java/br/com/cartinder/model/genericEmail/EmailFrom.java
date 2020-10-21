package br.com.cartinder.model.genericEmail;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailFrom implements Serializable{

	private static final long serialVersionUID = 1591179143056663081L;
	private String name;
	private String email;
}
