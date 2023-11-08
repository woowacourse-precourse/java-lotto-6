package lotto.domain;

import static lotto.constant.ErrorMessage.WRONG_BUY_PRICE;
import static lotto.constant.ErrorMessage.WRONG_MAXIMUM_BUY;
import static lotto.constant.ErrorMessage.WRONG_MINIMUM_BUY;
import static lotto.constant.GameNumber.MAX_LOTTO_AMOUNT;
import static lotto.constant.GameNumber.MIN_LOTTO_AMOUNT;

public class Price {

    private final long price;

    public Price(long price) {
        validate(price);
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public long getAmount() {
        return price / 1000;
    }

    private void validate(long price) {
        validateRemainder(price);
        validateMinimum(price);
        validateMaximum(price);
    }

    private void validateRemainder(long price) {
        if (price % 1000 != 0 || price <= 0) {
            throw new IllegalArgumentException(WRONG_BUY_PRICE.getMessage());
        }
    }

    private void validateMinimum(long price) {
        if ((price / 1000) < MIN_LOTTO_AMOUNT.getNumber()) {
            throw new IllegalArgumentException(WRONG_MINIMUM_BUY.getMessage());
        }
    }

    private void validateMaximum(long price) {
        if ((price / 1000) > MAX_LOTTO_AMOUNT.getNumber()) {
            throw new IllegalArgumentException(WRONG_MAXIMUM_BUY.getMessage());
        }
    }
}
