package defaultpackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")

public class CustomerBankAccountFrame extends JFrame {
	
	private JTextField monthlyInvestmentField;
	private JTextField yearlyInterestRateField;
	private JTextField yearsField;
	private JTextField amountField;
	private JTextField accnField;
	private JTextField futureValueField;
	private JButton calculateButton;
	private JButton exitButton;
	
	public CustomerBankAccountFrame() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			System.out.println(e);
		}
		
		initComponents();
		setTitle("Alexander Manjarrez's Bank Account Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setVisible(true);
		
	}
	
	private void initComponents() { 
		monthlyInvestmentField = new JTextField();
		yearlyInterestRateField = new JTextField();
		yearsField = new JTextField();
		accnField = new JTextField();
		futureValueField = new JTextField();
		amountField = new JTextField();
		
		futureValueField.setEditable(false);
		accnField.setEditable(false);
		Dimension dim = new Dimension(300, 20);
		monthlyInvestmentField.setPreferredSize(dim);
		yearlyInterestRateField.setPreferredSize(dim);
		yearsField.setPreferredSize(dim);
		amountField.setPreferredSize(dim);
		accnField.setPreferredSize(dim);
		futureValueField.setPreferredSize(dim);
		monthlyInvestmentField.setMinimumSize(dim);
		yearlyInterestRateField.setMinimumSize(dim);
		yearsField.setMinimumSize(dim);
		amountField.setMinimumSize(dim);
		accnField.setMinimumSize(dim);
		futureValueField.setMinimumSize(dim);
		
		calculateButton = new JButton("Create Account & Show Balance");
		exitButton = new JButton("Exit");
		
		calculateButton.addActionListener((ActionEven) -> {
			computeButtonClicked();
		});
		
		exitButton.addActionListener((ActionEven) -> {
			exitButtonClicked();
		});

		//JLabel and JTextField panel
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new GridBagLayout());
		
		dataPanel.add(new JLabel("Customer Name"), getConstraints(0, 0, GridBagConstraints.LINE_START));
		
		dataPanel.add(monthlyInvestmentField, getConstraints(1, 0, GridBagConstraints.LINE_START));
		
		dataPanel.add(new JLabel("SSN: "), getConstraints(0, 1, GridBagConstraints.LINE_START));
		
		dataPanel.add(yearlyInterestRateField, getConstraints(1, 1, GridBagConstraints.LINE_START));
		
		dataPanel.add(new JLabel("Account Type: "), getConstraints(0, 2, GridBagConstraints.LINE_START));
		
		dataPanel.add(yearsField, getConstraints(1, 2, GridBagConstraints.LINE_START));
		
		dataPanel.add(new JLabel("Amount: "), getConstraints(0, 3, GridBagConstraints.LINE_START));
		
		dataPanel.add(amountField, getConstraints(1, 3, GridBagConstraints.LINE_START));
		
		dataPanel.add(new JLabel("New Account: "), getConstraints(0, 4, GridBagConstraints.LINE_START));
		
		dataPanel.add(accnField, getConstraints(1, 4, GridBagConstraints.LINE_START));
		
		dataPanel.add(new JLabel("Balance: "), getConstraints(0, 5, GridBagConstraints.LINE_START));
		
		dataPanel.add(futureValueField, getConstraints(1, 5, GridBagConstraints.LINE_START));
		
		add(dataPanel, BorderLayout.CENTER);
		
		//JButton panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(calculateButton);
		buttonPanel.add(exitButton);
		add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
	}
	
	//returns GridBagContraints objects
	private GridBagConstraints getConstraints(int x, int y, int anchor) { 
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 0, 5);
		c.gridx = x;
		c.gridy = y;
		c.anchor = anchor;
		return c;
		
	}
	
	private void computeButtonClicked() {
		
		boolean error = false;
		String customername;
		String ssn;
		String acctype;
		String amount;
		try { 
			boolean errorSSN = validateSSN();
			customername = monthlyInvestmentField.getText();
			ssn = yearlyInterestRateField.getText();
			acctype = yearsField.getText();
			amount = amountField.getText();
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			BankDatabase bankacct = BankAccountProcess.BankAccountBalance(customername, ssn, acctype, amount);
			
			String sAccn = "Acc: " + String.valueOf(bankacct.accountnum.accountnum);
			accnField.setText(sAccn);
			futureValueField.setText(currency.format(bankacct.accountnum.balance));
			
			if(!errorSSN) { 
				yearlyInterestRateField.setText("");
			}
			
		}
		
		catch (NumberFormatException ex) { 
			JOptionPane.showMessageDialog(this, "You have entered an invalid number. Please try again.", "Invalid Number", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void exitButtonClicked() {
		System.exit(0);
	}
	
	boolean validateSSN() {
		String ssn = yearlyInterestRateField.getText();
		int change;
		//String amount = amountField.getText();
		//boolean InvalidSSN = Customer.isSsnValid(ssn);
		if(!Customer.isSsnValid(ssn)) { 
			JOptionPane.showMessageDialog(this, "Invalid SSN.", "Missing Fields", JOptionPane.INFORMATION_MESSAGE);
			yearlyInterestRateField.setText("");
			return false;
		}
		else { try { 
				
				change = Integer.parseInt(amountField.getText());
			 }
			
			 
		catch (NumberFormatException ex) { 
			JOptionPane.showMessageDialog(this, "The data entered in the price field is invalid.", "Invalid Price", JOptionPane.INFORMATION_MESSAGE);
			amountField.setText("");
			return false;
		}
		return true;
	}
	
}
}

