package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Constants;

public class InputParser {

    public static int parsePurchaseAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> parseWinningNumbers(String undividedWinningNumbers) {
        String[] dividedWinningNumbers = undividedWinningNumbers.split(Constants.SEPARATOR);
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
