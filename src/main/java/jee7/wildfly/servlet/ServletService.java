package jee7.wildfly.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.servlet.AsyncContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class ServletService {

	private Logger log = LoggerFactory.getLogger(ServletService.class);

	@Asynchronous
	public void readData(AsyncContext asyncContext) {
		try {
			PrintWriter writer = asyncContext.getResponse().getWriter();
			writer.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z")
					.format(new Date()));
			writer.close();

			asyncContext.complete();
		} catch (final IOException ex) {
			this.log.error(ex.getMessage());
		}
	}
}
