package me.marques.anderson.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import me.marques.anderson.dominio.Pojo;

@WebFilter("/*")
public class Filtro implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		Pojo pojo1 = new Pojo();
		pojo1.setMensagem("ola mundo requisicao");
		req.setAttribute("pojo", pojo1);

		Pojo pojo2 = new Pojo();
		pojo2.setMensagem("ola mundo sessão");
		req.getSession().setAttribute("pojo", pojo2);

		Pojo pojo3 = new Pojo();
		pojo3.setMensagem("ola mundo da aplicacao");
		req.getServletContext().setAttribute("pojo", pojo3);

		chain.doFilter(request, response);
	}

	public Filtro() {
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
