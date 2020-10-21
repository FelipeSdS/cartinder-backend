package br.com.cartinder.model.genericEmail;

import java.io.Serializable;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRecipient implements Serializable{
	private static final long serialVersionUID = 4096428256872041466L;

	private String[] to;
	private String[] cc;
	private boolean ckReceiveCopy;
}
