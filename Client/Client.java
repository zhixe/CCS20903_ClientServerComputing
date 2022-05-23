package Client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client 
{
	// This is where the GUI will be invoked
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException 
	{
		// Instantiate bank controller and view
		BankController controller = new BankController();
		BankView view = new BankView(controller);
		controller.join(view); // Invoke view in controller
	}
}
