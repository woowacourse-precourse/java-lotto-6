package lotto.domain;

import lotto.exception.ErrorMessage;

public class LottoPurchaseManager {
    private static final int LOTTO_PRICE = 1000;

    public long calculateLottoQuantity(String input) {
        long money = validateNumeric(input);
        validatePurchaseAmount(money);
        return money / LOTTO_PRICE;
    }

    private long validateNumeric(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_NUMERIC.getMessage());
        }
    }

    private void validatePurchaseAmount(long money) {
        validatePositive(money);
        validateMultipleOfLottoPrice(money);
    }

    private void validatePositive(long money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE.getMessage());
        }
    }

    private void validateMultipleOfLottoPrice(long money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE.getMessage());
        }
    }
}
