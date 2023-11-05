package lotto.util;

import lotto.domain.constant.PaymentConstant;

public class LottoTicketCalculator implements PaymentConstant {
    public static int calculateLottoTicketQuantityWithAmount(final int amount) {
        return amount/PAYMENT_UNIT;
    }
}
