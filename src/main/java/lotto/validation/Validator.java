package lotto.validation;

import java.util.List;
import lotto.constant.Constant;
import lotto.constant.ErrorMessage;

public class Validator {

    public static void validateLotto(final List<Integer> numbers) {
        Validator.validateNumbersSize(numbers);
        Validator.validateNumbersRange(numbers);
        Validator.validateDuplicate(numbers);
    }

    public static void validateStringLotto(final List<String> numbers) {
        if (numbers.size() != 6) {
            throw new NumberFormatException(ErrorMessage.NUMBERS_SIZE.getMessage());
        }
        for (String input : numbers) {
            validateIsDigit(input);
        }
    }

    public static void validateIsDigit(final String number) {
        if (number.isEmpty() || !number.matches("\\d+")) {
            throw new NumberFormatException(ErrorMessage.NON_INTEGER.getMessage());
        }
    }

    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % Constant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE.getMessage());
        }
        if (purchaseAmount / Constant.LOTTO_PRICE < Constant.MIN_LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE.getMessage());
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (bonusNumber < Constant.MIN_NUMBER || bonusNumber > Constant.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE.getMessage());
        }
    }

    public static void validateNumbersSize(final List<Integer> numbers) {
        if (numbers.size() != Constant.NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_SIZE.getMessage());
        }
    }

    public static void validateNumbersRange(final List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    public static void validateNumberRange(final int number) {
        if (number < Constant.MIN_NUMBER || number > Constant.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }

    public static void validateDuplicate(final List<Integer> numbers) {
        boolean[] checkDuplicateNumber = new boolean[Constant.AVAILABLE_NUMBERS];
        for (int number : numbers) {
            if (checkDuplicateNumber[number]) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE.getMessage());
            }
            checkDuplicateNumber[number] = true;
        }
    }
}
