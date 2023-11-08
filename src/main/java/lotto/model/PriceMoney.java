package lotto.model;

import java.util.Objects;

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
        if (value == 0) return 0;
        return lottoTicketMoney.calculateIncomeRate(value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof PriceMoney otherPriceMoney)) return false;
        return value == otherPriceMoney.value;
    }
}
