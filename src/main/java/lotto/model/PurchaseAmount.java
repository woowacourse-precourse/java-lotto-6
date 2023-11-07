package lotto.model;

import lotto.exception.ExceptionMessage;

import static lotto.validator.Validator.validateCondition;

public class PurchaseAmount {

    private int amount;
    private int times;

    public PurchaseAmount(String amount) {
        validatePurchaseAmount(amount);
        this.amount = Integer.parseInt(amount);
        this.times = this.amount / 1000;
    }

    private void validatePurchaseAmount(String amount) {
        validateCondition(isBlankOrEmpty(amount), ExceptionMessage.NOT_EMPTY_OR_BLANK);
        validateCondition(!isDigit(amount), ExceptionMessage.IS_NOT_DIGIT);
        validateCondition(isZeroOrMinus(amount), ExceptionMessage.NOT_MINUS_OR_ZERO);
        validateCondition(!isBeingDivided(amount), ExceptionMessage.IS_NOT_BEING_DIVIDED);
    }

    private boolean isDigit(String amount) {
        return amount.matches("-?\\d+");
    }

    private boolean isZeroOrMinus(String amount) {
        int number = Integer.parseInt(amount);
        return number <= 0;
    }

    private boolean isBeingDivided(String amount) {
        return Integer.parseInt(amount) % 1000 == 0;
    }

    private boolean isBlankOrEmpty(String amount) {
        return amount.isBlank() || amount.isEmpty();
    }

    public int getAmount() {
        return amount;
    }

    public int getTimes() {
        return times;
    }
}
