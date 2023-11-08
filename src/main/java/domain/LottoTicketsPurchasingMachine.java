package domain;

import exception.NotCorrectUnitAmountException;
import exception.NotPositivePurchaseAmountException;
import exception.OverMaxPurchaseAmountException;

public class LottoTicketsPurchasingMachine {
    private static final Amount MAX_PURCHASE_AMOUNT = new Amount(2_000_000_000);
    private static final Amount LOTTO_UNIT_AMOUNT = new Amount(1_000);

    private LottoTicketsPurchasingMachine() {

    }

    public static int purchaseOfLottoTickets(int amount) {
        Amount purchaseAmount = new Amount(amount);
        validateZeroAmount(purchaseAmount);
        validateMaxPurchaseAmount(purchaseAmount);
        validatePurchaseAmountWithUnitAmount(purchaseAmount);
        return (int) purchaseAmount.calculateQuotientByUnitAmount(LOTTO_UNIT_AMOUNT);
    }

    private static void validateZeroAmount(Amount purchaseAmount) {
        if (purchaseAmount.isZeroAmount()) {
            throw new NotPositivePurchaseAmountException();
        }
    }

    private static void validateMaxPurchaseAmount(Amount purchaseAmount) {
        if (purchaseAmount.isOverLimitAmount(MAX_PURCHASE_AMOUNT)) {
            throw new OverMaxPurchaseAmountException(MAX_PURCHASE_AMOUNT);
        }
    }

    private static void validatePurchaseAmountWithUnitAmount(Amount purchaseAmount) {
        Amount modAmount = purchaseAmount.calculateModAmountByUnitAmount(LOTTO_UNIT_AMOUNT);

        if (modAmount.isZeroAmount()) {
            return;
        }

        throw new NotCorrectUnitAmountException(LOTTO_UNIT_AMOUNT);
    }
}
