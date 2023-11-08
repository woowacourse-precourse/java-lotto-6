package lotto;

import static lotto.constant.ErrorMessage.ONLY_NUMBERS_ALLOWED;
import static lotto.constant.ErrorMessage.WRONG_BUY_PRICE;
import static lotto.constant.ErrorMessage.WRONG_MAXIMUM_BUY;
import static lotto.constant.ErrorMessage.WRONG_MINIMUM_BUY;
import static lotto.constant.GameNumber.MAX_LOTTO_AMOUNT;
import static lotto.constant.GameNumber.MIN_LOTTO_AMOUNT;

public class Price {

    private long price;

    public Price(String input) {
        validate(input);
    }

    private void validate(String input) {
        validateNumeric(input);
        validateRemainder();
        validateMinimum();
        validateMaximum();
    }

    private void validateNumeric(String input) {
        try {
            this.price = Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBERS_ALLOWED.getMessage());
        }
    }

    private void validateRemainder() {
        if (this.price % 1000 != 0 || this.price <= 0) {
            throw new IllegalArgumentException(WRONG_BUY_PRICE.getMessage());
        }
    }

    private void validateMinimum() {
        if ((this.price / 1000) < MIN_LOTTO_AMOUNT.getNumber()) {
            throw new IllegalArgumentException(WRONG_MINIMUM_BUY.getMessage());
        }
    }

    private void validateMaximum() {
        if ((this.price / 1000) > MAX_LOTTO_AMOUNT.getNumber()) {
            throw new IllegalArgumentException(WRONG_MAXIMUM_BUY.getMessage());
        }
    }
}
