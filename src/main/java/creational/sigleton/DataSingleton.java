package creational.sigleton;

public class DataSingleton<T> {
    private static DataSingleton INSTANCE;

    private final T data;


    private DataSingleton(T data) {
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


    public static <T> DataSingleton<T> getInstance(T data) {

        if (INSTANCE == null) {
            INSTANCE = new DataSingleton<T>(data);
        }
        return INSTANCE;

    }

    public T getData() {
        return data;
    }
}
