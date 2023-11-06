package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.Amount;
import lotto.manager.LottoException;

public class StringUtil {
    public static boolean isNumber(String number) {
        try {
            new Amount(number);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    public static boolean isEmptyOrBlank(String string) {
        if (string.isBlank()) {
            return true;
        }
        if (string.isEmpty()) {
            return true;
        }
        return false;
    }

    public static List<Integer> splitAndParseToIntList(String string) {
        String[] split = string.split(",", -1);

        for (String number : split) {
            if (!StringUtil.isNumber(number)) {
                LottoException.NOT_NUMBER.throwing();
            }
        }
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .toList();
    }
}
