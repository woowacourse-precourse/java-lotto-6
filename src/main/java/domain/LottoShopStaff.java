package domain;

import exception.ImpossiblePayAmountException;
import exception.NotCorrectUnitAmountException;

public class LottoShopStaff {
    private static final int LOTTO_UNIT_AMOUNT = 1_000;
    public int payOfLottoTickets(int payAmount) {
        verifyAmount(payAmount);
        verifyPayAmountWithUnitAmount(payAmount);
        return payAmount / LOTTO_UNIT_AMOUNT;
    }

    private void verifyAmount(int payAmount) {
        if (payAmount <= 0) {
            throw new ImpossiblePayAmountException();
        }
    }

    private void verifyPayAmountWithUnitAmount(int payAmount) {
        if (payAmount % LOTTO_UNIT_AMOUNT != 0) {
            throw new NotCorrectUnitAmountException(LOTTO_UNIT_AMOUNT);
        }
    }
}
