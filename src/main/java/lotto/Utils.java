package lotto;

public class Utils {

    public static double calculateReturn(Long molecule, Long denominator) {
        double rateReturn = (double) molecule / denominator * 1000;
        double result = Math.round(rateReturn);
        return result / 10;
    }
}
