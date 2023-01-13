package async;

public class UserReserve {
    private Smartphone smartphone;
    private int quantity;
    private double totalAmount;

    public UserReserve() {
        this.smartphone = new Smartphone();
        this.quantity = 0;
        this.totalAmount = 0;
    }

    public UserReserve(Smartphone smartphone, int quantity) {
        this.smartphone = smartphone;
        this.quantity = quantity;
        this.totalAmount = smartphone.getPrice() * quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
