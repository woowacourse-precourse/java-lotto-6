package lotto.Controller;


import lotto.Message;

public class PurchaseAmountValidator implements Validator {
    private static final int UNIT_PURCHASE_PRICE = 1000;

    private int purchaseAmount;


    public void validate(String input) throws IllegalArgumentException {
        isNumber(input);
        isNotZero(input);
        isDivisibleBy1000(input);
    }

    private void isNumber(String input) {
        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.NOT_A_NUMBER_EXCEPTION);
        }
    }

    private void isNotZero(String input) {
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException(Message.ZERO_EXCEPTION_MESSAGE);
        }
    }

    private void isDivisibleBy1000(String input) {
        if (purchaseAmount % UNIT_PURCHASE_PRICE != 0) {
            throw new IllegalArgumentException(Message.INDIVISIBLE_BY_UNIT_PRICE_EXCEPTION_MESSAGE);
        }
    }
}
