package lotto.controller.input;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static lotto.view.ErrorMessage.muchComma;
import static lotto.view.ErrorMessage.notDigitExceptionMessage;

public class InputConverter {

    private static final char standard = ',';
    private static final int standCount = 5;

    public static List<Integer> convertWinningNum(String inputWinningNum) throws IllegalArgumentException{
        List<Integer> winningNumbers = new ArrayList<>();
        checkCommaCount(inputWinningNum);
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

    public static void checkCommaCount(String winningNum) throws IllegalArgumentException {
        Long countComma = countStand(winningNum);
        if (countComma != standCount) {
            muchComma();
            throw new IllegalArgumentException();
        }
    }

    public static Long countStand(String input) {
        return input.chars().filter(c -> c == standard).count();
    }

}
