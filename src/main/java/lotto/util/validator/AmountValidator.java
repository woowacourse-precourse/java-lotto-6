package lotto.util.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstants;

public class AmountValidator implements InputValidator<Integer> {
    private static final int NO_REMAINDER = 0;

    @Override
    public void validate(Integer amount) {
        validateIsPositive(amount);
        validateIsMultipleOfThousand(amount);
    }


    private void validateIsPositive(Integer amount) {
        if (amount < LottoConstants.PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_SMALL_THAN_THOUSAND);
        }
    }

    private void validateIsMultipleOfThousand(Integer amount) {
        if (amount % LottoConstants.PRICE_PER_LOTTO != NO_REMAINDER) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MULTIPLE_OF_THOUSAND);
        }
    }
}
