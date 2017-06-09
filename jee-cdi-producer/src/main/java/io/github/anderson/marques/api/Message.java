package io.github.anderson.marques.api;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.github.anderson.marques.domain.FromApplicationScope;
import io.github.anderson.marques.domain.FromRequestScope;
import io.github.anderson.marques.domain.FromSessionScope;
import io.github.anderson.marques.domain.Pojo;

@Path("/message")
@RequestScoped
public class Message {

	@Inject
	@FromRequestScope
	private Pojo pojoFromRequest;

	@Inject
	@FromSessionScope
	private Pojo pojoFromSession;

	@Inject
	@FromApplicationScope
	private Pojo pojoFromApplication;

	@GET
	@Path("/request")
	@Produces(MediaType.APPLICATION_JSON + ";Charset=UTF-8")
	public Response fromRequest() {
		final String response = Json.createObjectBuilder()
								   .add("message", pojoFromRequest.getMessage())
				 				   .build()
				 				   .toString();
		
		return Response.ok(response).build();
	}

	@GET
	@Path("/session")
	@Produces(MediaType.APPLICATION_JSON + ";Charset=UTF-8")
	public Response fromSession() {
		final String response = Json.createObjectBuilder()
				   .add("message", pojoFromSession.getMessage())
				   .build()
				   .toString();

		return Response.ok(response).build();
	}

	@GET
	@Path("/application")
	@Produces(MediaType.APPLICATION_JSON + ";Charset=UTF-8")
	public Response fromApplication() {
		final String response = Json.createObjectBuilder()
				   .add("message", pojoFromApplication.getMessage())
				   .build()
				   .toString();

		return Response.ok(response).build();
	}
}
