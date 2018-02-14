package Transactions;

/**
 * @author : anudeep on 2/14/18
 * @project : Venmo
 */
public class Transaction {
   String user_Name;
   double amount;
   Type type;

    public Transaction(String user_Name, double amount,Type type) {
        this.user_Name = user_Name;
        this.amount = amount;
        this.type=type;
    }

    public String getUser_Name() {
        return user_Name;
    }



    public double getAmount() {
        return amount;
    }



    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "user_Name='" + user_Name + '\'' +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }

    public enum Type{
        REQUEST,FULFILL
    }
}
