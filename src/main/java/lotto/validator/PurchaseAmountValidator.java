package lotto.validator;

import static lotto.util.Constants.LOTTO_PRICE;

import lotto.message.ExceptionMessage;
import lotto.util.LottoUtil;

public class PurchaseAmountValidator {

    public static void validate(String inputAmount) {
        int purchaseAmount = LottoUtil.parseInputToNumber(inputAmount);
        validateNaturalNumber(purchaseAmount);
        validateDivisibleByPrice(purchaseAmount);
    }

    private static void validateNaturalNumber(int inputAmount) {
        if (inputAmount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    private static void validateDivisibleByPrice(int inputAmount) {
        if (inputAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INDIVISIBLE_AMOUNT.getMessage());
        }
    }

}
