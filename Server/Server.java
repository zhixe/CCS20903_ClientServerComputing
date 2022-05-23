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
	// Initialization of the RMI Registry
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException 
	{
		// Obtain references to remote objects registry on a particular host (localhost for this example)
		LocateRegistry.createRegistry(1099);
		
		// Objects of the remote interface implementation 
		BankService serv = new BankService();
		BankAccount act = new BankAccount();
		
		// Binding the remote objects 
		Naming.rebind("bankservice", serv);
		Naming.rebind("bankaccount", act);

		Client.main(args); // Start the client after the server has started for demo purposes.
	}
}
