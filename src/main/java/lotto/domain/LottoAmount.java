package lotto.domain;

import static lotto.enums.LottoConfig.LOTTO_PRICE;
import static lotto.enums.ErrorMassage.INCORRECT_AMOUNT_UNIT;
import static lotto.enums.ErrorMassage.NOT_ENOUGH_AMOUNT;

public class LottoAmount {
    private int amount;

    public LottoAmount(int amount) {
        validateLottoPrice(amount);
        validateAmountUnit(amount);
        this.amount = amount;
    }

    private void validateLottoPrice(int amount) {
        if (amount < LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(NOT_ENOUGH_AMOUNT.getMassage());
        }
    }

    private void validateAmountUnit(int amount) {
        if (amount % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(INCORRECT_AMOUNT_UNIT.getMassage());
        }
    }
}
