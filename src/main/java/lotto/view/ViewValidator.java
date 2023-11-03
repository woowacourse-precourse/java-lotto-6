package lotto.view;

import java.util.List;

import static lotto.constant.ExceptionConstant.BUYING_PRICE_INPUT_EXCEPTION;
import static lotto.constant.NumberConstant.BUYING_PRICE_UNIT;
import static lotto.constant.NumberConstant.ZERO;

public class ViewValidator {

    public boolean validateBuyingPrice(final int buyingPrice) {
        try {
            validateMod(buyingPrice);
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
            return false;
        }

        return true;
    }

    public boolean validateWinningNumbers(final List<String> winningNumbersText) {
        try {
            for (String text : winningNumbersText) {
                int winningNumber = Integer.parseInt(text);
            }
        } catch (NumberFormatException e) {
            printExceptionMessage(e);
            return false;
        }

        return true;
    }

    private void validateMod(final int buyingPrice) {
        if (buyingPrice % BUYING_PRICE_UNIT != ZERO) {
            throw new IllegalArgumentException(BUYING_PRICE_INPUT_EXCEPTION);
        }
    }

    private void printExceptionMessage(final IllegalArgumentException e) {
        String exceptionMessage = e.getMessage();
        System.out.println(exceptionMessage);
    }
}
