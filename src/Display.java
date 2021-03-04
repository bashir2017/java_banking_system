import java.util.ArrayList;
import java.util.Scanner;

public class Display {
	
	//Displays Welcome Message
	 public static void welcomeMessage() {
		  System.out.println("********* Welcome To Bashir Banking Platform *********\n");
	  }
	 
	 
	 //Displays Menu options 
	  public void menue() {
		  System.out.println("Menue options:\n");
		  System.out.println("O. Become a new customer or create a new account");
		  System.out.println("B. Check Balance");
		  System.out.println("W. Withdraw Money");
		  System.out.println("D. Deposit Money");
		  System.out.println("Q. Exit\n");
	  }
	  
	  
	  //this is a helper method that will prompt a user for input and returns the user's input. 
	  public  String getStringInput(String prompt) {
		 System.out.println(prompt);
		 Scanner userInputObj = new Scanner(System.in);
		 String input =  userInputObj.next();
		 
		 return input.trim(); 
	  }
	  
	  //helper method that will accept an account type as a string and returns a new account object of that type. 
	  public  Account createNewAccount(String type) throws InvalidInputException {
		  String initialDeposit = getStringInput("How much money are you initially depositing today?");
		  Currency currency = dollarToCurrency(initialDeposit);
		  
		  switch(type) {
		  case "Checking":
			  return new Checking(currency);
		  case "Savings":
			  int savingsRate = Integer.parseInt(getStringInput("What's the rate?"));
			  return new Savings(currency, savingsRate/100);
		  case "CD":
			  int cdRate = Integer.parseInt(getStringInput("What's the rate?"));
			  return new CD(currency, cdRate/100);
		  default:
			  throw new InvalidInputException(type);
		  }
	  }
	  
	  //creates a new customer or a new account for an existing customer. 
	  public void createCustomer(ArrayList<Customer> bank)  {
		 System.out.println("Welcome!!");
		 String first = getStringInput("What is your first name? ");
		 String last = getStringInput("What is your last name? ");
		 String accountType = getStringInput("Account type: Checking, Savings, or CD: ");
		
		 Account account;
		 
		 try { 
			 int index = findCustomer(bank, first, last); //will return an exception if the customer doesn't exist; move into the catch block to create a new customer
			 										
			try {
				account = createNewAccount(accountType); //will return an exception if the account type already exists. 
				try {
					bank.get(index).addAccount(account);
				} catch (AccountAlreadyExistsException e) {
					System.out.println(e.getMessage());
				}
			} catch (InvalidInputException e1) {
				System.out.println(e1.getMessage());
			}
			
		} catch (CustomerNotFoundException e2) {
			bank.add(new Customer(first, last));
			
			try {
				account = createNewAccount(accountType);
				try {
					bank.get(bank.size()-1).addAccount(account);
				} catch (AccountAlreadyExistsException e) {
					System.out.println(e.getMessage());
				}
			} catch (InvalidInputException e1) {
				System.out.println(e1.getMessage());
			}
		}
		 
	  }
	  
	  
	  //helper method that returns a customer object based on the user's input of first and last name 
	  public Customer customerAccounts(ArrayList<Customer> bank) throws CustomerNotFoundException {
		  String first = getStringInput("Your First Name:");
		  String last = getStringInput("Your Last Name:");
		 
		  int index = findCustomer(bank, first, last);
		  
		  return bank.get(index);		  
	  }
	  
	  
	  //prints a balance for a particular account based on the user's input of name and account type; 
	  public void checkBalance(ArrayList<Customer> bank) {
		  Customer accounts = null;
		try {
			accounts = customerAccounts(bank);
			String type = getStringInput("Account Type:");
			 try {
				accounts.balance(type);
			} catch (AccountNotFoundException e) {
				System.out.println(e.getMessage());
			}
		} catch (CustomerNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		  
	  }
	  
	  
	  //helper method that returns a customer bank accounts based on the first and last name which are passed as arguments.
	  public int findCustomer(ArrayList<Customer> bank, String first,String last) throws CustomerNotFoundException {
		  for(int i=0; i<bank.size(); i++ ) {
			  if(bank.get(i).getFirstName().equals(first) && bank.get(i).getLastName().equals(last))
				  return i;
		  }
		  throw new CustomerNotFoundException(first, last);
	  }

	  
	  //withdraws money from a particular account;
	  //method prompts user for name and account type and amount to withdraw.
	  public void withdrawMoney(ArrayList<Customer> bank) {
		  Customer accounts = null;
		try {
			accounts = customerAccounts(bank);
			String type = getStringInput("Account Type:");
			  String moneyString =getStringInput("How much you want to withdraw?");
			  Currency currency = dollarToCurrency(moneyString);
			  try {
				accounts.withdraw(currency, type);
			} catch (AccountNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (NegativeBalanceException e) {
				System.out.println(e.getMessage());
			}
		} catch (CustomerNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		  
	  }
	  
	  //method that deposits money into a particular account based on user input.
	  public void depositMoney(ArrayList<Customer> bank){
		  Customer accounts = null;
		try {
			accounts = customerAccounts(bank);
			  String type = getStringInput("Account Type:");
			  String moneyString =getStringInput("How much you want to Deposit?");
			  Currency currency = dollarToCurrency(moneyString);
			  try {
				  accounts.deposit(currency, type);
			  } catch(AccountNotFoundException e) {
				  System.out.println(e.getMessage());
			  }
		} catch (CustomerNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		  
	  }
	  
	  //takes in a dollar string and returns the equivalent in Currency object. 
	  public Currency dollarToCurrency(String Dollar) {
		  int money = Integer.parseInt(Dollar) * 100;
		  Currency currency = new Currency(money);
		  return currency;
	  }
	  public void terminateProgram() {
		  System.exit(0);
	  }
	  
	
}
