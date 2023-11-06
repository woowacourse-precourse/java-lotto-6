package lotto.util;

import lotto.constant.ErrorMessage;
import lotto.constant.Format;
import lotto.constant.LottoFigure;
import lotto.constant.Value;
import java.util.List;

public class Validator {
    private static final int THOUSAND = Value.THOUSAND.get();
    private static final int ZERO = Value.ZERO.get();
    private static final int DELIMITER_COUNT = LottoFigure.LOTTO_NUMBER_COUNT.get() - 1;

    public static int checkLottoNumberInput(String input) throws IllegalArgumentException {
        return checkLottoRange((checkInteger(input)));
    }

    public static int checkLottoRange(int number) {
        if (number < LottoFigure.START_NUMBER.get() || number > LottoFigure.END_NUMBER.get()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE.get());
        }
        return number;
    }

    public static int checkInteger(String input) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.get());
        }
        return number;
    }

    public static int checkPositive(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_ERROR.get());
        }
        return number;
    }

    public static void checkDuplicated(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATED.get());
        }
    }

    public static void checkThousandDivision(int number) {
        if (number % THOUSAND != ZERO || number == ZERO) {
            throw new IllegalArgumentException(ErrorMessage.THOUSAND_UNIT_ERROR.get());
        }
    }

    public static void checkDelimiterCount(String input) throws IllegalArgumentException {
        int delimiterCount = Value.ZERO.get();
        List<String> elements = List.of(input.split(Format.EMPTY_REGEX.get()));
        for (String element : elements) {
            if (element.equals(Format.DELIMITER.get())) {
                delimiterCount++;
            }
        }
        if (delimiterCount != DELIMITER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DELIMITER_FORMAT.get());
        }
    }

    public static void checkLottoNumbersCount(List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != LottoFigure.LOTTO_NUMBER_COUNT.get()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT_OF_LOTTO.get());
        }
    }
}