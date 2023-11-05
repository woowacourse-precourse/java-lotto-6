package lotto.vo;

import static lotto.constant.ErrorMessage.LOTTO_MIN_PRICE_ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.REMAINING_CHANGE_ERROR_MESSAGE;
import static lotto.constant.LottoInfo.ONE_LOTTO_PRICE;

public record PurchaseAmount(Integer amount) {

    private static final Integer ZERO = 0;

    public PurchaseAmount {
        validateAmount(amount);
    }

    private void validateAmount(final Integer amount) {
        if (isLessThanLottoPrice(amount)) {
            throw new IllegalArgumentException(LOTTO_MIN_PRICE_ERROR_MESSAGE.getMessage());
        }

        if (hasChange(amount)) {
            throw new IllegalArgumentException(REMAINING_CHANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isLessThanLottoPrice(final Integer amount) {
        return amount < ONE_LOTTO_PRICE.getValue();
    }

    private boolean hasChange(final Integer amount) {
        return (amount % ONE_LOTTO_PRICE.getValue()) != ZERO;
    }
}
