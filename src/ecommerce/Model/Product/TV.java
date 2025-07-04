package ecommerce.Model.Product;

public final class TV extends Product implements Shippable{

    private double weight;

    public TV(double price, int quantity, String name, double weight) {
        super(price, quantity, name);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
