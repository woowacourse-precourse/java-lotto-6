package lotto.controller.dto.input;

import lotto.common.constants.LottoRule;
import lotto.util.Parser;
import lotto.util.Validator;

public record LottoPurchaseAmountDto(String purchaseAmount) {
    private static final int PURCHASE_AMOUNT_MIN_LENGTH = 1;
    private static final int PURCHASE_AMOUNT_MAX_LENGTH = String.valueOf(
            LottoRule.LOTTO_PURCHASE_AMOUNT_MAX.value).length();

    public LottoPurchaseAmountDto {
        Validator.validateLength(purchaseAmount, PURCHASE_AMOUNT_MIN_LENGTH, PURCHASE_AMOUNT_MAX_LENGTH);
        Validator.validateHasText(purchaseAmount);
        Validator.validateNumeric(purchaseAmount);
    }

    public int toInt() {
        return Parser.toInt(purchaseAmount);
    }
}
