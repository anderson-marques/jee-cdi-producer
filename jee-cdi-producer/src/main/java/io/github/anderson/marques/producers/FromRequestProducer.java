package io.github.anderson.marques.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import io.github.anderson.marques.domain.Pojo;
import io.github.anderson.marques.domain.FromRequestScope;

@RequestScoped public class FromRequestProducer {

	@Context HttpServletRequest req;
	
	@RequestScoped @Produces @FromRequestScope
	public Pojo origemEscopoRequisicao() {
		return (Pojo) req.getAttribute("pojo");
	}
}
