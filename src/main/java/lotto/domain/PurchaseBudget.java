package lotto.domain;

import static lotto.constants.Constants.Integers.LOTTO_PRICE;
import static lotto.constants.Constants.Integers.NOTHING_REMAIN;
import static lotto.constants.ErrorMessage.HAVE_TO_INPUT_MORE_THAN_LOTTO_PRICE;
import static lotto.constants.ErrorMessage.HAVE_TO_INPUT_MULTIPLE_OF_LOTTO_PRICE;

public class PurchaseBudget {
    private final int budget;

    public PurchaseBudget(int budget) {
        validate(budget);
        this.budget = budget;
    }

    private void validate(int budget) {
        if (budget < LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(HAVE_TO_INPUT_MORE_THAN_LOTTO_PRICE.getMessage());
        }

        if (!isMultipleOfLottoPrice(budget)) {
            throw new IllegalArgumentException(HAVE_TO_INPUT_MULTIPLE_OF_LOTTO_PRICE.getMessage());
        }
    }

    private boolean isMultipleOfLottoPrice(int budget) {
        return budget % LOTTO_PRICE.getValue() == NOTHING_REMAIN.getValue();
    }

    public int getBudget() {
        return budget;
    }

    public PurchaseQuantity createQuantity() {
        return new PurchaseQuantity(budget);
    }
}
