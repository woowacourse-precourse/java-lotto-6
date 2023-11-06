package lotto.view.input.validator;

import lotto.message.ErrorMessage;
import lotto.constants.LottoRule;

public class LottoGameInputValidator {

    public long parseLong(String requestNumber) {
        long number;
        try {
            number = Long.parseLong(requestNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_FORMAT.getMessage());
        }
        return number;
    }

    public void validatePositiveNumber(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_LESS_THAN_ZERO.getMessage());
        }
    }

    public void validateLottoPurchase(long amount) {
        if (isPurchaseLottoPossible(amount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_AMOUNT.getMessage());
        }
    }

    private boolean isPurchaseLottoPossible(long amount) {
        return amount % LottoRule.STANDARD.getLottoPrice() != 0;
    }
}
