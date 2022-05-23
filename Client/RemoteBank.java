package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteBank extends Remote 
{
   // Create remote objects for bank service
   public void update(Double amt) throws RemoteException;
}