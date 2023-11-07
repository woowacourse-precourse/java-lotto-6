package lotto.controller;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class InputProcessor {

    public static int processPurchaseAmountInput(String purchaseAmountinput) {
        int purchaseAmount = stringToInt(purchaseAmountinput);
        checkDivisibleBy1000(purchaseAmount);
        return purchaseAmount;
    }

    public static List<Integer> processWinningNumbersInput(String winningNumbersInput) {
        String[] winningNumbersInputs = winningNumbersInput.split(",\\s*");
        checkSixNumbers(winningNumbersInputs);
        Set<Integer> winningNumbers = new LinkedHashSet<>();
            for (String winningNumberInput : winningNumbersInputs) {
                int winningNumber = stringToInt(winningNumberInput);
                checkNumberRange(winningNumber);
                addNonDuplicateValue(winningNumbers, winningNumber);
            }
            return winningNumbers.stream().toList();
    }

    public static int processBonusNumberInput(String BonusNumberInput) {
        int BonusNumber = stringToInt(BonusNumberInput);
        checkNumberRange(BonusNumber);
        return BonusNumber;
    }

    private static void checkDivisibleBy1000(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력값은 천 단위여야 합니다.");
        }
    }

    private static void checkSixNumbers(String[] winningNumbersInputs) {
        if (winningNumbersInputs.length != 6) {
            throw new IllegalArgumentException("[ERROR] 여섯 개의 숫자를 입력하셔야 합니다.");
        }
    }
    
    private static void addNonDuplicateValue(Set<Integer> winningNumbers, int winningNumber) {
        if (!winningNumbers.add(winningNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복은 허용되지 않습니다.");
        }
    }

    private static void checkNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 입력값은 1부터 45까지의 숫자여야 합니다.");
        }
    }

    private static int stringToInt(String string) {
        int convertedValue;
        try {
            convertedValue = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자여야 합니다.");
        }
        return convertedValue;
    }
}
