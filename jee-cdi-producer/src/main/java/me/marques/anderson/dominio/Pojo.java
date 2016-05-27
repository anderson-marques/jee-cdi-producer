package me.marques.anderson.dominio;

import java.io.Serializable;

public class Pojo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
