public class Main {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryService();
        NotificationService notificationService = new NotificationService();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        ShippingService shippingService = new ShippingService();

        OrderFacade orderFacade = new OrderFacade(
                inventoryService, paymentProcessor, notificationService, shippingService
        );
        boolean result = orderFacade.placeOrder("Maqsat", "E319AA", 5000);
        if (result) {
            System.out.println("Order succesful! " + result);
        } else {
            System.out.println("Order failed");
        }
    }
}