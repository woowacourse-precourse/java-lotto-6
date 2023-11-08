package lotto.util;

import static lotto.constant.Constant.MAX_NUMBER;
import static lotto.constant.Constant.MIN_NUMBER;
import static lotto.constant.Constant.NUMBERS_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;

public class NumberValidate {
    private static Set<Integer> set;

    public static void validateChangeNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_INPUT_NUMBER.toString());
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateSizeSix(numbers);
        validateNumbersRange(numbers);
        validateDuplicates(numbers);
    }

    public static void validateBonusNumber(int number) {
        isValidRange(number);
        checkDuplicates(number);
    }

    private static void validateSizeSix(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_SIX_NUMBER.toString());
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            isValidRange(number);
        }
    }

    private static void isValidRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.toString());
        }
    }

    private static void validateDuplicates(List<Integer> numbers) {
        set = new HashSet<>();
        for (int number : numbers) {
            checkDuplicates(number);
        }
    }

    private static void checkDuplicates(int number) {
        if (!set.add(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE.toString());
        }
    }
}
