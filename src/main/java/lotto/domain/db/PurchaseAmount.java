package lotto.domain.db;

import lotto.constant.Phrases;
import lotto.exception.purchase.PurchaseAmountException;

public class PurchaseAmount {
    private int amount;

    public PurchaseAmount(String amount) {
        validateEmptyInput(amount);
        validateIsNotNumber(amount);
        validateCanDivide(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validateIsNotNumber(String amount) {
        new PurchaseAmountException().isNotNumber(amount);
    }

    private void validateEmptyInput(String amount) {
        new PurchaseAmountException().emptyInput(amount);
    }

    private void validateCanDivide(String amount) {
        new PurchaseAmountException().cannotDivideThousand(amount);
    }

    public int getAmount() {
        return amount;
    }
}
