package lotto.model;

public class Deposit {
    private static final String NOT_A_NUMBER_MESSAGE = "[ERROR] 로또 구입 금액은 숫자여야 합니다. ";
    private static final String NOT_A_UNIT_OF_THOUSAND_MESSAGE = "[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다. ";
    private static final String OUT_OF_RANGE_MESSAGE = "[ERROR] 로또 구입 금액은 1,000원 이상, 100,000원 이하여야 합니다. ";
    private static final String NUMERAL_REGEX = "[0-9]+";
    private static final Integer DIVISION_UNIT = 1_000;
    private static final Integer MIN_AMOUNT = 1_000;
    private static final Integer MAX_AMOUNT = 100_000;

    private final Integer amount;

    public Deposit(String amount) {
        validateDeposit(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validateDeposit(String amount) {
        if (!amount.matches(NUMERAL_REGEX)) {
            throw new IllegalArgumentException(NOT_A_NUMBER_MESSAGE);
        }
        if (Integer.parseInt(amount) % DIVISION_UNIT != 0) {
            throw new IllegalArgumentException(NOT_A_UNIT_OF_THOUSAND_MESSAGE);
        }
        if (Integer.parseInt(amount) > MAX_AMOUNT
                || Integer.parseInt(amount) < MIN_AMOUNT) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
    }

    public Integer calculateBuyableLottoAmount() {
        return this.amount / DIVISION_UNIT;
    }
}
