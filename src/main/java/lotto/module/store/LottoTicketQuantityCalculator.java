package lotto.module.store;

import lotto.module.domain.PurchaseAmount;

/**
 * 로또 티켓 수를 계산하는 클래스
 */
public class LottoTicketQuantityCalculator {
    private static final int LOTTO_TICKET_PRICE = 1_000;

    private LottoTicketQuantityCalculator() {
    }

    public static LottoTicketQuantityCalculator newInstance() {
        return new LottoTicketQuantityCalculator();
    }

    public int computeLottoTicketCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getPayment() / LOTTO_TICKET_PRICE;
    }

}
