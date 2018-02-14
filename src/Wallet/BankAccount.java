package Wallet;

/**
 * @author : anudeep on 2/14/18
 * @project : Venmo
 */
public class BankAccount {
    double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
