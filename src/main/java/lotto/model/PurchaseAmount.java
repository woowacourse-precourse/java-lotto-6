package lotto.model;

import lotto.constant.ErrorMessage;

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
        if (amount < 1000 || amount > 100000) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_RANGE.getMessage());
        }
    }

    private void validateUnit(Integer amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_UNIT.getMessage());
        }
    }

    public Integer exchangeLottoTicket() {
        return amount / 1000;
    }
}
