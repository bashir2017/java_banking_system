import java.util.Arrays;

public class Customer {

        private String first;
        private String last;
        private int numOfAccount;

        Account[] accounts = new Account[3];
  

        public Customer(String first, String last){
                this.first = first;
                this.last = last;
                this.numOfAccount = 0;
        }
        
     
        //Creates a new account for a user
        public void addAccount(Account account) throws AccountAlreadyExistsException{
        		boolean accountExists = false;
        		
        		for(int i =0; i<numOfAccount; i++) {
        			//check to see if an account already exists
        			if(accounts[i].getClass().getName().equals(account.getClass().getName())) {
        				accountExists = true;
        			}
        		}
                if(accountExists){
                        throw new AccountAlreadyExistsException(account.getClass().getName());
                } else {
                        accounts[numOfAccount] = account;
                        numOfAccount += 1;
                        System.out.println("Account successfully created!");
                }
        }


        public String getFirstName(){
                return first;
        }

        public String getLastName(){
                return last;
        }

       
        
        //returns the index of account with type
        //Example, if type = "Checking", this method will return index of Checking in accounts
        public int indexOfAccount(String type) throws AccountNotFoundException {
        	
        	for(int i =0; i<numOfAccount; i++) {
           		if(accounts[i].getClass().getName().equals(type)) {
           			return i;
           		} 
           	}
        	throw new AccountNotFoundException(type);
        }
        
        
        //prints balance of account "type"
        public void balance (String type) throws AccountNotFoundException {
        	int index = indexOfAccount(type);
      
           	System.out.println("Total in " + type +" is: " + accounts[index].getBalance());
        	
        }
        
        //deposits money into a an account "type" (passed as an argument)
        public void deposit(Currency money, String type) throws AccountNotFoundException {
        	int index = indexOfAccount(type);
        	accounts[index].deposit(money);
        	System.out.println("Deposit Successful!");
        }
        
        
        //withdraws money from an account "type"
        public void withdraw(Currency money, String type) throws AccountNotFoundException, 
        														 NegativeBalanceException
        {
        	int index = indexOfAccount(type);
        	int moneyInAccount = accounts[index].getBalance().getValue();
        	if (moneyInAccount - money.getValue() < 0){
        		throw new NegativeBalanceException();
        	}
        	accounts[index].withdraw(money);
        	System.out.println("Withdrawal Successfull!!");
  
        }
}