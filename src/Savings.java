
public class Savings extends Account {
 
        private double rate;

        public Savings(Currency initial, double rate){
                super( initial);
                this.rate = rate;
        }

        public void deposit(Currency amount){
                balance.add(amount);
        }

        public void withdraw(Currency amount) {
                
				balance.substract(amount);
				
        }
        
        public Currency getBalance(){
        		int currentBalance = balance.getValue();
        		int balanceWithInterest = currentBalance + (currentBalance * (int)rate);
        		
        		
                return new Currency(balanceWithInterest);
        }

        public String toString(){
                return "Savings Account - " + getBalance();
        }

}