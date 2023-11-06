package lotto.utils;

public class MathUtils {
    public static double average(int val, int... values) {
        int sum = val;
        for (int i = 0 ; i < values.length; i++) {
            sum += values[i];
        }
        return (double)sum / (values.length + 1);
    }
}
