package lotto.model;

import static lotto.utils.Constants.LOTTO_PRICE;

import lotto.validation.ModelValidation;

public class LottoMoney {
    private final int money;

    public LottoMoney(final int money) {
        validation(money);
        this.money = money;
    }

    private void validation(int money) {
        ModelValidation.validateThousandUnit(money);
        ModelValidation.validateLimit(money);
    }

    public int calculateCountLottoPrice() {
        return money / LOTTO_PRICE;
    }
}
