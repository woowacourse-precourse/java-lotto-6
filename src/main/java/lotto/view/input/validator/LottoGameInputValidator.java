package lotto.view.input.validator;

import static lotto.constants.LottoRule.STANDARD;
import static lotto.message.ErrorMessage.INVALID_AMOUNT_FORMAT;
import static lotto.message.ErrorMessage.AMOUNT_LESS_THAN_ZERO;
import static lotto.message.ErrorMessage.INVALID_LOTTO_AMOUNT;

public class LottoGameInputValidator {

    public long parseLong(String requestNumber) {
        long number;
        try {
            number = Long.parseLong(requestNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_AMOUNT_FORMAT.getMessage());
        }
        return number;
    }

    public void validatePositiveNumber(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException(AMOUNT_LESS_THAN_ZERO.getMessage());
        }
    }

    public void validateLottoPurchase(long amount) {
        if (isPurchaseLottoPossible(amount)) {
            throw new IllegalArgumentException(INVALID_LOTTO_AMOUNT.getMessage());
        }
    }

    private boolean isPurchaseLottoPossible(long amount) {
        return amount % STANDARD.getLottoPrice() != 0;
    }
}
