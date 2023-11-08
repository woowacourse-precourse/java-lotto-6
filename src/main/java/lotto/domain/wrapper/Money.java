package lotto.domain.wrapper;

import static lotto.handler.ConstantsHandler.*;
import static lotto.handler.ErrorHandler.*;

public class Money {

    private final int purchaseAmount;

    private Money(String money) {
        this.purchaseAmount = validateType(money);
        validateMoney(purchaseAmount);
        validateDivision(purchaseAmount);
    }

    public static Money create(String money) {
        return new Money(money);
    }

    private int validateType(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw INCONVERTIBLE_TYPE.getException();
        }
    }

    private void validateMoney(int purchaseAmount) {
        if (purchaseAmount <= MIN_PURCHASE_AMOUNT) {
            throw INVALID_NEGATIVE_INPUT.getException();
        }
    }

    private void validateDivision(int purchaseAmount) {
        if (purchaseAmount % UNIT_OF_AMOUNT != REMAINDER) {
            throw INVALID_DIVISION.getException();
        }
    }

    public int getTicket() {
        return purchaseAmount / UNIT_OF_AMOUNT;
    }
}
