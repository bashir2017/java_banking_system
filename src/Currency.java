
public class Currency {

    private int cents;

    public Currency(){
            this.cents = 0;
    }


    public Currency(int cents){
            this.cents = cents;
    }

    public int getValue(){
    		//double dollars = cents/100.00;
            return cents;
    }

    public Currency add(Currency rhs){
            this.cents += rhs.cents; 
            return this;
    }

    public Currency substract(Currency rhs) {
    	
            this.cents -= rhs.cents;
            return this;
    }

    public String toString(){
            double  dollars = cents/100.00;
            return "$ " + dollars ;
    }



}