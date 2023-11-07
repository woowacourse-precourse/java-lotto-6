package lotto.util;

import lotto.domain.payment.PaymentConstant;

public class LottoTicketCalculator implements PaymentConstant {
    public static int calculateLottoTicketQuantityWithAmount(final int amount) {
        return amount/PAYMENT_UNIT;
    }
}
