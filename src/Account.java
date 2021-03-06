
public abstract class Account {

    public Currency balance;

    public Account(Currency initialDeposit){
            this.balance = initialDeposit;
    }

    public abstract void withdraw(Currency money);

    public abstract void deposit(Currency money);


    public abstract Currency getBalance();

    public abstract String toString(); 

}
