package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;

import java.util.Arrays;
import java.util.List;

import static lotto.utils.ErrorMessage.BONUS_NUMBER_NOT_A_NUMBER;
import static lotto.utils.ErrorMessage.WINNING_NUMBERS_NOT_A_NUMBER;
import static lotto.view.InputView.*;

public class LottoDrawingMachine {
    public static WinningNumbers drawWinningNumbers() {
        return (WinningNumbers) askUntilGetValidAnswer(
                () -> {
                    String commaSeparatedNumbers = askWinningNumber();
                    List<Integer> numbers = splitCommaSeparatedNumbers(commaSeparatedNumbers);
                    return new WinningNumbers(numbers);
                }
        );
    }

    private static List<Integer> splitCommaSeparatedNumbers(String commaSeparatedNumbers) {
        try {
            return Arrays.stream(commaSeparatedNumbers.split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (Exception e) {
            throw new IllegalArgumentException(WINNING_NUMBERS_NOT_A_NUMBER.getDescription());
        }
    }

    public static BonusNumber drawBonusNumber(List<Integer> winningNumbers) {
        return (BonusNumber) askUntilGetValidAnswer(
                () -> {
                    String bonusNumber = askBonusNumberMessage();
                    Integer number = parseInt(bonusNumber);
                    return new BonusNumber(winningNumbers, number);
                }
        );
    }

    private static Integer parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_A_NUMBER.getDescription());
        }
    }
}
