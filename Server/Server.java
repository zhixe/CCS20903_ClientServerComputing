package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import Client.BankAccount;
import Client.BankService;
import Client.Client;

public class Server 
{

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException 
	{
		// Obtain a reference to a remote object registry on a particular host (localhost for this example)
		LocateRegistry.createRegistry(1099);
		
		// Instantiate bank account and service
		BankService serv = new BankService();
		BankAccount act = new BankAccount();
		
		// Add remote objects
		Naming.rebind("bankservice", serv);
		Naming.rebind("bankaccount", act);

		Client.main(args); // Start the client after the server has started. This is only for demo purposes.
	}
}
