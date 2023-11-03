package lotto.Controller;


import lotto.MagicNumber;
import lotto.Message;

public class PurchaseAmountValidator implements Validator {


    private int purchaseAmount;

    @Override
    public void validate(String purchaseAmount) throws IllegalArgumentException {
        isNumber(purchaseAmount);
        isNotZero(purchaseAmount);
        isDivisibleBy1000(purchaseAmount);
    }

    private void isNumber(String input) {
        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.NON_NUMERIC_EXCEPTION_MESSAGE);
        }
    }

    private void isNotZero(String input) {
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException(Message.ZERO_EXCEPTION_MESSAGE);
        }
    }

    private void isDivisibleBy1000(String input) {
        if (purchaseAmount % MagicNumber.UNIT_PURCHASE_PRICE != 0) {
            throw new IllegalArgumentException(Message.INDIVISIBLE_BY_UNIT_PRICE_EXCEPTION_MESSAGE);
        }
    }
}
