package lotto.model;

import static lotto.Constraints.LOTTO_PRICE;

import lotto.model.exceptions.BlankInputException;
import lotto.model.exceptions.NotDivisibleIntegerException;
import lotto.model.exceptions.NotIntegerException;
import lotto.model.exceptions.NotPositiveIntegerException;
import lotto.model.exceptions.NullInputException;

public class Amount {
    private final int amount;

    public Amount(String amount) {
        validateNullInput(amount);
        validateBlankInput(amount);
        int amountValue = validateIntegerInput(amount);
        validatePositiveIntegerInput(amountValue);
        validateDivisibleIntegerInput(amountValue);

        this.amount = amountValue;
    }

    // null 검증
    private void validateNullInput(String amount) {
        if (amount == null) {
            throw new NullInputException();
        }
    }

    // 빈값 + 공백 검증
    private void validateBlankInput(String amount) {
        if (amount.isBlank()) {
            throw new BlankInputException();
        }
    }

    // 정수 검증
    private int validateIntegerInput(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new NotIntegerException();
        }
    }

    // 양의 정수 검증
    private void validatePositiveIntegerInput(int amount) {
        if (amount <= 0) {
            throw new NotPositiveIntegerException();
        }
    }

    // 1000의 배수 검증
    private void validateDivisibleIntegerInput(int amount) {
        if (amount % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_INTEGER_INPUT_MESSAGE.getMessage());
        }
            throw new NotDivisibleIntegerException();
        }
    }

    }
}