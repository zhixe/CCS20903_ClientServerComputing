package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteAccount extends Remote 
{
   // Create remote objects for bank account to communicate with the server
   public void deposit(Double amt) throws RemoteException;
   public void withdraw(Double amt) throws RemoteException;
   public Double getAmt() throws RemoteException;
   public void set(Double amt) throws RemoteException;
}
