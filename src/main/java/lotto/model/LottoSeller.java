package lotto.model;

import lotto.validator.AmountValidator;

public class LottoSeller {
    public static final int LOTTO_PRICE = 1000;

    public int calculateLottoTickets(int purchasingMoney) {
        AmountValidator.validateAmount(purchasingMoney);
        return purchasingMoney / LOTTO_PRICE;
    };
}
