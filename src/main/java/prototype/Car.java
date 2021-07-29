package prototype;

import java.util.Objects;

public class Car extends Vehicle {
    public EngineType engineType;

    public Car() {
    }

    public Car(Car car) {
        super(car);
        this.engineType = car.engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    @Override
    public IClone doClone() {
        return new Car(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return maxSpeed == car.maxSpeed && numberOfWheels == car.numberOfWheels && engineType == car.engineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(engineType);
    }
}
