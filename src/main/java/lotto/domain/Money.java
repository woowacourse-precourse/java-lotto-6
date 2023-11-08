package lotto.domain;

import java.util.regex.Pattern;

public class Money {
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;
    private static final int MIN_VALUE = 1;
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int input) {
        validateRemainder(input);
        validateRange(input);
        validateNumeric(String.valueOf(input));
    }

    private void validateRemainder(int input) {
        if (input % THOUSAND != ZERO) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(int input) {
        if (input < MIN_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumeric(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public int getTicket() {
        return money / THOUSAND;
    }
}