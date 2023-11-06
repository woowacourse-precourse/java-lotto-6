package lotto.input;

import lotto.util.StringUtil;

public class InputProcessor {
    private final InputValidator inputValidator = new InputValidator();

    public Integer processPurchaseAmount(String input) {
        Integer purchaseAmount = StringUtil.convertToInteger(input);
        inputValidator.validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }
}
