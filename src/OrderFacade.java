public class OrderFacade {
    private final InventoryService inventoryService;
    private final PaymentProcessor paymentProcessor;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public OrderFacade(InventoryService inventoryService,PaymentProcessor paymentProcessor, NotificationService notificationService, ShippingService shippingService){
        this.inventoryService = inventoryService;
        this.notificationService = notificationService;
        this.paymentProcessor = paymentProcessor;
        this.shippingService = shippingService;
    }


    public boolean placeOrder(String customer, String address, double amount) {
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
            return true;
        }

        notificationService.sendPaymentFailed(customer);
        inventoryService.releaseStock();
        return false;
    }

}
