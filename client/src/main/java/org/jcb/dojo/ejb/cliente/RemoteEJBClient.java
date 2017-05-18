
package org.jcb.dojo.ejb.cliente;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jcb.dojo.ejb.server.atm.BankDatabase;

public class RemoteEJBClient {

	public static BankDatabase lookupRemoteBankDatabase() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		return (BankDatabase) context.lookup("ejb:/server-side/BankDatabaseBean!" + BankDatabase.class.getName());
	}
	
	public static BankDatabase lookupRemoteBankDataBaseStateful() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		return (BankDatabase) context.lookup("ejb:/server-side/BankDatabaseStatefulBean!"
				+ BankDatabase.class.getName() + "?stateful");
	}

}