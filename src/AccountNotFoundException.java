
public class AccountNotFoundException extends Exception {
	
	private String accountType;
	
	AccountNotFoundException(String accountType){
		super();
		this.accountType = accountType;
	}
	
	public String getMessage() {
		return "*******  " + accountType + " Account does not exist!   *********";
	}
	
}
