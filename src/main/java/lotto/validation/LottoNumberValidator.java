package lotto.validation;

import static lotto.constants.Constants.DOUBLE_SEPARATOR;
import static lotto.constants.Constants.LOTTO_NUMBER_RANGE_END;
import static lotto.constants.Constants.LOTTO_NUMBER_RANGE_START;
import static lotto.constants.Constants.LOTTO_NUMBER_SIZE;
import static lotto.constants.Constants.SEPARATOR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.InvalidSeparatorException;
import lotto.exception.NumberDuplicateException;
import lotto.exception.NumberRangeException;
import lotto.exception.NumbersSizeException;

public class LottoNumberValidator extends Validator {

    public static void validateWinningNumberReadLine(String readLine) {
        checkBlank(readLine);
        checkSeparator(readLine);
        String[] winningNumbers = readLine.split(SEPARATOR);
        for (String number : winningNumbers) {
            checkDigit(number);
        }
    }

    public static void validateLottoNumber(List<Integer> numbers) {
        checkLength(numbers);
        checkDuplicate(numbers);
        checkNumberInRange(numbers);
    }

    private static void checkSeparator(String readLine) {
        if (readLine.charAt(0) == SEPARATOR.charAt(0)) {
            throw InvalidSeparatorException.invalidSeparatorException;
        }
        if (readLine.charAt(readLine.length() - 1) == SEPARATOR.charAt(0)) {
            throw InvalidSeparatorException.invalidSeparatorException;
        }
        if (readLine.contains(DOUBLE_SEPARATOR)) {
            throw InvalidSeparatorException.invalidSeparatorException;
        }
    }

    private static void checkLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw NumbersSizeException.numbersSizeException;
        }
    }

    private static void checkDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicate = new HashSet<>(numbers);
        if (checkDuplicate.size() != numbers.size()) {
            throw NumberDuplicateException.numberDuplicateException;
        }
    }

    private static void checkNumberInRange(List<Integer> numbers) {
        boolean isValid = numbers.stream()
                .anyMatch(number -> (number < LOTTO_NUMBER_RANGE_START) || (number > LOTTO_NUMBER_RANGE_END));
        if (isValid) {
            throw NumberRangeException.numberRangeException;
        }
    }
}
