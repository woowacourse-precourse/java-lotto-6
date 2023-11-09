package lotto.domain;

import lotto.exception.InputException;

import static lotto.configuration.GameConfiguration.LOTTO_PRICE_PER_UNIT;
import static lotto.configuration.GameConfiguration.MIN_PRICE;
import static lotto.configuration.GameConfiguration.STANDARD_PARTS_PER;
import static lotto.exception.errorcode.InputErrorCode.INVALID_LOTTO_PURCHASE_PRICE;
import static lotto.exception.errorcode.InputErrorCode.INVALID_LOTTO_PURCHASE_PRICE_RANGE;

public class Purchase {
    private final long price;

    public Purchase(final long price) {
        validatePrice(price);
        this.price = price;
    }

    public double getProfitRate(final long revenue) {
        return STANDARD_PARTS_PER * ((double) revenue / price);
    }

    public long getPrice() {
        return price;
    }

    private void validatePrice(final long price) {
        if (price < MIN_PRICE) {
            throw new InputException(INVALID_LOTTO_PURCHASE_PRICE_RANGE);
        }

        if (price % LOTTO_PRICE_PER_UNIT != 0) {
            throw new InputException(INVALID_LOTTO_PURCHASE_PRICE);
        }
    }
}
