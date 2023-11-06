package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static lotto.controller.ExceptionController.checkExceptionPrice;
import static lotto.view.ErrorMessage.notDigitExceptionMessage;

public class InputConverter {
    public static int convertPrice(String inputPrice) {
        return checkDigit(inputPrice);
    }

    public static List<Integer> convertWinningNumber(String inputWinningNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(inputWinningNumber, ",");
        while(st.hasMoreTokens()) {
            String nextNumber = st.nextToken();
            winningNumbers.add(checkDigit(nextNumber));
        }
        return winningNumbers;
    }

    public static int convertBonusNumber(String inputBonusNumber) {
        return checkDigit(inputBonusNumber);
    }

    public static int checkDigit(String input) throws IllegalArgumentException{
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            notDigitExceptionMessage();
            throw e;
        }
    }

}
