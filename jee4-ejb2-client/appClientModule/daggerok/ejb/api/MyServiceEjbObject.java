package daggerok.ejb.api;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MyServiceEjbObject extends EJBObject {

	String sayHello(final String name) throws RemoteException;
}
