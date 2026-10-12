public class ShippingService {

    public void createShipment(String customer, String address){
        System.out.println("Shipment created for " + customer + " to " + address);
    }

    public void cancelShipment(){
        System.out.println("The shipment is cancelled");
    }
}
