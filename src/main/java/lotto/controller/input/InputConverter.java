package lotto.controller.input;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static lotto.view.ErrorMessage.muchComma;
import static lotto.view.ErrorMessage.notDigitExceptionMessage;

public class InputConverter {

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
            notDigitExceptionMessage();
            throw e;
        }
    }

}
