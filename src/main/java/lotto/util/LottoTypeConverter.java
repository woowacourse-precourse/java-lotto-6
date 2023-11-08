package lotto.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class LottoTypeConverter {
    private static final String COMMA = ",";

    public static String[] toArray(String winningNumber) {
        return winningNumber.split(COMMA);
    }

    public static List<Integer> toList(String[] winningNumber) {
        return Arrays.stream(winningNumber).map(Integer::parseInt).toList();
    }

    public static String toWon(int money) {
        DecimalFormat decimalFormat = new DecimalFormat(" (#,###원)");
        return decimalFormat.format(money);
    }
}
