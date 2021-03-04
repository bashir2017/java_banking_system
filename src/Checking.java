
public class Checking extends Account {


        public Checking(Currency initialAmount){
                super(initialAmount);
            
        }

        public void deposit(Currency amount){
                balance.add(amount);
           
        }

        public void withdraw(Currency amount){
                balance.substract(amount);
               
        }

        public Currency getBalance(){
                return balance;
        }

        public String toString() {
                return "Checking Account - "+ getBalance();
        }

}