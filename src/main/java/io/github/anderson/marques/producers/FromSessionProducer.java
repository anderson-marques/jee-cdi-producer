package io.github.anderson.marques.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import io.github.anderson.marques.domain.FromSessionScope;
import io.github.anderson.marques.domain.Pojo;

@RequestScoped public class FromSessionProducer {

	@Context HttpServletRequest req;

	@RequestScoped @Produces @FromSessionScope
	public Pojo origemEscopoSessao() {
		return (Pojo) req.getSession().getAttribute("pojo");
	}
}
