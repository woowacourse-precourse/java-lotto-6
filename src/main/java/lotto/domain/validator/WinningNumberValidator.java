package lotto.domain.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.message.ConsoleMessage;

public class WinningNumberValidator {
    private static final int LOTTO_NUM_SIZE = 6;
    private static final int MAX_NUM = 45;
    private static final int MIN_NUM = 1;

    public static List<Integer> validateWinningNumber(String number) {
        try {
            List<String> numbers = List.of(number.split(","));
            return validLotto(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ConsoleMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    private static List<Integer> validLotto(List<String> originNumbers) {
        List<Integer> numbers = validateNumber(originNumbers);
        validateSize(numbers);
        validNumberRange(numbers);
        return validateDuplicate(numbers);
    }

    private static void validNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MIN_NUM || number > MAX_NUM)) {
            throw new IllegalArgumentException(ConsoleMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }


    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException(ConsoleMessage.LOTTO_NUMBER_SIZE_ERROR.getMessage());
        }
    }

    private static List<Integer> validateDuplicate(List<Integer> numbers) {
        HashSet hashSet = new HashSet(numbers);
        if (hashSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ConsoleMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
        }
        return numbers;
    }

    private static List<Integer> validateNumber(List<String> numbers) {
        List<Integer> formatNumbers = new ArrayList<>();
        try {
            for (String number : numbers) {
                formatNumbers.add(Integer.parseInt(number));
            }
            return formatNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ConsoleMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }
}
