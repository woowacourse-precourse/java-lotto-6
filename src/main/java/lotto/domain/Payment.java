package lotto.domain;

import static lotto.utils.ErrorMessage.IS_LOWER_THAN_PRICE;
import static lotto.utils.ErrorMessage.IS_NOT_DIVIDED_INTO;

public record Payment(int payment) {
    private static final int LOTTO_PRICE = 1000;

    public Payment {
        validate(payment);
    }

    private void validate(int payment) {
        if (isLowerThanPrice(payment)) {
            throw new IllegalArgumentException(IS_LOWER_THAN_PRICE.getMessage().formatted(LOTTO_PRICE));
        }
        if (isNotDividedBy(payment)) {
            throw new IllegalArgumentException(IS_NOT_DIVIDED_INTO.getMessage().formatted(LOTTO_PRICE));
        }
    }

    private boolean isNotDividedBy(int payment) {
        return payment % LOTTO_PRICE != 0;
    }

    private boolean isLowerThanPrice(int payment) {
        return payment < LOTTO_PRICE;
    }

    public int getLottoPrice() {
        return LOTTO_PRICE;
    }
}
