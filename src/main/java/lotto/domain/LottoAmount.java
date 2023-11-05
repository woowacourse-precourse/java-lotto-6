package lotto.domain;

import static lotto.domain.LottoConfig.LOTTO_PRICE;
import static lotto.enums.ErrorMassage.NOT_ENOUGH_AMOUNT;

public class LottoAmount {
    private int amount;

    public LottoAmount(int amount) {
        validateLottoPrice(amount);
        this.amount = amount;
    }

    private void validateLottoPrice(int amount) {
        if (amount < LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(NOT_ENOUGH_AMOUNT.getMassage());
        }
    }
}
