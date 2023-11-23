package lotto.domain.lotto.money;

import lotto.exception.LottoException;

public class Cash {
    private int cash;

    public Cash(int cash) {
        validateCash(cash);
        this.cash = cash;
    }

    private void validateCash(int cash) {
        if (cash < 0) {
            throw LottoException.MONEY_INVALID_VALUE.makeException();
        }
    }

    public boolean canPurchase(int price) {
        return this.cash >= price;
    }

    public void spend(int price) {
        if (this.cash < price) {
            throw LottoException.CANT_SPEND_MONEY.makeException();
        }
        this.cash -= price;
    }
}
