import java.util.ArrayList;
import java.util.List;

public class OrderFacade {
    private final InventoryService inventoryService;
    private final PaymentProcessor paymentProcessor;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    private final List<Order> orders = new ArrayList<>();
    private int nextOrderId = 1;
    public OrderFacade(){
        this.inventoryService = new InventoryService();
        this.notificationService = new NotificationService();
        this.paymentProcessor = new PaymentProcessor();
        this.shippingService = new ShippingService();
    }

    public void setPaymentSuccessful(boolean status){
        paymentProcessor.setPaymentSuccessful(status);
    }


    public boolean placeOrder(String customer, String address, double amount) {
        if(amount <= 0){
            System.out.println("The amount can`t be negative");
            return false;
        }
        if (!inventoryService.checkAvailability()) {
            System.out.println("The product is out of stock");
            return false;
        }

        if (!inventoryService.reserveStock()) {
            System.out.println("Can't reserve the product");
            return false;
        }

        if (paymentProcessor.processPayment(amount)) {
            shippingService.createShipment(customer, address);
            notificationService.sendOrderConfirmation(customer);
            Order order = new Order(nextOrderId,customer,address,amount);
            orders.add(order);
            nextOrderId++;
            return true;
        }

        notificationService.sendPaymentFailed(customer);
        inventoryService.releaseStock();
        return false;
    }



    public void cancelOrder(int orderId){
        boolean found = false;
        for (Order order : orders){
            if(orderId == order.getOrderId()){
                found = true;
                if(order.getStatus().equals("PLACED")){
                    shippingService.cancelShipment();
                    inventoryService.releaseStock();
                    order.setStatus("CANCELLED");
                    notificationService.sendCancellation(order.getCustomer());
                    return;
                }
                else{
                    System.out.println("The order cannot be canceled, it is not placed");
                }

                return;
            }
            if(!found) {
                System.out.println("Such ID doesn't exist");
            }

        }
    }

}
