import java.util.*;


public class Program {

    public static void main(String args[]){

       
            ArrayList<Customer> bank = new ArrayList<Customer>(); 
            Display display = new Display(); //The Display class contains the methods that will be called based on user's input
          
        	display.welcomeMessage();
        	display.menue();
        	
            while(true) {
            	String option = display.getStringInput("\nChoose one of the above options:");
            	
            	switch(option) {
            	case "O":
            		display.createCustomer(bank);
            		break;
            	case "B":
            		display.checkBalance(bank);
            		break;
            	case "Q":
            		display.terminateProgram();
            		break;
            	case "W":
            		display.withdrawMoney(bank);
            		break;
            	case "D":
            		display.depositMoney(bank);
            		break;
            	default:
            		System.out.println("invalid input");
            	}
            }
    
    }
    
    
 
}