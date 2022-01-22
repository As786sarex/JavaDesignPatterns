import di.CarComponent;
import di.CarDao;
import di.DaggerCarComponent;

class Main {
    public static void main(String[] args) {
        CarComponent carComponent = DaggerCarComponent.create();
        final CarDao carDao = carComponent.buildCar();
        final CarDao carDao1 = carComponent.buildCar();
        System.out.println(carDao +" "+carDao1);
        System.out.println(carDao.engine + " "+ carDao1.engine);
    }
}
