package lotto.domain;

import static lotto.ErrorMessage.LOTTO_PURCHASE_ERROR;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public Lottos purchaseLotto(Money purchaseMoney) {
        validate(purchaseMoney);
        return new Lottos();
    }

    private static void validate(Money purchaseMoney) {
        if (!purchaseMoney.isUnitOf(LOTTO_PRICE)) {
            throw new IllegalArgumentException(String.format(LOTTO_PURCHASE_ERROR.getMessage(), LOTTO_PRICE));
        }
    }
}
