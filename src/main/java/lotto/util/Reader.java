package lotto.util;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.error.ErrorMessage.INVALID_BONUS_NUMBER_FORMAT;
import static lotto.error.ErrorMessage.INVALID_PURCHASE_AMOUNT_FORMAT;
import static lotto.error.ErrorMessage.INVALID_WINNING_NUMBER_FORMAT;

import java.util.ArrayList;
import java.util.List;

public final class Reader {
    private static final String COMMA = ",";

    private Reader() {
        throw new UnsupportedOperationException();
    }

    public static Integer purchaseAmount() {
        String purchaseAmount = readLine();
        return validFormatAndConvert(purchaseAmount, INVALID_PURCHASE_AMOUNT_FORMAT);
    }

    public static List<Integer> winningNumbers() {
        String winningNumber = readLine();
        String[] winningAmounts = winningNumber.split(COMMA);
        return validFormatAndConvert(winningAmounts, INVALID_WINNING_NUMBER_FORMAT);
    }

    public static Integer bonusNumber() {
        String bonusNumber = readLine();
        return validFormatAndConvert(bonusNumber, INVALID_BONUS_NUMBER_FORMAT);
    }

    private static Integer validFormatAndConvert(String input, String error) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(error);
        }
    }

    private static List<Integer> validFormatAndConvert(String[] input, String error) {
        List<Integer> result = new ArrayList<>();
        try {
            for (int index = 0; index < input.length; index++) {
                int converted = Integer.parseInt(input[index]);
                result.add(converted);
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(error);
        }
        return result;
    }
}
