package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputConverter {
    public static int convertPrice(String inputPrice) {
        checkDigit(inputPrice);
        int price = Integer.parseInt(inputPrice);
        return price;
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

    public static void checkDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

}
