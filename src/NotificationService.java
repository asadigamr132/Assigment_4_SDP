public class NotificationService {
    public void sendOrderConfirmation(String customer){
        System.out.println("Order for " + customer + " is approved");
    }
    public void sendPaymentFailed(String customer) {
        System.out.println("Payment declined for " + customer);
    }
    public void sendCancellation(String customer){
        System.out.println("Order cancelled for " + customer);
    }
}
