package lotto.domain;

import lotto.exception.InvalidNumberFormatException;
import lotto.exception.InvalidUnitException;
import lotto.exception.MissingNumberException;

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
            throw new MissingNumberException();
        }
    }

    private void isPurchaseAmount(String amount) {
        if (amount.matches(".*[^0-9].*")) {
            throw new InvalidNumberFormatException();
        }
    }

    private void isValidPurchaseAmount(String amount) {
        if (Integer.parseInt(amount) % LOTTO_PRICE != ZERO) {
            throw new InvalidUnitException();
        }
    }
}