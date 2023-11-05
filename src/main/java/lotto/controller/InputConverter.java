package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputConverter {
    public static int convertPrice(String inputPrice) {
        return checkDigit(inputPrice);
    }

    public static List<Integer> convertWinningNumber(String inputWinningNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(inputWinningNumber, ",");
        while(st.hasMoreTokens()) {
            String nextNumber = st.nextToken();
            checkDigit(nextNumber);
            int winningNumber = Integer.parseInt(nextNumber);
            winningNumbers.add(winningNumber);
        }
        return winningNumbers;
    }

    public static int convertBonusNumber(String inputBonusNumber) {
        checkDigit(inputBonusNumber);
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        return bonusNumber;
    }

    public static int checkDigit(String input) throws IllegalArgumentException{
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

}
