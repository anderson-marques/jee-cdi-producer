package io.github.anderson.marques.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import io.github.anderson.marques.domain.Pojo;

@WebFilter("/*")
public class CDIScopesFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		Pojo pojo1 = new Pojo();
		pojo1.setMessage("Hello Request");
		req.setAttribute("pojo", pojo1);

		Pojo pojo2 = new Pojo();
		pojo2.setMessage("Hello Session");
		req.getSession().setAttribute("pojo", pojo2);

		Pojo pojo3 = new Pojo();
		pojo3.setMessage("Hello Application");
		req.getServletContext().setAttribute("pojo", pojo3);

		chain.doFilter(request, response);
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
