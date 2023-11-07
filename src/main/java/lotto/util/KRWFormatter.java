package lotto.util;

import java.text.DecimalFormat;

public class KRWFormatter {
    public static String format(Integer price) {
        DecimalFormat format = new DecimalFormat("#,###");
        return format.format(price);
    }
}
