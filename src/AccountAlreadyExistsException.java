
public class AccountAlreadyExistsException extends Exception {
	
	private String accountType;
	AccountAlreadyExistsException(String accountType){
		super();
		this.accountType = accountType;
	}
	
	
	public String getMessage() {
		return "**********   " + accountType + " Account already exists.  You cannot create more than one account type!   *******";
	}
	
}
