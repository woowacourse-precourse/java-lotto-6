package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;

import java.util.List;

import static lotto.utils.Parser.parseBonusNumber;
import static lotto.utils.Parser.parseWinningNumbers;
import static lotto.view.InputView.*;

public class LottoDrawingMachine {
    public static WinningNumbers drawWinningNumbers() {
        return (WinningNumbers) askUntilGetValidAnswer(
                () -> {
                    String commaSeparatedNumbers = askWinningNumber();
                    List<Integer> numbers = parseWinningNumbers(commaSeparatedNumbers);
                    return new WinningNumbers(numbers);
                }
        );
    }

    public static BonusNumber drawBonusNumber(List<Integer> winningNumbers) {
        return (BonusNumber) askUntilGetValidAnswer(
                () -> {
                    String bonusNumber = askBonusNumberMessage();
                    Integer number = parseBonusNumber(bonusNumber);
                    return new BonusNumber(winningNumbers, number);
                }
        );
    }
}
