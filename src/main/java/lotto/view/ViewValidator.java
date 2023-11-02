package lotto.view;

import static lotto.constant.ExceptionConstant.BUYING_PRICE_INPUT_EXCEPTION;
import static lotto.constant.NumberConstant.BUYING_PRICE_UNIT;
import static lotto.constant.NumberConstant.ZERO;

public class ViewValidator {

    public boolean validateBuyingPrice(final String buyingPriceText) {
        int buyingPrice = Integer.parseInt(buyingPriceText);

        try {
            validateMod(buyingPrice);
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
            return false;
        }

        return true;
    }

    private void validateMod(final int buyingPrice) {
        if (buyingPrice % BUYING_PRICE_UNIT != ZERO) {
            throw new IllegalArgumentException(BUYING_PRICE_INPUT_EXCEPTION.message);
        }
    }

    private void printExceptionMessage(final IllegalArgumentException e) {
        String exceptionMessage = e.getMessage();
        System.out.println(exceptionMessage);
    }
}
