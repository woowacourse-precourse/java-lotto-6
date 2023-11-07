package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoGameException;

public class Cash {
    private static final int LOTTO_PRICE = 1000;

    private final Integer amount;

    public Cash(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(Integer amount) {
        if (isAmountNotInMultipleOfLottoPrice(amount)) {
            throw new LottoGameException(ErrorMessage.INVALID_AMOUNT);
        }
    }

    private boolean isAmountNotInMultipleOfLottoPrice(Integer amount) {
        return amount % LOTTO_PRICE != 0;
    }

    public Integer calculateNumberOfLottos() {
        return amount / LOTTO_PRICE;
    }

    public Integer getAmount() {
        return amount;
    }
}
