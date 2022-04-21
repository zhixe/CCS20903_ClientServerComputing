import java.net.*;
import java.io.*;

public class Client 
{
    public static void main(String[] args) throws Exception 
    {
        try 
        {
            Socket socket = new Socket("127.0.0.1",5000);
            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String clientMessage = "", serverMessage = "";

            while (!clientMessage.equals("5"))
            {
                Q_00_start mainStart = new Q_00_start();
                mainStart.startMain(); 

                clientMessage = br.readLine();
                outStream.writeUTF(clientMessage);
                outStream.flush();
                
                serverMessage = inStream.readUTF();
                System.out.println(serverMessage);
            }
            socket.close();
        }

        catch (Exception e)
        {
            System.out.println("\nExiting the program.");
            System.out.println("Session has ended.");
        }
    }
}