package lotto.domain;

public class ReturnRate {

    private static final int PERCENT_CONVERSION_FACTOR = 100;

    public static double countReturnRate(double returnValue, double investValue) {
        return returnValue / investValue * PERCENT_CONVERSION_FACTOR;
    }
}
