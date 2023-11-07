package lotto.model;

import static lotto.common.ExceptionMessage.ERROR_INPUT_NOT_MULTIPLE_OF_THOUSAND;

public class PurchaseAmount {
    private final int purchaseAmount;

    private PurchaseAmount(int amount) {
        validate(amount);
        this.purchaseAmount = amount;
    }

    public static PurchaseAmount from(int amount) {
        return new PurchaseAmount(amount);
    }

    private void validate(int amount) {
        validateThousandMultiple(amount);
    }

    private void validateThousandMultiple(int amount) {
        if (!isMultipleOfThousand(amount)) {
            throw new IllegalArgumentException(ERROR_INPUT_NOT_MULTIPLE_OF_THOUSAND);
        }
    }

    private boolean isMultipleOfThousand(int amount) {
        return amount % 1000 == 0;
    }

    public int calculateLottoCount() {
        return purchaseAmount / 1000;
    }
}
