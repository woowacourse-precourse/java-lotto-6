package lotto.model;

public class Deposit {
    private static final String NOT_A_NUMBER_MESSAGE = "[ERROR] 로또 구입 금액은 1,000원 이상, 100,000원 이하의 숫자여야 합니다. ";
    private static final String NOT_A_UNIT_OF_THOUSAND_MESSAGE = "[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다. ";
    private static final String OUT_OF_RANGE_MESSAGE = "[ERROR] 로또 구입 금액은 1,000원 이상, 100,000원 이하여야 합니다. ";
    private static final Integer DIVISION_UNIT = 1_000;
    private static final Integer MIN_AMOUNT = 1_000;
    private static final Integer MAX_AMOUNT = 100_000;

    private final Integer amount;

    public Deposit(String amount) {
        validateDeposit(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validateDeposit(String amount) {
        int depositAmount;
        try {
            depositAmount = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_MESSAGE);
        }
        if (depositAmount % DIVISION_UNIT != 0) {
            throw new IllegalArgumentException(NOT_A_UNIT_OF_THOUSAND_MESSAGE);
        }
        if (depositAmount > MAX_AMOUNT
                || depositAmount < MIN_AMOUNT) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
    }

    public Integer calculateBuyableLottoAmount() {
        return this.amount / DIVISION_UNIT;
    }

    public String calculateEarningsRate(Integer earnings) {
        return String.valueOf(Math.round(earnings * 1000.0 / this.amount) / 10.0);
    }
}
