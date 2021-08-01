package prototype;

import java.util.Objects;

public class Bicycle extends Vehicle {
    public int numberOfPedals;

    public Bicycle() {
    }

    public Bicycle(Bicycle bicycle) {
        super(bicycle);
        this.numberOfPedals = bicycle.numberOfPedals;
    }

    public void setNumberOfPedals(int numberOfPedals) {
        this.numberOfPedals = numberOfPedals;
    }

    @Override
    public IClone doClone() {
        return new Bicycle(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return maxSpeed == bicycle.maxSpeed
                && numberOfWheels == bicycle.numberOfWheels
                && numberOfPedals == bicycle.numberOfPedals;
    }
}
