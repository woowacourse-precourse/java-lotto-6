package lotto.model;

import lotto.config.ErrorMessage;
import lotto.config.LottoConfig;
import lotto.util.Validator;

public class Money {

    private final int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money from(String amount) {
        int parsedAmount = convertToInt(amount);
        validatePurchaseAmount(parsedAmount);

        return new Money(parsedAmount);
    }

    private static int convertToInt(String amount) {
        return Validator.validateAndParseInteger(amount);
    }
    private static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % LottoConfig.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT
                    .getFormattedMessage(LottoConfig.LOTTO_PRICE.getValue()));
        }
    }

    public int getAmount() {
        return this.amount;
    }

}
