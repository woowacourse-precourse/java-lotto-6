package lotto.Util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.Util.ErrorCollection.*;

public class Validation {

    public static void emptyCheck(String value) {
        if (value.length() == 0) {
            ErrorEmpty();
        }
    }

    public static void numberCheck(String value) {
        String pattern = ViewConstant.NUMBER_PATTERN;
        Matcher matcher = Pattern.compile(pattern).matcher(value);

        if (!matcher.matches()) {
            ErrorStringInput();
        }
    }

    public static void parseIntCheck(String value) {
        try {
            Integer.parseInt(value);
        } catch (Exception e) {
            ErrorStringInput();
        }
    }

    public static void rangeCheck(int value) {
        if (value < 1 || value > 45) {
            ErrorRange();
        }
    }

    public static void lackInputCheck(List<Integer> numbers) {
        if (numbers.size() != 6) ErrorLackInput();
    }

    public static void duplicationCheck(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count < 6) ErrorDuplication();
    }

    public static void duplicationCheck(List<Integer> winnerNumbers, int bonusNumber) {
        if (winnerNumbers.contains(bonusNumber)) ErrorDuplication();
    }

    public static void banknoteCheck(int cost) {
        if (cost % 1000 != 0)  ErrorBanknote();
    }
}
