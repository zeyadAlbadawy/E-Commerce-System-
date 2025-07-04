public class Products {
    protected String name;
    protected int quantity;
    protected double price;
    protected boolean expired;

    // Initialize the contructor
    public Products(String name, int quantity, double price, boolean expired) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expired = expired;
    }

    // Set The Getter Functions
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calcPrice() {
        return price;
    }

    public boolean isExpired() {
        return expired;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }

}
