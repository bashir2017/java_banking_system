
public class CustomerNotFoundException extends Exception{
	
	private String first;
	private String last;

	CustomerNotFoundException(String first, String last){
		super();
		this.first = first;
		this.last = last;
	}
	
	public String getMessage() {
		return "****** "+ first + " " + last +" is not a customer!  *****" ;
	}
}
