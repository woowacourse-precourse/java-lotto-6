package lotto.domain.vo;

import lotto.utils.ParserUtil;
import lotto.utils.ValidationUtil;

public class PurchaseAmountVO {
    private final int amount;

    public PurchaseAmountVO(String input) {
        ValidationUtil.validateBlank(input);
        ValidationUtil.validateSpecialCharacters(input);
        ValidationUtil.validateOutOfRange(input);
        int parsedAmount = ParserUtil.parseLottoNumber(input);
        ValidationUtil.validatePurchaseAmountRange(parsedAmount);
        ValidationUtil.validateThousandUnit(parsedAmount);
        this.amount = parsedAmount;
    }

    public int getAmount() {
        return amount;
    }
}
