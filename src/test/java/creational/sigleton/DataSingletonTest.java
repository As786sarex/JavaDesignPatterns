package creational.sigleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class DataSingletonTest {

    @Test
    public void multipleThreadAccessShouldGiveDifferentDataObjectAndProperties() throws InterruptedException {
        final List<DataSingleton<String>> singletons = new ArrayList<>();
        final ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            final int count = i;
            executorService.execute(() -> {
                DataSingleton<String> singleton = DataSingleton.getInstance("Object" + count);
                singletons.add(singleton);
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        Assertions.assertThat(singletons)
                .anyMatch(stringDataMultiThreadedSingleton -> (stringDataMultiThreadedSingleton.hashCode() != singletons.get(0).hashCode()));
        Assertions.assertThat(singletons)
                .map(DataSingleton::getData)
                .anyMatch(s -> !s.equals(singletons.get(0).getData()));
        Assertions.assertThat(singletons.size()).isGreaterThan(1);
    }

    @Test
    public void shouldGiveSameObjectInSingleThreadedEnvironment() {
        final List<DataSingleton<String>> singletons = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            DataSingleton<String> singleton = DataSingleton.getInstance("Object" + i);
            singletons.add(singleton);
        }
        Assertions.assertThat(singletons)
                .allMatch(stringDataSingleton -> singletons.get(0) == stringDataSingleton
                        && singletons.get(0).getData().equals(stringDataSingleton.getData()));
        Assertions.assertThat(singletons.size()).isEqualTo(4);
    }
}