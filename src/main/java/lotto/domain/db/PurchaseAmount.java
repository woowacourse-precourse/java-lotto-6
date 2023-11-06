package lotto.domain.db;

import lotto.constant.Phrases;

public class PurchaseAmount {
    private int amount;

    public PurchaseAmount(String amount) {
        validateIsNotNumber(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validateIsNotNumber(String amount) {
        if (!amount.matches("[0-9]+")) {
            throw new IllegalArgumentException(Phrases.notNumberExceptionPhrase);
        }
    }

    public int getAmount() {
        return amount;
    }
}
