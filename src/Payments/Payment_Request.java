package Payments;

import Payments.Payment;
import Wallet.Wallet;

/**
 * @author : anudeep on 2/14/18
 * @project : Venmo
 */
public class Payment_Request implements Payment {

    Transaction transaction;
    Wallet wallet;

    public  Payment_Request(Wallet wallet, String user, double amount) {
        transaction = new Transaction(user, amount, Transaction.Type.REQUEST);
        this.wallet=wallet;
    }

    @Override
    public Transaction doTransaction() {
        wallet.addAmount(transaction.amount);
        return transaction;
    }
}
