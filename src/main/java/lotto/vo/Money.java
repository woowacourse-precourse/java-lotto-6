package lotto.vo;

import static lotto.utils.LottoConstants.LOTTO_TICKET_PURCHASE_AMOUNT;

public final class Money {

    private final Integer money;


    public Money(Integer money) {
        this.money = money;
    }

    public boolean isLottoCountSameAsMoney(Integer count) {
        return money.equals(count * LOTTO_TICKET_PURCHASE_AMOUNT.getValue());
    }

    public String lottoExchangeCount() {
        return Integer.toString(money / LOTTO_TICKET_PURCHASE_AMOUNT.getValue());
    }

    public Integer getMoney() {
        return money;
    }
}
