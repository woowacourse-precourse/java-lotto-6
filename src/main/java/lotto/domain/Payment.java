package lotto.domain;

public class Payment {

    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_AMOUNT = 2_000_000_000;
    private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자만 입력할 수 있습니다.";
    private static final String MIN_AMOUNT_ERROR_MESSAGE = "[ERROR] 최소 구입 금액은 1,000원 입니다.";
    private static final String UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위 입니다.";
    private static final String MAX_AMOUNT_ERROR_MESSAGE = "[ERROR] 최대 구입 금액은 2,000,000,000원 입니다.";

    private final int amount;

    public Payment(final String amount) {
        validate(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validate(final String amount) {
        validateOnlyNumberExist(amount);
        validateMinimumAmount(amount);
        validateThousandUnit(amount);
        validateMaximumAmount(amount);
    }

    private void validateOnlyNumberExist(final String amount) {
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateMinimumAmount(final String amount) {
        if (Integer.parseInt(amount) < LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_AMOUNT_ERROR_MESSAGE);
        }
    }

    private void validateThousandUnit(final String amount) {
        if (isThousandUnit(amount)) {
            throw new IllegalArgumentException(UNIT_ERROR_MESSAGE);
        }
    }

    private boolean isThousandUnit(final String amount) {
        return Integer.parseInt(amount) % LOTTO_PRICE != 0;
    }

    private void validateMaximumAmount(final String amount) {
        if (Integer.parseInt(amount) > MAX_AMOUNT) {
            throw new IllegalArgumentException(MAX_AMOUNT_ERROR_MESSAGE);
        }
    }

    public int calculatePurchasedLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public double calculateYield(final long totalReward) {
        return Math.round((double) totalReward / amount * 1000) / 10.0;
    }

}
