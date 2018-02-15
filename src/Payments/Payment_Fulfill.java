package Payments;

import Transactions.Transaction;
import Wallet.Wallet;

/**
 * @author : anudeep on 2/14/18
 * @project : Venmo
 */
public class Payment_Fulfill implements Payment {
    
    Transaction transaction;
    Wallet wallet;

    public  Payment_Fulfill(Wallet wallet, String user, double amount) {
        transaction = new Transaction(user, amount, Transaction.Type.FULFILL);
        this.wallet=wallet;
    }

    @Override
    public Transaction doTransaction() {
        wallet.dedutAmount(transaction.getAmount());
        return transaction;
    }
}
