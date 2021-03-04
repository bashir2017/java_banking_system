import java.util.Date;

public class CD extends Account {

        private double rate;
        private Date date;  //saving the date the account was created to check if withdrawal is allowed after a time lapse.

        public CD(Currency initialAmount, double rate){
                super(initialAmount);
                this.rate = rate;
                date = new Date();
        }

        public void deposit(Currency amount){
        	//doesn't allow deposit
        	System.out.println("Can not deposit to a CD Account");
        }

        //Allows withdrawal only after a particular time (in this case(10^7 seconds or three months)
        public void withdraw(Currency amount){
        	Date currentDate = new Date();
        	long miliSecondsTimeDifference = currentDate.getTime()- date.getTime();
        	if(miliSecondsTimeDifference > 1.57 * Math.pow(10, 7)) {
        		balance.substract(amount);
        	} else {
        		System.out.println("It's too early to withdraw money!");
        	}
        }

        
        public Currency getBalance() {
        	return balance;
        }
        
        
        public String toString() {
            return "CD Account - "+ getBalance();
    }

}