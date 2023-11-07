package lotto.utils;

import lotto.code.ErrorMessage;
import org.assertj.core.util.Strings;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.utils.Constant.LOTTO_AMOUNT;

public class ValidationUtils {
    private ValidationUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_ONLY_SIX.getMessage());
        }

        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbers.size() != numbersSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATION.getMessage());
        }

        long count = numbers.stream().filter(n -> n < 1 || n > 45).count();
        if (count > 0) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INVALID_NUMBER_RANGE.getMessage());
        }

        return true;
    }

    public static boolean validateAmount(String input) {
        validateNumber(input);

        int amount = Integer.parseInt(input);
        if (amount % LOTTO_AMOUNT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_UNIT_INPUT.getMessage());
        }

        return true;
    }

    public static boolean validateBonusNumber(String input) {
        validateNumber(input);

        int number = Integer.parseInt(input);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INVALID_NUMBER_RANGE.getMessage());
        }

        return true;
    }

    public static boolean validateNumber(String input) {
        validateEmpty(input);

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBERS.getMessage());
        }

        return true;
    }

    public static boolean validateEmpty(String input) {
        if (Strings.isNullOrEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_DATA.getMessage());
        }
        return true;
    }
}
