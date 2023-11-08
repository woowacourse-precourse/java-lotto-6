package lotto.domain;

import lotto.GameUtils;

public class PurchaseAmount {
    public static final int LOTTO_PRICE = 1000;
    public static final String PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION = "구입 금액은 숫자여야 합니다.";
    public static final String PURCHASE_AMOUNT_NOT_POSITIVE_EXCEPTION = "구입 금액은 양수여야 합니다.";
    public static final String PURCHASE_AMOUNT_NOT_DIVISIBLE_EXCEPTION = "구입 금액은 " + LOTTO_PRICE + "원으로 나누어 떨어져야 합니다.";
    public static final String LOTTO_PRICE_NOT_POSITIVE_EXCEPTION = "로또 금액은 양수여야 합니다.";
    private final long amount;

    public PurchaseAmount(String input) {
        validateNumber(input);
        int amount = GameUtils.convertToNumber(input);
        validatePositivePurchaseAmount(amount);
        validateDivisible(amount);
        this.amount = amount;
    }

    public int getPurchaseNumber() {
        validatePositiveLottoPrice(LOTTO_PRICE);
        return (int) amount / LOTTO_PRICE;
    }

    public long getAmount() {
        return amount;
    }

    private void validatePositiveLottoPrice(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(LOTTO_PRICE_NOT_POSITIVE_EXCEPTION);
        }
    }

    private void validateNumber(String input) {
        if (GameUtils.isNotNumber(input)) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION);
        }
    }

    private void validatePositivePurchaseAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_POSITIVE_EXCEPTION);
        }
    }

    private void validateDivisible(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_DIVISIBLE_EXCEPTION);
        }
    }
}
