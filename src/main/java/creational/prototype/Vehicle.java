package creational.prototype;

public class Vehicle implements IClone {

    public int numberOfWheels;
    public int maxSpeed;

    public Vehicle() {
    }

    public Vehicle(Vehicle vehicle) {
        if (vehicle == null)
            throw new IllegalArgumentException("car cannot be null");

        this.maxSpeed = vehicle.maxSpeed;
        this.numberOfWheels = vehicle.numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public IClone doClone() {
        return new Vehicle(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return numberOfWheels == vehicle.numberOfWheels && maxSpeed == vehicle.maxSpeed;
    }
}
