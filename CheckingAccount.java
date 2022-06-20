package defaultpackage;

public class CheckingAccount extends BankAccount {

	//Constructs the Checking Account
	
	public CheckingAccount(String type, Customer customer, double theBalance) {

		//creates the super class parent object
		super(type, customer, theBalance);
	}

	//applies interest
	@Override
	public void applyInterest() { 
		double interest; 
		if((balance - 10000) > 0) {
			interest = (balance - 10000) * 0.02;
		} else {
			interest = 0;
		}
		balance = balance + interest;
	}

	//checks and returns the balance
	@Override 
	public double checkBalance() { 
		double interest;
		if((super.balance - 10000) > 0) {
			interest = (super.balance - 10000) * 0.02;	
		} else {
			interest = 0;
		}
		
		balance = super.balance + interest;
		System.out.println(customer.firstName + " " + customer.lastName + " Balance: $" + balance);
		return balance;
	}

}

