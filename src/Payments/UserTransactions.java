package Payments;

import java.util.ArrayList;

/**
 * @author : anudeep on 2/14/18
 * @project : Venmo
 */
public class UserTransactions extends ArrayList<Transaction> {

    public double getTotalOweAmount(){
        double amount=0;
        for(Transaction transaction:this){
            if(transaction.type== Transaction.Type.REQUEST){
                amount+=transaction.getAmount();
            }
        }
        return amount;
    }

    public double getTotalOweAmountByThem(){
        double amount=0;
        for(Transaction transaction:this){
            if(transaction.type== Transaction.Type.FULFILL){
                amount+=transaction.getAmount();
            }
        }
        return amount;
    }

    public void printTransactions(){
        forEach(transaction -> System.out.println(transaction));
    }

}
