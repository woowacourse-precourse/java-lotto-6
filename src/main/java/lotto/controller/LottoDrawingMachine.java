package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;

import static lotto.view.InputView.*;

public class LottoDrawingMachine {
    public static WinningNumbers drawWinningNumbers() {
        return (WinningNumbers) askUntilGetValidAnswer(
                () -> {
                    String winningNumber = askWinningNumber();
                    return new WinningNumbers(winningNumber);
                }
        );
    }

    public static BonusNumber drawBonusNumber() {
        return (BonusNumber) askUntilGetValidAnswer(
                () -> {
                    String bonusNumber = askBonusNumberMessage();
                    return new BonusNumber(bonusNumber);
                }
        );
    }
}
