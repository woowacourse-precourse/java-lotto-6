package lotto;

import static lotto.Application.winningNumbers;

public class WinningNumberAndBonusNumber {
    public static void generateWinningNumbers(String inputWinningNumbers) {
        for (String winningNumber : inputWinningNumbers.split(",")) {
            winningNumbers.add(Integer.valueOf(winningNumber));
        }
    }
    public static Integer generateBonusNumber(String inputBonusNumber) {
        Integer bonusNumber = Integer.valueOf(inputBonusNumber);
        return bonusNumber;
    }
}
