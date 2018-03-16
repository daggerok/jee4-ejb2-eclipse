package daggerok.ejb.api;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

import daggerok.ejb.api.MyServiceEjbObject;

public interface MyServiceEjbHome extends EJBHome {

	MyServiceEjbObject create() throws CreateException, RemoteException;
}
