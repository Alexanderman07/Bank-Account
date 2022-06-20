package defaultpackage;

public class BankDatabase {
	
	public String type;
	public Customer customer;
	public float deposit;
	//private String ssn;
	public BankAccount accountnum;
	
	public BankDatabase() {
		
	}
	
	public void openAccount(String accounttype, Customer accountcust, float accountdeposit) {
		
		type = accounttype;
		customer = accountcust;
		deposit = accountdeposit;
		if(type.equals("Checking")) {
			accountnum = new CheckingAccount(type, customer, deposit);
		} else if(type.equals("Saving")) {
			accountnum = new SavingAccount(type, customer, deposit);
		} else {
			accountnum = new SavingAccount(type, customer, deposit);
		}
	}
	
	public void print() {
		System.out.println("" + customer.firstName + " " + customer.lastName + ", Accn #: " + accountnum.accountnum + ", Balance $" + accountnum.balance);
	}
	
	public void applyInterest() {
		accountnum.applyInterest();
	}

}

