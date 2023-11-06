package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;

public class InputValidator {
    private static final int LOTTO_NUMBER_MIN = 1;

    private static final int LOTTO_NUMBER_MAX = 45;

    public static void validateNumberType(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE.getMessage());
        }
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_PRICE.getMessage());
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_UNIT.getMessage());
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateLottoNumberSize(numbers);
        for (int number : numbers) {
            validateLottoNumberRange(number);
        }
        validateDuplicatedLottoNumber(numbers);
    }

    private static void validateLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE.getMessage());
        }
    }

    public static void validateLottoNumberRange(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage());
        }
    }

    private static void validateDuplicatedLottoNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

}
