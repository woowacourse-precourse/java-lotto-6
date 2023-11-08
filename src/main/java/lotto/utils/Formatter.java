package lotto.utils;

import java.text.DecimalFormat;

public class Formatter {

    public static String formatToDecimal(int number) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format((double) number);
    }
    
}
