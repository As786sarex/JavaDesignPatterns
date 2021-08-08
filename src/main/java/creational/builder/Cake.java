package creational.builder;


import java.util.Objects;

class Cake {
    private CakeFlavour flavour;
    private boolean isWithEgg;
    private double price;

    public Cake(CakeFlavour flavour, boolean isEggLess, double price) {
        this.flavour = flavour;
        this.isWithEgg = isEggLess;
        this.price = price;
    }

    public Cake() {
    }

    public CakeFlavour getFlavour() {
        return flavour;
    }

    public void setFlavour(CakeFlavour flavour) {
        this.flavour = flavour;
    }

    public boolean isWithEgg() {
        return isWithEgg;
    }

    public void setWithEgg(boolean withEgg) {
        isWithEgg = withEgg;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cake cake = (Cake) o;
        return isWithEgg == cake.isWithEgg && Double.compare(cake.price, price) == 0 && flavour == cake.flavour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flavour, isWithEgg, price);
    }

    @Override
    public String toString() {
        return "Cake{" +
                "flavour=" + flavour +
                ", isEggLess=" + isWithEgg +
                ", price=" + price +
                '}';
    }
}
