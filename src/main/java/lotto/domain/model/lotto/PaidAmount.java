package lotto.domain.model.lotto;

import lotto.ErrorMessage;
import lotto.constants.LottoConfig;

public class PaidAmount {

    private static final int ZERO = 0;

    private final Integer paidAmount;

    public PaidAmount(final Integer paidAmount) {
        validate(paidAmount);
        this.paidAmount = paidAmount;
    }

    public Integer toNumberOfLottoTickets() {
        return paidAmount / LottoConfig.PRICE_PER_TICKET.getValue();
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    private void validate(Integer paidAmount) {
        if (isZero(paidAmount)) {
            throw new IllegalArgumentException(ErrorMessage.ZERO_PAID_AMOUNT.getMessage());
        }
        if (isNotDivisibleByPrice(paidAmount)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_PAID_AMOUNT.getMessage());
        }
    }

    private boolean isZero(Integer paidAmount) {
        return paidAmount == ZERO;
    }

    private boolean isNotDivisibleByPrice(Integer paidAmount) {
        return paidAmount % LottoConfig.PRICE_PER_TICKET.getValue() != 0;
    }
}
