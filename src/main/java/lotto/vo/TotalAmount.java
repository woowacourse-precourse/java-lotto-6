package lotto.vo;

import lotto.constant.LottoConstants;

public final class TotalAmount {
    private final int amount;

    private TotalAmount(int amount) {
        this.amount = amount;
    }

    public static TotalAmount from(int amount) {
        return new TotalAmount(amount);
    }

    public TicketCount calculateTicketCount() {
        int count = amount / LottoConstants.PRICE_PER_LOTTO;
        return TicketCount.from(count);
    }
}
