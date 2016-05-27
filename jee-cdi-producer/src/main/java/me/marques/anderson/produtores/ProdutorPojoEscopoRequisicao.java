package me.marques.anderson.produtores;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import me.marques.anderson.dominio.DaRequisicao;
import me.marques.anderson.dominio.Pojo;

@RequestScoped public class ProdutorPojoEscopoRequisicao {

	@Context HttpServletRequest req;
	
	@RequestScoped @Produces @DaRequisicao 
	public Pojo origemEscopoRequisicao() {
		return (Pojo) req.getAttribute("pojo");
	}
}
