package lotto.domain;

import lotto.GameUtils;
import lotto.service.NumberService;

public class PurchaseAmount {
    public static final String PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION = "구입 금액은 숫자여야 합니다.";
    public static final String PURCHASE_AMOUNT_NOT_POSITIVE_EXCEPTION = "구입 금액은 양수여야 합니다.";
    public static final String PURCHASE_AMOUNT_NOT_DIVISIBLE_EXCEPTION = "구입 금액은 " + NumberService.LOTTO_PRICE + "원으로 나누어 떨어져야 합니다.";
    private final int amount;

    public PurchaseAmount(String input) {
        validateNumber(input);
        int amount = GameUtils.convertStringToInt(input);
        validatePositive(amount);
        validateDivisible(amount);
        this.amount = amount;
    }

    private void validateNumber(String input) {
        if (GameUtils.isNotNumber(input)) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION);
        }
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_POSITIVE_EXCEPTION);
        }
    }

    private void validateDivisible(int amount) {
        if (amount % NumberService.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_DIVISIBLE_EXCEPTION);
        }
    }
}
