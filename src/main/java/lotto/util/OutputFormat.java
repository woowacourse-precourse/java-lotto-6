package lotto.util;

import java.text.DecimalFormat;

public class OutputFormat {

    public static String addCommaAtIntegers(int number) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(number);
    }

    public static String roundAtTwo(double prizePercentage) {
        return String.format("%.1f", prizePercentage);
    }
}
