package lotto.vo;

import lotto.utils.ValueUnit;

public final class Money {

    private final Integer money;


    public Money(Integer money) {
        this.money = money;
    }

    public boolean isLottoCountSameAsMoney(Integer count) {
        ValueUnit lottoTicketPurchaseAmount = ValueUnit.LOTTO_TICKET_PURCHASE_AMOUNT;
        return money.equals(count * lottoTicketPurchaseAmount.getValue());
    }

    public String lottoExchangeCount() {
        ValueUnit lottoTicketPurchaseAmount = ValueUnit.LOTTO_TICKET_PURCHASE_AMOUNT;
        return Integer.toString(money / lottoTicketPurchaseAmount.getValue());
    }

    public Integer getMoney() {
        return money;
    }
}
