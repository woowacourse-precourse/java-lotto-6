package lotto.controller;

import lotto.utils.ExceptionMessage;

public class LottoController {

    public void publishLotto(String inputPurchaseAmount) throws IllegalArgumentException {
        validatePurchaseAmountType(inputPurchaseAmount);
    }

    private int validatePurchaseAmountType(String inputPurchaseAmount) {
        try {
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_BUY_AMOUNT_TYPE);
        }
    }
}
