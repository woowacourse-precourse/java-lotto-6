package domain;

import exception.NotCorrectUnitAmountException;
import exception.NotPositivePurchaseAmountException;

public class LottoTicketsPurchasingMachine {
    private static final Amount LOTTO_UNIT_AMOUNT = new Amount(1_000);
    public int purchaseOfLottoTickets(Amount purchaseAmount) {
        ValidateZeroAmount(purchaseAmount);
        validatePurchaseAmountWithUnitAmount(purchaseAmount);
        return purchaseAmount.calculateQuotientByUnitAmount(LOTTO_UNIT_AMOUNT);
    }

    private void ValidateZeroAmount(Amount purchaseAmount) {
        if (purchaseAmount.isZeroAmount()) {
            throw new NotPositivePurchaseAmountException();
        }
    }

    private void validatePurchaseAmountWithUnitAmount(Amount purchaseAmount) {
        Amount modAmount = purchaseAmount.calculateModAmountByUnitAmount(LOTTO_UNIT_AMOUNT);

        if (modAmount.isZeroAmount()) {
            return;
        }

        throw new NotCorrectUnitAmountException(LOTTO_UNIT_AMOUNT);
    }
}
