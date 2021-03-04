
public class NegativeBalanceException extends Exception {

	NegativeBalanceException(){
		super();
	}
	

	public String getMessage() {
		return "*******  Unsufficient Fund: Can't perform Withdrawal  *****";
	}
	
}
 