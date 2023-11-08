package lotto.utils;

import java.text.DecimalFormat;

public class Formatter {
    public static String moneyFormat(long amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedMoney = decimalFormat.format(amount);
        return formattedMoney;
    }
}
