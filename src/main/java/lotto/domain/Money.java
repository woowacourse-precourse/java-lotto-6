package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.constants.NumberType;

public class Money {

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getLottoPurchaseCount() {
        return money / NumberType.LOTTO_PRICE.getValue();
    }

    public int getMoney() {
        return money;
    }

    private void validateMoney(int money) {
        if (!checkMoneyDivideByLottoPrice(money)) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_MONEY_ERROR.getMessage(), NumberType.LOTTO_PRICE.getValue()));
        }
    }

    private boolean checkMoneyDivideByLottoPrice(int money) {
        return money % NumberType.LOTTO_PRICE.getValue() == 0;
    }
}
