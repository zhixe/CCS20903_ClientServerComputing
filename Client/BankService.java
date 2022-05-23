package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

// This is where bank service logic starts
public class BankService extends UnicastRemoteObject implements RemoteBank 
{
	// Create a HashMap object called accts that will store String keys and Double values
	Map<String, Double> accts = new HashMap<String, Double>();
	
	public BankService() throws RemoteException 
	{
		super(); // Inherit from superclass method
	}

	@Override // Override a method declaration in a supertype
	public void update(Double amt) throws RemoteException 
	{
		accts.put(null, amt); // Update the current amount
	}
}