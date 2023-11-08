package lotto.util;

public class CalculateUtil {

    private static final int THOUSAND_VALUE = 1000;

    public static int divideByThousands(int money) {
        return money / THOUSAND_VALUE;
    }
}
