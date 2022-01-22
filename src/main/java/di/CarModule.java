package di;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class CarModule {
    @Provides
    @Singleton
    public Engine provideEngine() {
        return new Engine();
    }
}
