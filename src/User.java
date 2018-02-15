import Payments.Payment;
import Transactions.UserTransactions;
import Wallet.*;

/**
 * @author : anudeep on 2/14/18
 * @project : Venmo
 */
public class User {

    private String user_Name;
    Wallet wallet;
    BankAccount bankAccount;
    UserTransactions recentTransactions;

    public User(String user_Name, double balance) {
        this.user_Name = user_Name;
        this.wallet = new Wallet(balance);
        recentTransactions = new UserTransactions();
        bankAccount = new BankAccount();
    }

    public void transfer_Wallet_Bank(double amount) {
        wallet.dedutAmount(amount);
        bankAccount.addAmount(amount);
    }

    public void transfer_Bank_Wallet(double amount) {
        bankAccount.dedutAmount(amount);
        wallet.addAmount(amount);
    }

    public boolean paymentGateway(Payment payment) {
        try {
            recentTransactions.add(payment.doTransaction());
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

}
