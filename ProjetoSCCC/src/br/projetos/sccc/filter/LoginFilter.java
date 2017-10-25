package br.projetos.sccc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
	FilterChain chain) throws IOException, ServletException {

	HttpServletRequest req = (HttpServletRequest) request;
	HttpServletResponse resp = (HttpServletResponse) response;

	Object logged = req.getSession().getAttribute("FUNCIONARIO");

	if (logged == null) {

	resp.sendRedirect("/ProjetoSCCC/Login/login.xhtml");


	}

	try {
	chain.doFilter(request, response);
	} catch (Throwable t) {
	t.printStackTrace();
	}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}
