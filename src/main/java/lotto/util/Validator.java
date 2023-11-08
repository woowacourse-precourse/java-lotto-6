package lotto.util;

import lotto.constant.ErrorMessage;
import lotto.constant.Mark;
import lotto.constant.Value;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int THOUSAND = Value.THOUSAND.get();
    private static final int ZERO = Value.ZERO.get();
    private static final int DELIMITER_COUNT = Value.LOTTO_NUMBER_COUNT.get() - Value.ONE.get();

    public static BigDecimal checkPositive(BigDecimal number) throws IllegalArgumentException {
        if (isNegative(number)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE.get());
        }
        return number;
    }

    private static boolean isNegative(BigDecimal number) {
        return number.compareTo(BigDecimal.ZERO) < ZERO;
    }

    public static void checkDuplicated(List<Integer> numbers, int number) throws IllegalArgumentException {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATED.get());
        }
    }

    public static void checkDuplicated(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> noDuplicatedNumbers = new HashSet<>(numbers);
        if (numbers.size() > noDuplicatedNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATED.get());
        }
    }

    public static void checkThousandDivision(BigDecimal number) throws IllegalArgumentException {
        if (!number.remainder(new BigDecimal(THOUSAND)).equals(BigDecimal.ZERO)
                || number.equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND_UNIT.get());
        }
    }

    public static void checkDelimiterCount(String input) throws IllegalArgumentException {
        int delimiterCount = Value.ZERO.get();
        List<String> elements = List.of(input.split(Mark.EMPTY_REGEX.get()));
        for (String element : elements) {
            if (element.equals(Mark.DELIMITER.get())) {
                delimiterCount++;
            }
        }
        if (delimiterCount != DELIMITER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DELIMITER_FORMAT.get());
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}