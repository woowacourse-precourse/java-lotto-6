package lotto.domain;

import java.util.regex.Pattern;

public class Money {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^-?\\d+$");
    private static final String ONLY_NUMBER_ALLOWED_MESSAGE = "숫자만 입력해 주세요.";
    private static final String MINIMUM_AMOUNT_MSG = "최소 금액은 1,000원 입니다.";
    private static final String THOUSAND_UNIT_ONLY_MSG = "금액은 1,000원 단위로 입력해 주세요.";
    private static final int MINIMUM_AMOUNT = 1000;
    private int amount;

    private Money(final int amount) {
        this.amount = amount;
    }

    public static Money of(final String amount) {
        validate(amount);
        return new Money(parseNumeric(amount));
    }

    private static void validate(final String amount) {
        isNumeric(amount);
        isOverThousand(amount);
        isDivisibleByThousand(amount);
    }

    private static void isNumeric(final String amount) {
        if (!NUMBER_PATTERN.matcher(trim(amount)).matches()) {
            throw new IllegalArgumentException(ONLY_NUMBER_ALLOWED_MESSAGE);
        }
    }

    private static void isOverThousand(final String amount) {
        if ((parseNumeric(amount) < MINIMUM_AMOUNT)) {
            throw new IllegalArgumentException(MINIMUM_AMOUNT_MSG);
        }
    }

    private static void isDivisibleByThousand(final String amount) {
        if ((parseNumeric(amount) % MINIMUM_AMOUNT != 0)) {
            throw new IllegalArgumentException(THOUSAND_UNIT_ONLY_MSG);
        }
    }

    private static int parseNumeric(final String input) {
        return Integer.parseInt(trim(input));
    }

    private static String trim(final String input) {
        return input.trim();
    }

    public int calculateLottoQuantity(int price) {
        return this.amount / price;
    }
}