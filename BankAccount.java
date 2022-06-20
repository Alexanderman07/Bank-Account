package defaultpackage;

public abstract class BankAccount {
	long accountnum;
	String firstName; 
	String lastName; 
	String ssn;
	Customer customer;
	double balance; 

//Constructor
public BankAccount(String type, Customer customer, double theBalance) {
		
		balance = theBalance;
		accountnum = (long)(Math.random() * 9000000000L + 1000000000L);
		System.out.println("Successfully created " + type + " account for " + customer.firstName + " " + customer.lastName + " Account Number: " + accountnum);
		
	}

//Makes a deposit in the Customer's account
public void deposit(double amount) {
		balance += amount;
		System.out.println(customer.firstName + " " + customer.lastName + " Deposited: $" + amount + " Current Balance: $" + balance);
	}

//Makes a withdraw in the Customer's account
public void withdraw(double amount) { 
		balance -= amount;
		if(balance > 0) {			
			System.out.println(customer.firstName + " " + customer.lastName + " withrew: $" + amount + ". Current Balance: $" + balance );
		} else {
			System.out.println("Unable to withdraw: $" + amount + " for " + customer.firstName + " " + customer.lastName + " due to insufficent funds");
		}
		
	}

abstract void applyInterest();

public double checkBalance() {
System.out.println(customer.firstName + " " + customer.lastName + " Balance: $" + balance);
		return balance;
	}
}

