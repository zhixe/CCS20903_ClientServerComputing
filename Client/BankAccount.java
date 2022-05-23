package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// This is where bank account logic starts
public class BankAccount extends UnicastRemoteObject implements RemoteAccount 
{
	private Double sum = 0.00; // Intial value of the account
	
	public BankAccount() throws RemoteException 
	{
		super(); // Inherit from superclass method
	}

	@Override // Override a method declaration in a supertype
	public void deposit(Double amt) throws RemoteException 
	{
		sum = sum + amt;
	}

	@Override
	public void withdraw(Double amt) throws RemoteException 
	{
		sum = sum - amt;
	}

	@Override
	public Double getAmt() throws RemoteException 
	{
		return sum;
	}

	@Override
	public void set(Double amt) throws RemoteException 
	{
		sum = amt;
	}
}