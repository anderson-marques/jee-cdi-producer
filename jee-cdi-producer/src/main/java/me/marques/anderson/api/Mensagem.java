package me.marques.anderson.api;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.marques.anderson.dominio.DaAplicacao;
import me.marques.anderson.dominio.DaRequisicao;
import me.marques.anderson.dominio.DaSessao;
import me.marques.anderson.dominio.Pojo;

@Path("/mensagem")
@RequestScoped
public class Mensagem {

	@Inject
	@DaRequisicao
	Pojo pojoDaRequisicao;

	@Inject
	@DaSessao
	Pojo pojoDaSessao;

	@Inject
	@DaAplicacao
	Pojo pojoDaApplicacao;

	@GET
	@Path("/requisicao")
	@Produces(MediaType.APPLICATION_JSON + ";Charset=UTF-8")
	public Response daRequisicao() {
		final String retorno = Json.createObjectBuilder()
								   .add("mensagem", pojoDaRequisicao.getMensagem())
				 				   .build()
				 				   .toString();
		
		return Response.ok(retorno).build();
	}

	@GET
	@Path("/sessao")
	@Produces(MediaType.APPLICATION_JSON + ";Charset=UTF-8")
	public Response daSessao() {
		final String retorno = Json.createObjectBuilder()
				   .add("mensagem", pojoDaSessao.getMensagem())
				   .build()
				   .toString();

		return Response.ok(retorno).build();
	}

	@GET
	@Path("/aplicacao")
	@Produces(MediaType.APPLICATION_JSON + ";Charset=UTF-8")
	public Response daApplicacao() {
		final String retorno = Json.createObjectBuilder()
				   .add("mensagem", pojoDaApplicacao.getMensagem())
				   .build()
				   .toString();

		return Response.ok(retorno).build();
	}
}
