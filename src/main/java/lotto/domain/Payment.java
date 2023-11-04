package lotto.domain;

public class Payment {

    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_AMOUNT = 2_000_000_000;
    private static final String MIN_AMOUNT_ERROR_MESSAGE = "[ERROR] 최소 구입 금액은 1,000원 입니다.";
    private static final String UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위 입니다.";
    private static final String MAX_AMOUNT_ERROR_MESSAGE = "[ERROR] 최대 구입 금액은 2,000,000,000원 입니다.";

    private final int amount;

    public Payment(final String amount) {
        validate(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validate(final String amount) {
        validateMinimumAmount(amount);
        validateThousandUnit(amount);
        validateMaximumAmount(amount);
    }

    private void validateMinimumAmount(final String amount) {
        if (Integer.parseInt(amount) < LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_AMOUNT_ERROR_MESSAGE);
        }
    }

    private void validateThousandUnit(final String amount) {
        if (Integer.parseInt(amount) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(UNIT_ERROR_MESSAGE);
        }
    }

    private void validateMaximumAmount(final String amount) {
        if (Integer.parseInt(amount) > MAX_AMOUNT) {
            throw new IllegalArgumentException(MAX_AMOUNT_ERROR_MESSAGE);
        }
    }

}
