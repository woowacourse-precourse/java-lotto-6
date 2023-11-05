package lotto.vo;

import static lotto.constant.LottoInfo.ONE_LOTTO_PRICE;

import lotto.exception.InsufficientAmountException;
import lotto.exception.RemainingChangeException;

public record PurchaseAmount(Integer amount) {

    private static final Integer ZERO = 0;

    public PurchaseAmount {
        validateAmount(amount);
    }

    private void validateAmount(final Integer amount) {
        if (isLessThanLottoPrice(amount)) {
            throw new InsufficientAmountException();
        }
        if (hasChange(amount)) {
            throw new RemainingChangeException();
        }
    }

    private boolean isLessThanLottoPrice(final Integer amount) {
        return amount < ONE_LOTTO_PRICE.getValue();
    }

    private boolean hasChange(final Integer amount) {
        return (amount % ONE_LOTTO_PRICE.getValue()) != ZERO;
    }
}
