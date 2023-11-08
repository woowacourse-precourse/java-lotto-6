package lotto.utils;

import java.text.DecimalFormat;
import lotto.constants.Config;

public final class Formatter {
    public static String moneyFormat(long amount) {
        DecimalFormat decimalFormat = new DecimalFormat(Config.MONEY_FORMAT);
        return decimalFormat.format(amount);
    }
}
