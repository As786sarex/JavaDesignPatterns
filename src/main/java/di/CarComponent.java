package di;

import behavioural.visitor.ConcreteVisitor;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {CarModule.class})
@Singleton
public interface CarComponent {
    CarDao buildCar();
}
