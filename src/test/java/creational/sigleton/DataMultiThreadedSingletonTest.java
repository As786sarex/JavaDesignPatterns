package creational.sigleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class DataMultiThreadedSingletonTest {


    @Test
    public void multipleThreadAccessShouldGiveSameDataObjectAndProperties() throws InterruptedException {
        final List<DataMultiThreadedSingleton<String>> singletons = new ArrayList<>();
        final ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            final int count=i;
            executorService.execute(() -> {
                DataMultiThreadedSingleton<String> singleton = DataMultiThreadedSingleton.getInstance("Object" + count);
                singletons.add(singleton);
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        Assertions.assertThat(singletons)
                .allMatch(stringDataMultiThreadedSingleton -> stringDataMultiThreadedSingleton.hashCode() == singletons.get(0).hashCode());
        Assertions.assertThat(singletons)
                .map(DataMultiThreadedSingleton::getData)
                .allMatch(s -> s.equals(singletons.get(0).getData()));
        Assertions.assertThat(singletons.size()).isGreaterThan(1);
    }
}