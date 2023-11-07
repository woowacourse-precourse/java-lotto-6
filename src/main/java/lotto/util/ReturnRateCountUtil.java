package lotto.util;

public class ReturnRateCountUtil {

    private static final int PERCENT_CONVERSION_FACTOR = 100;

    public static double countReturnRate(double returnValue, double investValue) {
        return returnValue / investValue * PERCENT_CONVERSION_FACTOR;
    }
}
