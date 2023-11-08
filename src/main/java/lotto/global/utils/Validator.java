package lotto.global.utils;

import static lotto.global.constant.ErrorMessage.AMOUNT_FORMAT_ERROR_MESSAGE;
import static lotto.global.constant.ErrorMessage.AMOUNT_MULTIPLE_ERROR_MESSAGE;
import static lotto.global.constant.ErrorMessage.LOTTO_RANGE_ERROR_MESSAGE;
import static lotto.global.constant.ErrorMessage.LOTTO_SIZE_ERROR_MESSAGE;
import static lotto.global.constant.Game.LOTTO_END_RANGE;
import static lotto.global.constant.Game.LOTTO_PRICE;
import static lotto.global.constant.Game.LOTTO_SIZE;
import static lotto.global.constant.Game.LOTTO_START_RANGE;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {

    private static final String ZERO = "0";
    private static final String AMOUNT_PATTERN = "^(0|[1-9]+[0-9]*)$";

    public static boolean validatePurchaseAmount(String input) {
        validateFormat(input);
        validateMultipleOfPrice(input);
        return true;
    }

    private static boolean validateFormat(String input) {
        if (!input.matches(AMOUNT_PATTERN) || input.equals(ZERO) || input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException(AMOUNT_FORMAT_ERROR_MESSAGE);
        }
        return true;
    }

    private static boolean validateMultipleOfPrice(String input) {
        Long amount = Long.parseLong(input);
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(AMOUNT_MULTIPLE_ERROR_MESSAGE);
        }
        return true;
    }

    public static boolean validateWinningNumbers(List<String> numbers) {
        validateSize(numbers.size());
        for (String number : numbers) {
            validateFormat(number);
            validateRange(number);
        }
        validateDuplication(numbers);
        return true;
    }

    private static boolean validateSize(int size) {
        if (size != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MESSAGE);
        }
        return true;
    }

    private static boolean validateRange(String input) {
        Integer number = Integer.parseInt(input);
        if (number < LOTTO_START_RANGE || number > LOTTO_END_RANGE) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR_MESSAGE);
        }
        return true;
    }

    private static boolean validateDuplication(List<String> input) {
        Set<String> numbers = input.stream().collect(Collectors.toSet());
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MESSAGE);
        }
        return true;
    }
}
