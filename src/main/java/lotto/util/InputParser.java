package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private static final String SEPARATOR = ",";

    public static int parsePurchaseAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> parseWinningNumbers(String undividedWinningNumbers) {
        String[] dividedWinningNumbers = undividedWinningNumbers.split(SEPARATOR);
        List<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumber : dividedWinningNumbers) {
            winningNumbers.add(Integer.parseInt(winningNumber));
        }
        return winningNumbers;
    }

    public static int parseBonusNumber(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

}
