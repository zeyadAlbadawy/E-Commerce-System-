public class ShippableProduct extends Products implements Shippable {
    protected double weight;

    public ShippableProduct(String name, int quantity, double price, boolean expired, double weight) {
        super(name, quantity, price, expired);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

}
