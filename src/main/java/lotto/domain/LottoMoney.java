package lotto.domain;

import lotto.exception.ZeroMoneyException;

public class LottoMoney {
    private static final int CANNOT_DIVIDE = 0;
    private static final int PURCHASE_LOTTO_MONEY = 1000;

    private void validateZero(int money) {
        if (money == CANNOT_DIVIDE) {
            throw new ZeroMoneyException();
        }
    }

    public int getTicketCount(Money money) {
        int requestMoney = money.getMoney();
        validateZero(requestMoney);
        return requestMoney / PURCHASE_LOTTO_MONEY;
    }
}
