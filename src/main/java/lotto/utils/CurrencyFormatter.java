package lotto.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CurrencyFormatter {

    public static String format(BigDecimal amount) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(amount);
    }
}
