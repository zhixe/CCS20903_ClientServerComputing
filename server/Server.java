package server;
import java.net.*;
import java.io.*;

public class Server 
{
    public static void main(String[] args) throws Exception 
    {
        try (ServerSocket server = new ServerSocket(5000))
        {
            int counter = 0;
            System.out.println("Server is running...");

            // Keep listening for a connection request.
            while (true) 
            {
                counter++;
                Socket serverClient=server.accept();  // Server accept the client connection request.
                System.out.println(" >> " + "Client " + counter + " started!");
                ServerClientThread sct = new ServerClientThread(serverClient, counter); // Send the request to a separate thread.
                sct.start(); // Start the server client thread.
            }
        }
        catch (Exception e) // Catch any exception.
        {
            System.out.println(e); // Print the error message.
        }
    }
}

class ServerClientThread extends Thread 
{
    Socket serverClient; // Define a socket variable.
    int clientNo, squre;

    // Constructor to initialize the socket and client number.
    ServerClientThread (Socket inSocket, int counter) 
    {
        serverClient = inSocket;
        clientNo = counter;
    }

    public void run() 
    {
        try 
        {
            // Create input and output streams.
            DataInputStream inStream = new DataInputStream (
                serverClient.getInputStream()
                );
            DataOutputStream outStream = new DataOutputStream (
                serverClient.getOutputStream()
                );

            // Set initial message to empty value.
            String clientMessage = "", serverMessage = "";

            // Read the client message.
            while (!clientMessage.equals("exit")) 
            {
                clientMessage = inStream.readUTF();
                outStream.writeUTF(serverMessage);
                outStream.flush();
            }

            inStream.close();
            outStream.close();
            serverClient.close();
        } 

        catch (Exception ex) 
        {
            System.out.println(ex);
        } 

        finally 
        {
            System.out.println("Client " + clientNo + " has disconnected! ");
        }
    }
}

