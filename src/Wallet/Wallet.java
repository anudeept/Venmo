package Wallet;

/**
 * @author : anudeep on 2/14/18
 * @project : Venmo
 */
public class Wallet {

    private double balance;

    public Wallet(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean addAmount(double amount){
        balance+=amount;
        return true;
    }

    public boolean dedutAmount(double amount){
        balance-=amount;
        return true;
    }

}
