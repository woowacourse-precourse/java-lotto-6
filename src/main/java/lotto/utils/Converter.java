package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class Converter {
    public static long convertMoney(String money) {
        return Long.parseLong(money);
    }

    public static List<Integer> convertWinningNumber(String[] winningNumber) {
        return Arrays.stream(winningNumber)
                .map(Integer::parseInt)
                .toList();
    }
}
