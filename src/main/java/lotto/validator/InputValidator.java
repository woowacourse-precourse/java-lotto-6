package lotto.validator;

import lotto.message.ErrorMessage;

import java.util.*;

public class InputValidator {

    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int LOTTO_LIMIT_VALUE = 6;

    public void validateLottoAmount(int amount) {
        if (isPositiveNumber(amount)) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_LESS_THAN_ZERO.getMessage());
        }
    }

    private boolean isPositiveNumber(int number) {
        return number <= 0;
    }

    public void validateMultipleOfDenomination(int amount, int denomination) {
        if (amount % denomination != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_AMOUNT.getMessage());
        }
    }

    public int parseInt(String requestNumber) {
        int number;
        try {
            number = Integer.parseInt(requestNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_FORMAT.getMessage());
        }
        return number;
    }

    public void validateLottoNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (isLottoNumberRange(number)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    public void validateLottoNumberRange(int number) {
        if (isPositiveNumber(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isLottoNumberRange(int number) {
        return number < START_LOTTO_NUMBER || number > END_LOTTO_NUMBER;
    }

    public void validateLottoSize(List<Integer> lotto) {
        if (LOTTO_LIMIT_VALUE != lotto.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

}
