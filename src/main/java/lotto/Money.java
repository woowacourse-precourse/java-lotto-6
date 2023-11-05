package lotto;

import constants.ErrorMessage;
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
        if (!checkMoneyDivideByLottoPrice(money)) {
            throw new IllegalArgumentException(String.format(ErrorMessage.INVALID_MONEY_ERROR.getMessage(), NumberType.LOTTO_PRICE.getValue()));
        }
    }
    private boolean checkMoneyDivideByLottoPrice(int money) {
        return money % NumberType.LOTTO_PRICE.getValue() == 0;
    }
}
