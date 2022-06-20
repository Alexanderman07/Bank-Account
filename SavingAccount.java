package defaultpackage;

public class SavingAccount extends BankAccount {
	
	//Constructs the Saving Account
	public SavingAccount(String type, Customer customer, double theBalance) {
		
		//creates the super class parent object
		super(type, customer, theBalance);
	}
	
	//applies interest
	@Override
	public void applyInterest() {
		double interest; 
		if((balance - 10000) > 0) {
			interest = (balance) * 0.05; 
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
			interest = (super.balance) * 0.05; 
		} else {
			interest = 0;
		}
		
		balance = super.balance + interest;
		System.out.println(customer.firstName + " " + customer.lastName + " Balance: $" + balance);
		return balance;
	}

}

