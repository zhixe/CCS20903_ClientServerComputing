package Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

// This is where bank account and bank service will be invoked to communicate each other with BankView class through RMI registry
public class BankController 
{
	private RemoteBank bs;
	private RemoteAccount ba;
	private BankView view;

	public BankController() throws MalformedURLException, RemoteException, NotBoundException 
	{
		// Find the references of the remote objects
		bs = (RemoteBank) Naming.lookup("rmi://localhost/bankservice");
		ba = (RemoteAccount) Naming.lookup("rmi://localhost/bankaccount");
	}
	
	public void join(BankView view) 
	{
		// Invoke view method from BankView class
		this.view = view;
	}
	
	public void deposit() throws RemoteException
	{
		// Get and return deposit amount
		String amount = view.getAmount();
		Double amt = Double.parseDouble(amount);
		ba.deposit(amt);
		bs.update(ba.getAmt());
	}
	
	public void withdraw() throws RemoteException 
	{
		String amount = view.getAmount();
		Double amt = Double.parseDouble(amount);

		ba.withdraw(amt);
		bs.update(ba.getAmt());

		if (ba.getAmt() < 0.0) // If withdrawn money is more than 0
		{
			System.out.println("User Account Error: Not enough money to withdraw!");
		}
	}
	
	// Get and set methods
	public void showBalance() throws RemoteException 
	{
		if (ba.getAmt() >= 0.0) // Won't display amount less than 0
		{
			// Show the balance amount from the bank account
			String balance = ba.getAmt().toString();
			view.setBalance(balance);
		}
	}
}