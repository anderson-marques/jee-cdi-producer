package me.marques.anderson.produtores;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import me.marques.anderson.dominio.DaSessao;
import me.marques.anderson.dominio.Pojo;

@RequestScoped public class ProdutorPojoEscopoSessao {

	@Context HttpServletRequest req;

	@RequestScoped @Produces @DaSessao
	public Pojo origemEscopoSessao() {
		return (Pojo) req.getSession().getAttribute("pojo");
	}
}
