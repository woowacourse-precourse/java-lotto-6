package lotto.controller.validator;


import lotto.utils.GameConstants;
import lotto.utils.Message;

public class PurchaseAmountValidator implements Validator {


    private int purchaseAmount;

    @Override
    public void validate(String purchaseAmount) throws IllegalArgumentException {
        isNumber(purchaseAmount);
        isNotZero();
        isDivisibleBy1000();
    }

    private void isNumber(String input) {
        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.NON_NUMERIC_EXCEPTION_MESSAGE);
        }
    }

    private void isNotZero() {
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException(Message.ZERO_EXCEPTION_MESSAGE);
        }
    }

    private void isDivisibleBy1000() {
        if (purchaseAmount % GameConstants.UNIT_PURCHASE_PRICE != 0) {
            throw new IllegalArgumentException(Message.INDIVISIBLE_BY_UNIT_PRICE_EXCEPTION_MESSAGE);
        }
    }
}
