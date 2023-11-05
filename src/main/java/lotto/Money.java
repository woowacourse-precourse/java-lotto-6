package lotto;

import constants.NumberType;

public class Money {

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getLottoCount() {
        return money / NumberType.LOTTO_PRICE.getValue();
    }

    private void validateMoney(int money) {
        if (!checkMoney(money)) {
            throw new IllegalArgumentException(NumberType.LOTTO_PRICE.getValue() + "원으로 나누어 떨어지지 않습니다.");
        }
    }
    private boolean checkMoney(int money) {
        return money % NumberType.LOTTO_PRICE.getValue() == 0;
    }
}
