package lotto.model.domain;

import lotto.constance.GameConst;
import lotto.exception.LottoGameException;

public class Money {
    int money;

    public Money(int money) {
        validateMoneyUnit(money);
        validateMoneyRange(money);
        this.money = money;
    }

    private static void validateMoneyUnit(int money) {
        if (money % 1000 != 0) {
            throw LottoGameException.WRONG_MONEY_UNIT.makeException();
        }
    }

    private static void validateMoneyRange(int money) {
        if (money > GameConst.LOTTO_PURCHASE_LIMIT) {
            throw LottoGameException.OVER_PURCHASE_LIMIT.makeException();
        }
    }

    int getMoney() {
        return money;
    }

    public Money snapShot() {
        return new Money(this.money);
    }

    public boolean possibleToPurchaseLotto() {
        return this.money >= GameConst.LOTTO_PRICE;
    }

    public void purchaseLotto() {
        this.money -= GameConst.LOTTO_PRICE;
    }
}
