package daggerok.ejb.impl;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MyService implements SessionBean {

	private static final long serialVersionUID = -4653289636787705783L;

	public void ejbActivate() throws EJBException, RemoteException {}
	public void ejbPassivate() throws EJBException, RemoteException {	}
	public void ejbRemove() throws EJBException, RemoteException {}
	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {}

	public void ejbCreate() {}

	public String sayHello(final String name) {
		return "hey, " + name + "!";
	}
}
