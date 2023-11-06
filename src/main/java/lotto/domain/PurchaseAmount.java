package lotto.domain;

import lotto.Utils;
import lotto.exception.ExceptionMessage;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(String input) {
        int inputAmount =  Utils.convertStringToInt(input);
        validate(inputAmount);
        this.purchaseAmount = inputAmount;
    }

    private void validate(int inputAmount) {
        validateNaturalNumber(inputAmount);
    }

    private void validateNaturalNumber(int inputAmount) {
        if (inputAmount < 1) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.get());
        }
    }
}
