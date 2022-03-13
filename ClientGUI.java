// Libraries
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * The Client with GUI
 */
public class ClientGUI extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	// will first hold "Username:", later on "Enter message"
	private JLabel label;
	// to hold the Username and later on the messages
	private JTextField tf;
	// to hold the server address an the port number
	private JTextField tfServer, tfPort;
	// to Logout and get the list of the users
	private JButton login, logout, whoIsIn;
	// for the chat room
	private JTextArea ta;
	// if it is for connection
	private boolean connected;
	// the Client object
	private Client client;
	// the default port number
	private int defaultPort;
	private String defaultHost;

	// Constructor connection receiving a socket number
	ClientGUI(String host, int port) {

		super("CCS20903 - Client Server Computing");
		defaultPort = port;
		defaultHost = host;
		
		// The NorthPanel with:
		JPanel northPanel = new JPanel(new GridLayout(3,1));
		// the server name and the port number
		JPanel serverAndPort = new JPanel(new GridLayout(1,5, 1, 3));
		// the two JTextField with default value for server address and port number
		tfServer = new JTextField(host);
		tfPort = new JTextField("" + port);
		tfPort.setHorizontalAlignment(SwingConstants.RIGHT);

		serverAndPort.add(new JLabel("Server Address:  "));
		serverAndPort.add(tfServer);
		serverAndPort.add(new JLabel("Port Number:  "));
		serverAndPort.add(tfPort);
		serverAndPort.add(new JLabel(""));
		// adds the Server an port field to the GUI
		northPanel.add(serverAndPort);

		// the Label and the TextField
		label = new JLabel("Enter your username below:", SwingConstants.CENTER);
		northPanel.add(label);
		tf = new JTextField("");
		tf.setBackground(Color.WHITE);
		northPanel.add(tf);
		add(northPanel, BorderLayout.NORTH);

		// The CenterPanel which is the chat room
		ta = new JTextArea("Assignment 1: Part B\nPlease login first.\n", 80, 80);
		JPanel centerPanel = new JPanel(new GridLayout(1,1));
		centerPanel.add(new JScrollPane(ta));
		ta.setEditable(false);
		add(centerPanel, BorderLayout.CENTER);

		// the 3 buttons
		login = new JButton("Login");
		login.addActionListener(this);
		logout = new JButton("Logout");
		logout.addActionListener(this);
		logout.setEnabled(false);		// have to login before being able to logout
		whoIsIn = new JButton("Logged users");
		whoIsIn.addActionListener(this);
		whoIsIn.setEnabled(false);		// have to login before being able to see who has been logged in

		JPanel southPanel = new JPanel();
		southPanel.add(login);
		southPanel.add(logout);
		southPanel.add(whoIsIn);
		add(southPanel, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450, 450);
		setVisible(true);
		tf.requestFocus();

	}

	// called by the Client to append text in the TextArea 
	void append(String str) {
		ta.append(str);
		ta.setCaretPosition(ta.getText().length() - 1);
	}
	// called by the GUI is the connection failed
	// reset the buttons, label, textfield
	void connectionFailed() {
		login.setEnabled(true);
		logout.setEnabled(false);
		whoIsIn.setEnabled(false);
		label.setText("Enter your username below:");
		tf.setText("");
		// reset port number and host name as a construction time
		tfPort.setText("" + defaultPort);
		tfServer.setText(defaultHost);
		// let the user change them
		tfServer.setEditable(false);
		tfPort.setEditable(false);
		// remove action listener after the username
		tf.removeActionListener(this);
		connected = false;
	}
		
	/*
	* Button or JTextField clicked
	*/
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		// Logout message
		if(o == logout) {
			client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
			return;
		}
		// Who's logged in message
		if(o == whoIsIn) {
			client.sendMessage(new ChatMessage(ChatMessage.WHOISIN, ""));				
			return;
		}

		// From the JTextField logics
		if(connected) {
			// just have to send the message
			client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, tf.getText()));				
			tf.setText("");
			return;
		}
		
		// connection request
		if(o == login) {
			String username = tf.getText().trim();
			// empty username ignore it
			if(username.length() == 0)
				return;
			// empty serverAddress ignore it
			String server = tfServer.getText().trim();
			if(server.length() == 0)
				return;
			// empty or invalid port number, ignore it
			String portNumber = tfPort.getText().trim();
			if(portNumber.length() == 0)
				return;
			int port = 0;
			try {
				port = Integer.parseInt(portNumber);
			}
			catch(Exception en) {
				// ignore and do nothing 
			}

			// create a new Client with GUI
			client = new Client(server, port, username, this);
			// test run the Client
			if(!client.start()) 
				return;
			tf.setText("");
			label.setText("Enter your message below:");
			connected = true;
			tf.removeKeyListener(this); // remove the key listener for different username

			// disable login button
			login.setEnabled(false);

			// enable the these buttons
			logout.setEnabled(true);
			whoIsIn.setEnabled(true);

			// disable the Server and Port JTextField
			tfServer.setEditable(false);
			tfPort.setEditable(false);

			// Action listener for when the user enter a message
			// tf.addActionListener(this); -- not used
			tf.addKeyListener(this);
		}

	}

	// Connect the client with the server
	public static void main(String[] args) {
		new ClientGUI("localhost", 1500);
	}


	// Array of responses
	String[][] chatResponses = {

		// Found : if responseIndex = 2
        // Possible greetings from users
        {"hi","hello","salam","as-salam","assalamualaikum","holla","hola"}, // index 0
        // Response from bot
        {"Hi there"}, // index 1

        // Possible inquiries from users 
        {"what is this", "what this"}, // index 2
        // Response from bot
        {"This is an assignment 1 part B."}, // index 3
        
        // Possible exit from users 
        {"quit","exit","bye"}, // index 4
        // Response from bot -- act as dummy index for index 6
        {"Thank you for using me =)"}, // index 5

		// Not found : if responseIndex = 1
        // Default invalid response
        // Response from bot
        {"I don't understand your inquiry"} // index 6

	};


	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			tf.setEditable(false);

			// Get user input
			String userInput = tf.getText();
			tf.setText(""); // clear input box
			addText("You: " + userInput); // add user input to chatbox
			userInput.trim(); // trim user input
			
			while (
				// find any exclamation mark
				userInput.charAt(userInput.length()-1) == '!' ||
				userInput.charAt(userInput.length()-1) == '.' ||
				userInput.charAt(userInput.length()-1) == '?'
			){
				// remove the last character
				userInput=userInput.substring(0,userInput.length()-1);
			}
			userInput.trim(); // trim user input again

			// Checking for any matches in array
			byte responseIndex = 0; // declare responseIndex as bit index and set initial value to 0
			/*!
			0: Checking chatResponses[][] for matches
			1: Not found
			2: Found
			*/
			
			int j = 0; // Initial index searching value set to 0

			// While searching where responseIndex is 0:
			while(responseIndex == 0){		

				// If found any matches
				if(inArray(userInput.toLowerCase(),chatResponses[j*2])){
					responseIndex = 2; // Set responseIndex to 2
					int r=(int)Math.floor(Math.random()*chatResponses[(j*2)+1].length);
					addText("\nServer: "+chatResponses[(j*2)+1][r]);

					// If found exit responses
					if (inArray(userInput.toLowerCase(),chatResponses[4])){
						try {
							Thread.sleep(1000);
							System.out.println("\nThank you for using me! =)");
							System.out.println("Exiting the program...");
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						System.exit(0);
						// setVisible(false); -- not used
						// dispose(); -- not used
					}
				}

				j++; // Search again
				// If does not found any matches
				if(j*2 == chatResponses.length-1 && responseIndex == 0){
					responseIndex = 1; // set responseIndex to 1
				}
			}
						
			/* 
			 *	Default invalid responses
			 *	If responseIndex value is 1
			 */
			if(responseIndex == 1){
				int r = (int) Math.floor(Math.random()*chatResponses[chatResponses.length-1].length);
				addText("\nServer: "+chatResponses[chatResponses.length-1][r]);
			}
			addText("\n"); // add newline after each response
		}
	}

	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			tf.setEditable(true);
		}
	}
	
	public void keyTyped(KeyEvent e){}
	
	public void addText(String str){
		ta.setText(ta.getText()+str);
	}
	
	// Check if the string is in the array
	public boolean inArray(String in,String[] str){
		boolean match=false;
		for(int i = 0; i < str.length; i++){
			if(str[i].equals(in)){
				match = true;
			}
		}
		return match;
	}

}
