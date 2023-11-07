package lotto.validation;

import static lotto.validation.constant.PurchaseInputConstant.ONE_LOTTO_PRICE;
import static lotto.validation.constant.PurchaseInputConstant.POSITIVE_CHECK_NUMBER;
import static lotto.validation.constant.PurchaseInputConstant.POSITIVE_MESSAGE;
import static lotto.validation.constant.PurchaseInputConstant.VALUE_DIVIDE_MESSAGE;

public class PurchaseInputValidator {

    public void validatePositive(String input) {
        int amountInput = Integer.parseInt(input);
        if (isNotPositive(amountInput)) {
            throw new IllegalArgumentException(POSITIVE_MESSAGE.getMessage());
        }
    }

    private boolean isNotPositive(int amountInput) {
        return amountInput < POSITIVE_CHECK_NUMBER.getNumber();
    }

    public void validateDivisibilityBy1000(String input) {
        int amountInput = Integer.parseInt(input);
        if (isNotValueDivisibleBy1000(amountInput)) {
            throw new IllegalArgumentException(VALUE_DIVIDE_MESSAGE.getMessage());
        }
    }

    private boolean isNotValueDivisibleBy1000(int amountInput) {
        return !(amountInput % ONE_LOTTO_PRICE.getNumber() == 0);
    }

    public void validateAmountInput(String input) {
        validatePositive(input);
        validateDivisibilityBy1000(input);
    }
}
