public class Order {
    private int orderId;
    private String customer;
    private String address;
    private double amount;
    private String status;

    public Order(int orderId, String customer, String address, double amount) {
        this.orderId = orderId;
        this.customer = customer;
        this.address = address;
        this.amount = amount;
        this.status = "PLACED";
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public String getAddress() {
        return address;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
