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
        System.out.println("Hello Venmo");
        for (String arguments : args) {
            System.out.println(arguments);
        }

        User user = new User(args[1], Double.valueOf(args[3]));

        while (true) {
            System.out.println("1.GetBalance\n2.Request UserB 30");
            Scanner sc = new Scanner(System.in);
            String command = sc.nextLine();


            Scanner sc1;
            String command1;
            String[] req_arr;
            Payment payment;
            switch (command) {
                case "GetBalance":
                    System.out.println("Balance=" + user.wallet.getBalance());
                    break;
                case "Request Money":
                    System.out.println(" Enter user Name and amount (UserB 30)");
                    sc1 = new Scanner(System.in);
                    command1 = sc.nextLine();
                    System.out.println(command1);
                    req_arr = command1.split(" ");
                    payment = new Payment_Request(user.wallet, req_arr[0], Double.valueOf(req_arr[1]));
                    user.paymentGateway(payment);
                    break;
                case "Make Payment":
                    System.out.println(" Enter user Name and amount (UserB 30)");
                    sc1 = new Scanner(System.in);
                    command1 = sc.next();
                    req_arr = command1.split(" ");
                    payment = new Payment_Fulfill(user.wallet, req_arr[0], Double.valueOf(req_arr[1]));
                    user.paymentGateway(payment);
                    break;
            }
        }
    }
}
