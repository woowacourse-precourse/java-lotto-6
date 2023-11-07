package lotto.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class LottoTypeConverter {
    private static final String COMMA = ",";
    public static List<Integer> toList(String winningNumber) {
        String[] split = winningNumber.split(COMMA);
        return Arrays.stream(split).map(Integer::parseInt).toList();
    }

    public static String toWon(int money) {
        DecimalFormat decimalFormat = new DecimalFormat(" (#,###원)");
        return decimalFormat.format(money);
    }
}
