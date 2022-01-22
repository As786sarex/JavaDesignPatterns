package di;

import javax.inject.Inject;
import java.util.Arrays;

public class CarDao {
    public final Engine engine;

    @Inject
    public CarDao(Engine engine) {
        this.engine = engine;
    }

    public int getX() {
        return engine.getX();
    }

    public static int increasing_subarray(int n,int[] arr) {
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for (int i = 0; i <n ; i++) {
            if(i>0 && arr[i]>arr[i-1])
                dp[i] = Integer.max(dp[i-1]+1,dp[i]);
            if(i>1 && arr[i]>arr[i-2])
                dp[i] = Integer.max(dp[i-2]+1,dp[i]);
            max = Integer.max(dp[i],max);
        }
        return max;
    }
}
