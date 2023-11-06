package lotto.domain;

import static lotto.validate.ValidateMessage.*;

public class LottoAmount {

    private final int amount;

    public LottoAmount(String amount) {
        int amountNumber = validateNumber(amount);
        validateAmount(amountNumber);
        this.amount = amountNumber;
    }

    private void validateAmount(int amount) {
        validateThousand(amount);
        validateZero(amount);
    }

    private int validateNumber(String amount) {
        if (!amount.matches(INPUT_AMOUNT_TYPE)) {
            throw new IllegalArgumentException(ERROR_NUMBER_MESSAGE);
        }
        return Integer.parseInt(amount);
    }

    private void validateThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_THOUSAND_MESSAGE);
        }
    }

    private void validateZero(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException(ERROR_ZERO_MESSAGE);
        }
    }

    public int getAmount() {
        return amount;
    }
}
