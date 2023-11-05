package lotto.util;

import static lotto.domain.lotto.LottoConstants.LOTTO_PRICE;
import static lotto.util.ErrorMessage.NOT_THOUSAND;

public class PurchaseAmountValidator {

    public void validate(String userInput) throws IllegalArgumentException {
        new Validator().validate(userInput);
        validateThousand(userInput);
    }

    private void validateThousand(String userInput) {
        int number = Integer.parseInt(userInput);
        if (number % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(NOT_THOUSAND.getMessage());
        }
    }
}
