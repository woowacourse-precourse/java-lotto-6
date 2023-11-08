package lotto.model;

import static lotto.Constraints.LOTTO_PRICE;

import lotto.model.exceptions.NotDivisibleIntegerException;
import lotto.model.exceptions.NotIntegerException;
import lotto.model.exceptions.NotPositiveIntegerException;

public class Amount {
    private final int amount;

    public Amount(String amount) {
        int amountValue = validateIntegerInput(amount);
        validatePositiveIntegerInput(amountValue);
        validateDivisibleIntegerInput(amountValue);

        this.amount = amountValue;
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
            throw new NotDivisibleIntegerException();
        }
    }

    //로또 개수 로직
    public int calculateCount() {
        return this.amount / LOTTO_PRICE.getValue();
    }
}