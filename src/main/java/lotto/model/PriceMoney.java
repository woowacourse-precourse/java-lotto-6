package lotto.model;

public class PriceMoney extends Money {
    private static final String NEGATIVE_MONEY = "상금은 음수가 될 수 없습니다.";
    public PriceMoney(long money) {
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_MONEY);
        }
        value = money;
    }

    public PriceMoney mulByEa(int ea) {
        if (ea < 0) {
            throw new IllegalArgumentException(NEGATIVE_MONEY);
        }
        value *= ea;
        return this;
    }

    public PriceMoney add(PriceMoney priceMoney) {
        value += priceMoney.value;
        return this;
    }

    public double div(LottoTicketMoney lottoTicketMoney) {
        return lottoTicketMoney.calculateIncomeRate(value);
    }
}
