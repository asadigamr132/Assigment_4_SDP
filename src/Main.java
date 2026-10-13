import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        OrderFacade orderFacade = new OrderFacade();

        Scanner scanner = new Scanner(System.in);
        boolean result = orderFacade.placeOrder(scanner.nextLine(), scanner.nextLine(), scanner.nextDouble());
        if (result) {
            System.out.println("Order succesful! " + result);
        } else {
            System.out.println("Order failed");
        }

        orderFacade.cancelOrder(1);

        orderFacade.setPaymentSuccessful(false);
        boolean result2 = orderFacade.placeOrder("Daryn", "Taraz",5000);
        if(result2){
            System.out.println("Order succesful " + result2);
        } else{
            System.out.println("Order failed");
        }
        orderFacade.cancelOrder(4);



    }
}