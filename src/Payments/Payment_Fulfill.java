package Payments;

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
    }

    @Override
    public Transaction doTransaction() {
        wallet.dedutAmount(transaction.amount);
        return transaction;
    }
}
