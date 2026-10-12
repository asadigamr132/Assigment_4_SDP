public class PaymentProcessor {
    private boolean paymentSuccessful = true;

    public boolean processPayment(double amount){
        if(amount <= 0){
        return false;}
        return paymentSuccessful;
    }
}
