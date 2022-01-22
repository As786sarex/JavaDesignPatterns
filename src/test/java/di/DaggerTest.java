package di;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DaggerTest {

    @Test
    void daggerShouldCreateObject() {
        final CarComponent carComponent = DaggerCarComponent.create();
        final CarDao carDao = carComponent.buildCar();
        final CarDao carDao1 = carComponent.buildCar();
        Assertions.assertEquals(carDao.engine,carDao1.engine);
        var arr = new int[]{1, 2, 5, 3, 4};
        Assertions.assertEquals(4,CarDao.increasing_subarray(5,arr));
        System.out.println(CarDao.increasing_subarray(5,arr));
    }
}
