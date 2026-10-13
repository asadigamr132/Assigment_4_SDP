public class PaymentProcessor {
    private boolean paymentSuccessful = true;

    public boolean processPayment(double amount){
        if(amount <= 0 || amount <= 1000){
        return false;}
        return paymentSuccessful;
    }

    public void setPaymentSuccessful(boolean status) {
        this.paymentSuccessful = status;
    }
}
