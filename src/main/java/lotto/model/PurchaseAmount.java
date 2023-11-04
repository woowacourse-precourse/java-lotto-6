package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.Rule;

public class PurchaseAmount {

    private final Integer amount;

    private PurchaseAmount(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    public static PurchaseAmount of(Integer value) {
        return new PurchaseAmount(value);
    }

    private void validate(Integer amount) {
        validateRange(amount);
        validateUnit(amount);
    }

    private void validateRange(Integer amount) {
        if (amount < Rule.MIN_MONEY || amount > Rule.MAX_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_RANGE.getMessage());
        }
    }

    private void validateUnit(Integer amount) {
        if (amount % Rule.MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_UNIT.getMessage());
        }
    }

    public Integer exchangeLottoTicket() {
        return amount / Rule.MONEY_UNIT;
    }

    public Integer getAmount() {
        return amount;
    }
}
