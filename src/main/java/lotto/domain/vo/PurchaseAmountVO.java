package lotto.domain.vo;

import lotto.utils.ParserUtil;
import lotto.utils.ValidationUtil;

public class PurchaseAmountVO {
    private final int amount;

    public PurchaseAmountVO(String input) {
        this.amount = parseValidate(input);
    }

    private int parseValidate(String input) {
        validateInput(input);
        int parsedAmount = ParserUtil.parseLottoNumber(input);
        validateParsedAmount(parsedAmount);
        return parsedAmount;
    }

    private void validateInput(String input) {
        ValidationUtil.validateBlank(input);
        ValidationUtil.validateSpecialCharacters(input);
        ValidationUtil.validateOutOfRange(input);
    }

    private void validateParsedAmount(int amount) {
        ValidationUtil.validatePurchaseAmountRange(amount);
        ValidationUtil.validateThousandUnit(amount);
    }

    public int getAmount() {
        return amount;
    }
}
