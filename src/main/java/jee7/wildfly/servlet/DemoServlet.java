package jee7.wildfly.servlet;

import java.io.Serializable;

import javax.inject.Inject;
import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/asyncServlet", asyncSupported = true)
public class DemoServlet extends HttpServlet implements Serializable {

	private static final long serialVersionUID = -8741952959283799021L;

	@Inject
	private ServletService servletService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		AsyncContext asyncContext = req.startAsync();
		this.servletService.readData(asyncContext);
	}
}