package lotto.domain;

import lotto.utils.Validator;

import static constant.MessageList.*;
import static constant.MessageList.ERROR_INPUT_IS_NOT_POSITIVE_NUMBER;

public class LottoAmount {
    Validator validator;

    public LottoAmount() {
        validator = new Validator();
    }

    //구입 금액에 대한 검증
    public int validatePurchaseAmount(String purchaseAmountFromPlayer) {
        int purchaseAmount = validator.validateNumber(purchaseAmountFromPlayer);
        validatePositiveNumber(purchaseAmount);
        validateDivisible(purchaseAmount);
        return purchaseAmount;
    }

    private void validatePositiveNumber(int number) {
        if (number <= ZERO) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NOT_POSITIVE_NUMBER);
        }
    }

    private void validateDivisible(int purchaseAmount) {
        if (purchaseAmount / PRICE_OF_ONE_LOTTO == ZERO) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NOT_DIVISIBLE);
        }
    }

    public int getPurchaseQuantityOfLotto(int purchaseAmount) {
        return purchaseAmount / PRICE_OF_ONE_LOTTO;
    }

}
