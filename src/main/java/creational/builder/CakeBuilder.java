package creational.builder;

public class CakeBuilder {
    private final Cake cake;

    public CakeBuilder() {
        this.cake=new Cake();
    }

    public static CakeBuilder builder(){
        return new CakeBuilder();
    }

    public CakeBuilder withFlavour(CakeFlavour cakeFlavour){
        this.cake.setFlavour(cakeFlavour);
        return this;
    }

    public CakeBuilder withEgg(boolean isEgg){
        this.cake.setWithEgg(isEgg);
        return this;
    }

    public CakeBuilder withPrice(double price){
        this.cake.setPrice(price);
        return this;
    }

    public Cake build(){
        return this.cake;
    }
}
