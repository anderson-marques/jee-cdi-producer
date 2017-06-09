package io.github.anderson.marques.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import io.github.anderson.marques.domain.FromApplicationScope;
import io.github.anderson.marques.domain.Pojo;

@RequestScoped public class FromApplicationProducer {

	@Context HttpServletRequest req;

	@RequestScoped @Produces @FromApplicationScope
	public Pojo origemEscopoAplicacao() {
		return (Pojo) req.getServletContext().getAttribute("pojo");
	}
}
