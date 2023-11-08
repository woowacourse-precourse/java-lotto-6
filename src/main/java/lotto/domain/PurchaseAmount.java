package lotto.domain;

import lotto.exception.InvalidPurchaseAmountFormatException;
import lotto.exception.InvalidPurchaseAmountUnitException;
import lotto.exception.MissingPurchaseAmountException;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private final int amount;

    public PurchaseAmount(String amount) {
        verification(amount);
        this.amount = Integer.parseInt(amount);
    }

    public int getAmount() {
        return amount;
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    private void verification(String amount) {
        isNullPurchaseAmount(amount);
        isPurchaseAmount(amount);
        isValidPurchaseAmount(amount);
    }

    private void isNullPurchaseAmount(String amount) {
        if (amount.isEmpty()) {
            throw new MissingPurchaseAmountException();
        }
    }

    private void isPurchaseAmount(String amount) {
        if (amount.matches(".*[^0-9].*")) {
            throw new InvalidPurchaseAmountFormatException();
        }
    }

    private void isValidPurchaseAmount(String amount) {
        if (Integer.parseInt(amount) % LOTTO_PRICE != ZERO) {
            throw new InvalidPurchaseAmountUnitException();
        }
    }
}