package lotto.domain;

import static constant.MessageList.*;

public class InputValidator {

    public InputValidator() {
    }

    // 구입 금액에 대한 검증
    public int validatePurchaseAmount(String purchaseAmountFromPlayer){
        int purchaseAmount = validateNumber(purchaseAmountFromPlayer);
        validatePositiveNumber(purchaseAmount);
        validateDivisible(purchaseAmount);
        return purchaseAmount;
    }

    private int validateNumber(String purchaseAmountFromPlayer) {
        try {
            return Integer.parseInt(purchaseAmountFromPlayer);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NOT_NUMBER);
        }
    }

    private void validatePositiveNumber(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NOT_POSITIVE_NUMBER);
        }
    }

    private void validateDivisible(int purchaseAmount) {
        if (purchaseAmount / PRICE_OF_ONE_LOTTO == 0) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NOT_DIVISIBLE);
        }
    }

    // 당첨 번호에 대한 검증

    // 보너스 번호에 대한 검증
}
