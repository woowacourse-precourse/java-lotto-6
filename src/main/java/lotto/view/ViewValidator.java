package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.constant.ExceptionConstant.*;
import static lotto.constant.ExceptionConstant.BUYING_PRICE_INPUT_EXCEPTION;
import static lotto.constant.NumberConstant.BUYING_PRICE_UNIT;
import static lotto.constant.NumberConstant.ZERO;

public class ViewValidator {

    public int parseInt(final String buyingPriceText) {
        try {
            return Integer.parseInt(buyingPriceText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BUYING_PRICE_NUMBER_FORMAT_EXCEPTION);
        }
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

    public boolean validateMod(final int buyingPrice) {
        if (buyingPrice % BUYING_PRICE_UNIT != ZERO) {
            throw new IllegalArgumentException(BUYING_PRICE_INPUT_EXCEPTION);
        }

        return true;
    }

    public void printExceptionMessage(final IllegalArgumentException e) {
        String exceptionMessage = e.getMessage();
        System.out.println(exceptionMessage);
    }
}
