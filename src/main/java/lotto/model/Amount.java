package lotto.model;

import static lotto.Constraints.LOTTO_PRICE;
import static lotto.model.enums.ErrorMessage.BLANK_INPUT_MESSAGE;
import static lotto.model.enums.ErrorMessage.NOT_DIVISIBLE_INTEGER_INPUT_MESSAGE;
import static lotto.model.enums.ErrorMessage.NOT_INTEGER_INPUT_MESSAGE;
import static lotto.model.enums.ErrorMessage.NOT_POSITIVE_INTEGER_INPUT_MESSAGE;
import static lotto.model.enums.ErrorMessage.NULL_INPUT_MESSAGE;

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
            throw new IllegalArgumentException(NULL_INPUT_MESSAGE.getMessage());
        }
    }

    // 빈값 + 공백 검증
    private void validateBlankInput(String amount) {
        if (amount.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT_MESSAGE.getMessage());
        }
    }

    // 정수 검증
    private int validateIntegerInput(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_INPUT_MESSAGE.getMessage());
        }
    }

    // 양의 정수 검증
    private void validatePositiveIntegerInput(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_INTEGER_INPUT_MESSAGE.getMessage());
        }
    }

    // 1000의 배수 검증
    private void validateDivisibleIntegerInput(int amount) {
        if (amount % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_INTEGER_INPUT_MESSAGE.getMessage());
        }
    }
}