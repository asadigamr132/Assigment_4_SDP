public class InventoryService {
    private String productName;
    private int amount = 100;
    public boolean checkAvailability(){
        return amount > 0;
    }
    public boolean reserveStock(){
        if(amount > 0){
            amount-=1;
            return true;
        }
        return false;
    }
    public boolean releaseStock(){
        amount +=1;
        return true;
    }
}
