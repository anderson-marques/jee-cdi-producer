package me.marques.anderson.produtores;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import me.marques.anderson.dominio.DaAplicacao;
import me.marques.anderson.dominio.Pojo;

@RequestScoped public class ProdutorPojoEscopoAplicacao {

	@Context HttpServletRequest req;

	@RequestScoped @Produces @DaAplicacao
	public Pojo origemEscopoAplicacao() {
		return (Pojo) req.getServletContext().getAttribute("pojo");
	}
}
