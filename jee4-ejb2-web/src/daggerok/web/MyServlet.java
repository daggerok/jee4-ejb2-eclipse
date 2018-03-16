package daggerok.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import daggerok.ejb.api.MyServiceEjbHome;
import daggerok.ejb.api.MyServiceEjbObject;

public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 2643827692067657414L;
	private static final Log log = LogFactory.getLog(MyServlet.class);

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final PrintWriter out = response.getWriter();
		final String name = request.getParameter("name");
		final MyServiceEjbObject myService = lookupMyService();
		out.println(myService.sayHello(name));
		out.close();
	}

	private MyServiceEjbObject lookupMyService() {

		try {

			final InitialContext ctx = new InitialContext();
			final Object object = ctx.lookup("java:comp/env/MyService");
			final MyServiceEjbHome home = (MyServiceEjbHome) PortableRemoteObject.narrow(object, MyServiceEjbHome.class);

			return (MyServiceEjbObject) home.create();
		}

		catch (NamingException e) { wrap(e); }
		catch (RemoteException e) { wrap(e); }
		catch (CreateException e) { wrap(e); }
		return null;
	}

	private static void wrap(final Throwable e) {
		log.error(e.getLocalizedMessage());
		throw new RuntimeException(e);
	}
}
