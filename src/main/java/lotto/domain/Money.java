package lotto.domain;

import static lotto.domain.enums.Constant.LOTTO_PRICE;
import static lotto.domain.enums.ErrorMessage.MONEY_AMOUNT_ERROR_MESSAGE;

public class Money {

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getPurchaseLottoCount() {
        return money / LOTTO_PRICE.getConstant();
    }

    private void validate(final int money) {
        if (isNotMultipleOfLottoPrice(money) || isNegativeOrZero(money)) {
            throw new IllegalArgumentException(MONEY_AMOUNT_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isNotMultipleOfLottoPrice(int money) {
        return money % LOTTO_PRICE.getConstant() != 0;
    }

    private boolean isNegativeOrZero(int money) {
        return money <= 0;
    }

}
