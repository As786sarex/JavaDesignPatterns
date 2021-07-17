package creational.sigleton;

public class DataMultiThreadedSingleton<T> {
    private static volatile DataMultiThreadedSingleton INSTANCE;

    private final T data;


    private DataMultiThreadedSingleton(T data) {
        /*
        Process instance properties
         */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
    }


    public synchronized static <T> DataMultiThreadedSingleton<T> getInstance(T data) {
        if (INSTANCE == null) {
            INSTANCE = new DataMultiThreadedSingleton<T>(data);
        }
        return INSTANCE;

    }

    public T getData() {
        return data;
    }
}
