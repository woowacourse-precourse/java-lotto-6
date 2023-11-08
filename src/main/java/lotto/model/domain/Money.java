package lotto.model.domain;

import lotto.constance.GameConst;
import lotto.exception.LottoGameException;

public class Money {

    private int money;

    public Money(int money) {
        validateMoneyUnit(money);
        validateMoneyRange(money);
        this.money = money;
    }

    private static void validateMoneyUnit(int money) {
        if (money % GameConst.MONEY_UNIT != 0) {
            throw LottoGameException.WRONG_MONEY_UNIT.makeException();
        }
    }

    private static void validateMoneyRange(int money) {
        if (money > GameConst.LOTTO_PURCHASE_LIMIT) {
            throw LottoGameException.OVER_PURCHASE_LIMIT.makeException();
        }
    }

    /**
     * 금액 정보를 반환합니다.
     * <p>
     * 같은 패키지에 위치한 도메인 객체 (더 정확히는 `Revenue` 객체)에게만 해당 메서드를 제공하기 위해 `default` 제어자 사용
     * </p>
     */
    int getMoney() {
        return money;
    }

    /**
     * 현재의 금액 정보를 새로운 Money 객체로 반환합니다.
     */
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
