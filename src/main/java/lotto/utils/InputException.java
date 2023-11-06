package lotto.utils;

import lotto.domain.PrintMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputException {

    public static void isDigit(String input) {
        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException(PrintMessage.ONLY_DIGIT);
            }
        }
    }

    public static void isThousandUnit(int num) {
        if (num % 1000 != 0)
            throw new IllegalArgumentException(PrintMessage.ONLY_THOUSAND_UNIT);
    }

    public static void isContainComma(String input) {
        if (!input.contains(","))
            throw new IllegalArgumentException(PrintMessage.ONLY_SPLIT_COMMA);
    }

    public static void isBetweenOneAndFourtyfive(int num) {
        if (num < 1 || num > 45)
            throw new IllegalArgumentException(PrintMessage.BETWEEN_ONE_AND_FORTYFIVE);
    }

    public static void isDuplication(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        if (list.size() != set.size())
            throw new IllegalArgumentException(PrintMessage.NOT_DUPLICATION);
    }

    public static void checkSize(List<Integer> list) {
        if (list.size() != 6)
            throw new IllegalArgumentException(PrintMessage.ONLY_SIX_NUMBER);
    }
}
