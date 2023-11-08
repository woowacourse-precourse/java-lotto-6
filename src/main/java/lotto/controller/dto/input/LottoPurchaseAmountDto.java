package lotto.controller.dto.input;

import lotto.common.constants.LottoRule;
import lotto.util.InputValidator;
import lotto.util.Parser;

public record LottoPurchaseAmountDto(String purchaseAmount) {
    private static final int PURCHASE_AMOUNT_MIN_LENGTH = 1;
    private static final int PURCHASE_AMOUNT_MAX_LENGTH = String.valueOf(
            LottoRule.LOTTO_PURCHASE_AMOUNT_MAX.value).length();

    public LottoPurchaseAmountDto {
        InputValidator.validateLength(purchaseAmount, PURCHASE_AMOUNT_MIN_LENGTH, PURCHASE_AMOUNT_MAX_LENGTH);
        InputValidator.validateHasText(purchaseAmount);
        InputValidator.validateNumeric(purchaseAmount);
    }

    public int toInt() {
        return Parser.toInt(purchaseAmount);
    }
}
