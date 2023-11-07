package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.Amount;
import lotto.manager.LottoException;

public class StringUtil {
    public static final String EMPTY = "";
    private static final String DEFAULT_SEPARATOR = ",";
    private static final int SPLIT_ALL = -1;

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
        String[] split = string.split(DEFAULT_SEPARATOR, SPLIT_ALL);

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
