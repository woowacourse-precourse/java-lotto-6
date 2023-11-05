package lotto.util;

import java.text.DecimalFormat;

public class DecimalFormatter {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#,###");

    private DecimalFormatter() {

    }

    public static String toNumberWithDelimiter(int numberInput) {
        return decimalFormat.format(numberInput);
    }
}
