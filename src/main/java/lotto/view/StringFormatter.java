package lotto.view;

import java.text.NumberFormat;
import java.util.Locale;

public class StringFormatter {
    private static final NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());

    public static String formatWithCommas(long number) {
        numberFormat.setGroupingUsed(true);
        return numberFormat.format(number);
    }
}
