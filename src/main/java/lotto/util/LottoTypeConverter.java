package lotto.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class LottoTypeConverter {
    public static List<Integer> toList(String winningNumber) {
        String[] split = winningNumber.split(",");
        return Arrays.stream(split).map(Integer::parseInt).toList();
    }

    public static String toWon(int money) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String format = decimalFormat.format(money);
        return " (" + format + "원)";
    }
}
