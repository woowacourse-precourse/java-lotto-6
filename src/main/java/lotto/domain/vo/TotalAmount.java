package lotto.domain.vo;

import lotto.constant.LottoConstants;

public class TotalAmount {
    private final Integer amount;

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

    public int getAmount() {
        return amount;
    }
}
