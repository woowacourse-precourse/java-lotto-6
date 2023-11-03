package domain;

import exception.ImpossiblePayAmountException;
import exception.NotCorrectUnitAmountException;

public class LottoPurchasingMachine {
    private static final int LOTTO_UNIT_AMOUNT = 1_000;
    public int purchaseOfLottoTickets(int purchaseAmount) {
        verifyAmount(purchaseAmount);
        verifyPurchaseAmountWithUnitAmount(purchaseAmount);
        return purchaseAmount / LOTTO_UNIT_AMOUNT;
    }

    private void verifyAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new ImpossiblePayAmountException();
        }
    }

    private void verifyPurchaseAmountWithUnitAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_UNIT_AMOUNT != 0) {
            throw new NotCorrectUnitAmountException(LOTTO_UNIT_AMOUNT);
        }
    }
}
