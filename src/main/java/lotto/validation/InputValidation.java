package lotto.validation;

import static lotto.constant.ErrorMessage.DIGIT_EXCEPTION;
import static lotto.constant.ErrorMessage.MULTIPLE_EXCEPTION;
import static lotto.constant.ErrorMessage.NULL_EXCEPTION;
import static lotto.constant.LottoConstant.LOTTO_PRICE;

public class InputValidation {
    public void validatePurchaseCost(String purchaseCost) {
        validateBlank(purchaseCost);
        validateDigit(purchaseCost);
        validateMultiple(purchaseCost);
    }

    private void validateBlank(String info) {
        if(isBlank(info)) {
            throw new IllegalArgumentException(NULL_EXCEPTION.getMessage());
        }
    }

    private boolean isBlank(String info) {
        return info == null || info.isBlank();
    }

    private void validateDigit(String info) {
        try {
            Integer.parseInt(info);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DIGIT_EXCEPTION.getMessage());
        }
    }

    private void validateMultiple(String info) {
        int money = Integer.parseInt(info);
        if(money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MULTIPLE_EXCEPTION.getMessage());
        }
    }
}
