package lotto.model;

import lotto.view.exception.InvalidDivision;
import lotto.view.exception.InvalidNumberException;
import lotto.view.exception.InvalidZeroException;

public class LottoAmount {
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;
    private final int amount;

    public LottoAmount(String amount) {
        int number = isInvalidNumber(amount);
        isZeroInput(number);
        isNotDivisible(number);
        this.amount = number;
    }

    private int isInvalidNumber(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }

    private void isZeroInput(int amount) {
        if (amount == ZERO) {
            throw new InvalidZeroException();
        }
    }

    private void isNotDivisible(int amount) {
        if (amount % THOUSAND != ZERO) {
            throw new InvalidDivision();
        }
    }

    public int getlottoTicketCount() {
        return (amount / THOUSAND);
    }
}
