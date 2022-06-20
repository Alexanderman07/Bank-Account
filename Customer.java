package defaultpackage;

public class Customer {
	public String customername;
	public String firstName;
	public String lastName;
	public String ssn;
	public BankAccount accountnum;

//Constructor
public Customer(String customername, String ssn) {
		String [] firstlastname = customername.split(" ");
		String firstName = firstlastname[0];
		String lastName = firstlastname[1];
		this.firstName = firstName;
		this.lastName = lastName;
		if(isSsnValid(ssn))
		{
			this.ssn = ssn;
		} else {
			this.ssn = "xxx-xx-xxxx";
			System.out.println("Successfully created account for " + firstName + " " + lastName + ". Invalid SSN!");
		}
		
	}

public String toString() {
		return firstName + " " + lastName;
	}
	
	 static boolean isSsnValid(String ssn) {
		
		if(ssn.length() != 11) { 
			return false;
		}
		
		for(int i = 0; i < ssn.length(); i++) {
			char c = ssn.charAt(i);
			if(i == 3 || i == 6) {
				if(c != '-') {
					return false;
				}
			} 
			else if(!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}
}

