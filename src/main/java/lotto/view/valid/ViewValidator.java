package lotto.view.valid;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.ExceptionConstant.*;
import static lotto.constant.NumberConstant.*;

public class ViewValidator {

    public int parseInt(final String inputText) {
        try {
            return Integer.parseInt(inputText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }

    public void validateWinningNumberSize(final List<String> winningNumbersText) {
        if (winningNumbersText.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBER_SIZE_EXCEPTION);
        }
    }

    public List<Integer> validateWinningNumberFormat(final List<String> winningNumbersText) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String text : winningNumbersText) {
            int winningNumber = parseInt(text);
            winningNumbers.add(winningNumber);
        }

        return winningNumbers;
    }

    public void validateMinPrice(final int buyingPrice) {
        if (buyingPrice <= ZERO_PRICE) {
            throw new IllegalArgumentException(BUYING_PRICE_ZERO_EXCEPTION);
        }
    }

    public void validateMod(final int buyingPrice) {
        if (buyingPrice % BUYING_PRICE_UNIT != ZERO_REMAINDER) {
            throw new IllegalArgumentException(BUYING_PRICE_UNIT_EXCEPTION);
        }
    }

    public void printExceptionMessage(final IllegalArgumentException e) {
        String exceptionMessage = e.getMessage();
        System.out.println(exceptionMessage);
    }
}
