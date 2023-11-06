package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.validator.LottoValidator;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

public class LottoPurchaseAmount {
    private final long amount;

    private LottoPurchaseAmount(long amount) {
        this.amount = amount;
    }

    public static LottoPurchaseAmount create(String inputAmountFromUser) {
        long purchaseAmount = LottoValidator.validateNumeric(inputAmountFromUser);
        validatePurchaseAmount(purchaseAmount);
        return new LottoPurchaseAmount(purchaseAmount);
    }

    public long getAmount() {
        return amount;
    }

    private static void validatePurchaseAmount(long money) {
        validatePositive(money);
        validateDividedByLottoPrice(money);
    }

    private static void validatePositive(long money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE.getMessage());
        }
    }

    private static void validateDividedByLottoPrice(long money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE.getMessage());
        }
    }
}
