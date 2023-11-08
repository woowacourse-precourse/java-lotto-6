package lotto.domain;

import lotto.error.ErrorMessage;

public class Money {
    private final int amount;

    public Money(String input) {
        isNum(input);
        isPositive(input);
        isDividedBy1000(input);
        this.amount = Integer.parseInt(input);
    }

    private void isPositive(String input) {
        int num = Integer.parseInt(input);
        if (num <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE);
        }
    }

    private void isDividedBy1000(String input) {
        int num = Integer.parseInt(input);
        if (num % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_BY_PRICE);
        }
    }

    private void isNum(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC);
        }
    }

    public int getAmount() {
        return amount;
    }
}
