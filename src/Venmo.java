import Payments.Payment;
import Payments.Payment_Fulfill;
import Payments.Payment_Request;

import java.util.Scanner;

/**
 * @author : anudeep on 2/14/18
 * @project : Venmo
 */
public class Venmo {
    public static void main(String[] args) {

        Venmo venmo = new Venmo();
        User user = new User(args[1], Double.valueOf(args[3]));

        while (true) {
            System.out.println("**** Menu ****");
            System.out.println("1.Get_Balance\n2.Request_Money\n3.Make_Payment\n4.Print_Transactions\n5.Print_Total_Owe_Amount\n6.Print_Total_Owe_Amount_to_Others");
            Scanner sc = new Scanner(System.in);
            String command = sc.nextLine();

            String[] req_arr;
            Payment payment;
            switch (command) {
                case "Get_Balance":
                    System.out.println("Balance=" + user.wallet.getBalance());
                    break;
                case "Request_Money":
                    req_arr = venmo.getUserData(sc);
                    payment = new Payment_Request(user.wallet, req_arr[0], Double.valueOf(req_arr[1]));
                    if (user.paymentGateway(payment)){
                        System.out.println("** Transaction Completed ** ");
                    }else {
                        System.out.println("** Transaction Failed ** ");

                    }
                    break;
                case "Make_Payment":
                    req_arr = venmo.getUserData(sc);
                    payment = new Payment_Fulfill(user.wallet, req_arr[0], Double.valueOf(req_arr[1]));
                    if (user.paymentGateway(payment)){
                        System.out.println("** Transaction Completed ** ");
                    }else {
                        System.out.println("** Transaction Failed ** ");

                    }                    break;
                case "Print_Transactions":
                    user.recentTransactions.printTransactions();
                    break;
                case "Print_Total_Owe_Amount":
                    System.out.println(user.recentTransactions.getTotalOweAmount());
                    break;
                case "Print_Total_Owe_Amount_to_Others":
                    System.out.println(user.recentTransactions.getTotalOweAmountByThem());
                    break;
            }
        }
    }

    public String[] getUserData(Scanner sc) {
        System.out.println("\t Enter user Name and amount (UserB 30)");
        // Scanner sc1 = new Scanner(System.in);
        String command1 = sc.nextLine();
        String[] req_arr = command1.split(" ");
        return req_arr;
    }
}
