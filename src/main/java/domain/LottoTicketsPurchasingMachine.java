package domain;

import exception.NotPositivePurchaseAmountException;
import exception.NotCorrectUnitAmountException;

public class LottoTicketsPurchasingMachine {
    private static final int LOTTO_UNIT_AMOUNT = 1_000;
    public int purchaseOfLottoTickets(int purchaseAmount) {
        validateAmount(purchaseAmount);
        validatePurchaseAmountWithUnitAmount(purchaseAmount);
        return purchaseAmount / LOTTO_UNIT_AMOUNT;
    }

    private void validateAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new NotPositivePurchaseAmountException();
        }
    }

    private void validatePurchaseAmountWithUnitAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_UNIT_AMOUNT != 0) {
            throw new NotCorrectUnitAmountException(LOTTO_UNIT_AMOUNT);
        }
    }
}
