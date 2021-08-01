package creational.prototype;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import prototype.Bicycle;
import prototype.Car;
import prototype.EngineType;
import prototype.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class PrototypePatternTest {

    @Test
    public void checkIfVehicleClonesAreDifferentButSameContent(){
        Vehicle vehicle=new Vehicle();
        vehicle.setMaxSpeed(400);
        vehicle.setNumberOfWheels(4);
        Vehicle vehicleClone = (Vehicle) vehicle.doClone();
        Assertions.assertThat(vehicleClone.equals(vehicle))
                .isTrue();
        Assertions.assertThat(vehicleClone==vehicle)
                .isFalse();
        vehicle.setNumberOfWheels(5);
        Vehicle vehicleClone2 = (Vehicle) vehicle.doClone();
        Assertions.assertThat(vehicleClone.equals(vehicleClone2))
                .isFalse();
    }

    @Test
    public void checkIfCarClonesAreDifferentButSameContent(){
        Car car=new Car();
        car.setEngineType(EngineType.DIESEL);
        car.setMaxSpeed(100);
        car.setNumberOfWheels(4);
        List<Car> cars=new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            cars.add((Car) car.doClone());
        }
        Assertions.assertThat(cars).anyMatch(car1 -> car1.equals(car));
        Assertions.assertThat(cars).allMatch(car1 -> car1!=car);
    }

    @Test
    public void checkIfBicycleClonesAreDifferentButSameContent(){
        Bicycle bicycle=new Bicycle();
        bicycle.setNumberOfPedals(2);
        bicycle.setMaxSpeed(100);
        bicycle.setNumberOfWheels(4);
        List<Bicycle> bicycles=new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            bicycles.add((Bicycle) bicycle.doClone());
        }
        Assertions.assertThat(bicycles).anyMatch(bicycle1 -> bicycle1.equals(bicycle));
        Assertions.assertThat(bicycles).allMatch(bicycle1 -> bicycle1!=bicycle);
    }
}
