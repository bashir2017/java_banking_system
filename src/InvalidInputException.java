
public class InvalidInputException extends Exception {

	private String input;
	InvalidInputException(String input){
		super();
		this.input = input;
	}
	
	
	public String getMessage() {
		return "Invalid Input -- "+input + " is not recognized!";
	}
}
 