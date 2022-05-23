package Client;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

// Create a GUI template for the bank view to display the information
public class BankView extends JFrame
{
	private BankController controller;
	private JPanel bottomPanel;
	private JLabel amountLabel;
	private JTextField amount;
	private JButton deposit;
	private JButton withdraw;
	private JButton show;
	private JTextField balance;

	public BankView(BankController control) throws MalformedURLException, RemoteException, NotBoundException 
	{
		// Create a frame with 300 x 300 size and panel with 200 x 200 size
		RemoteAccount ba = (RemoteAccount) Naming.lookup("rmi://localhost/bankaccount");
		this.controller = control;
		setLayout(new FlowLayout());
		setSize(300, 300);    
			
		bottomPanel = new JPanel();
		bottomPanel.setBorder(new TitledBorder("Doggo's Bank Account"));
		bottomPanel.setPreferredSize(new Dimension(200, 200));
	
		amountLabel = new JLabel("Amount");
		amount = new JTextField(10);
		deposit = new JButton("Deposit");
		deposit.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e)
		    {
		       try 
			   {
				controller.deposit();
				} 
				catch (RemoteException e1) 
				{
					System.out.println("Something went wrong with the deposit method!");
				}
		    }
		});
		withdraw = new JButton("Withdraw");
		withdraw.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e)
		    {
				try 
				{
					controller.withdraw();
					if (ba.getAmt() < 0) 
					{
						JOptionPane.showMessageDialog(null, "Dude! You didn't have enough money to withdraw!");
					}
				} 
				catch (RemoteException e1) 
				{
					System.out.println("Something went wrong with the withdraw method!");
				}
		    }
		});

		show = new JButton("Show Balance");
		show.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e)
		    {
				try 
				{
					controller.showBalance();
				} 
				catch (RemoteException e1) 
				{
					System.out.println("Something went wrong with the showBalance method!");
				}
		    }
		});
		
		balance = new JTextField(10);
		bottomPanel.add(amountLabel); bottomPanel.add(amount); bottomPanel.add(deposit);
		bottomPanel.add(withdraw); bottomPanel.add(show); bottomPanel.add(balance);
		add(bottomPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public String getAmount() 
	{ 
		return amount.getText(); 
	}

	public void setBalance(String text) 
	{ 
		balance.setText(text); 
	}

	public void setAmount(String text) 
	{
		amount.setText(text); 
	}
}