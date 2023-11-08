package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoGameException;
import lotto.util.LottoConstants;

public class Cash {

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
        return amount % LottoConstants.LOTTO_PRICE.getValue() != 0;
    }

    public Integer calculateNumberOfLottos() {
        return amount / LottoConstants.LOTTO_PRICE.getValue();
    }

    public Integer getAmount() {
        return amount;
    }
}
