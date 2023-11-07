package lotto.controller.input;

import lotto.view.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputConverter {

    private static String errorMessage;

    public static List<Integer> convertWinningNum(String inputWinningNum) throws IllegalArgumentException{
        List<Integer> winningNumbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(inputWinningNum, ",");
        while(st.hasMoreTokens()) {
            String nextNumber = st.nextToken();
            winningNumbers.add(convertDigit(nextNumber));
        }
        return winningNumbers;
    }

    public static int convertDigit(String inputNum) throws IllegalArgumentException{
        try {
            return Integer.parseInt(inputNum);
        } catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.notDigit.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
