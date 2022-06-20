package defaultpackage;

public class BankAccountProcess {
	
	private static BankDatabase[] db = new BankDatabase[100];

	public static BankDatabase BankAccountBalance(String customername, String ssn, String acctype, String amount) {
//boolean error = false;

try {
			Customer customer = new Customer(customername, ssn);
			BankDatabase bankacct = new BankDatabase();
			float fAmt = Float.parseFloat(amount);
			bankacct.openAccount(acctype, customer, fAmt);
			
			db[0] = bankacct;
			db[0].applyInterest();
			db[0].print();
			return bankacct;
		}
		catch(Exception e) { 
			System.out.println(e.getMessage());
		}
		return null;
	}

}

