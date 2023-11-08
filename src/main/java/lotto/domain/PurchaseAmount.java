package lotto.domain;

import lotto.constants.LottoConstants;
import lotto.exception.ErrorMessage;

public class PurchaseAmount {
    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount create(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        if (validateInputZero(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ZERO.getErrorMessage());
        }
        if (validateThousand(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND.getErrorMessage());
        }
    }

    private boolean validateThousand(int money) {
        return money % LottoConstants.THOUSAND.getNumber() != LottoConstants.ZERO.getNumber();
    }

    private boolean validateInputZero(int money) {
        return money == LottoConstants.ZERO.getNumber();
    }
}
