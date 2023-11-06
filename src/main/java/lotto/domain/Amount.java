package lotto.domain;

import lotto.domain.constants.LottoRule;
import lotto.message.ErrorMessage;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public void validate(final int amount) {
        validateAmountNegativeNumber(amount);
        validateAmountEnough(amount);
        validateAmountDivide(amount);
    }

    public void validateAmountNegativeNumber(final int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_IS_NOT_ZERO.getValue());
        }
    }

    public void validateAmountEnough(final int amount) {
        if (amount < LottoRule.PRICE.getValue()) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.PURCHASE_AMOUNT_IS_NOT_ENOUGH.getValue(),
                            LottoRule.PRICE.getValue())
            );
        }
    }

    public void validateAmountDivide(final int amount) {
        if (amount % LottoRule.PRICE.getValue() != 0) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNITS.getValue(),
                            LottoRule.PRICE.getValue())
            );
        }
    }
}
