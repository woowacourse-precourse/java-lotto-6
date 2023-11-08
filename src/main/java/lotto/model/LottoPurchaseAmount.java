package lotto.model;

import lotto.constant.LottoConfig;
import lotto.exception.model.BusinessConditionException;

import static lotto.view.message.ValidationErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_THOUSAND;
import static lotto.view.message.ValidationErrorMessage.PURCHASE_AMOUNT_NOT_POSITIVE;

public record LottoPurchaseAmount(int amount) {
    private static final int MINIMUM_AMOUNT_THRESHOLD = 0;
    private static final int NO_REMAINDER = 0;

    public LottoPurchaseAmount {
        validatePositive(amount);
        validateMultipleOfThousand(amount);
    }

    private void validatePositive(int amount) {
        if (amount <= MINIMUM_AMOUNT_THRESHOLD) {
            throw new BusinessConditionException(PURCHASE_AMOUNT_NOT_POSITIVE.getMessage());
        }
    }

    private void validateMultipleOfThousand(int amount) {
        if ((amount % LottoConfig.TICKET_PRICE.getValue()) != NO_REMAINDER) {
            throw new BusinessConditionException(PURCHASE_AMOUNT_NOT_MULTIPLE_THOUSAND.getMessage());
        }
    }
}
