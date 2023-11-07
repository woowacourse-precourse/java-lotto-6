package lotto.controller;


import java.util.List;
import lotto.config.InputConfiguration;
import lotto.vo.BonusNumber;
import lotto.vo.WinningNumbers;
import lotto.util.handler.InputHandler;

public class WinningController {
    public WinningNumbers processWinningNumbers() {
        InputHandler<List<Integer>> winningNumbersInputHandler = InputConfiguration.createWinningNumbersInputHandler();
        List<Integer> winningNumbersList = winningNumbersInputHandler.processInput();
        return WinningNumbers.from(winningNumbersList);
    }

    public BonusNumber processBonusNumber(WinningNumbers winningNumbers) {
        InputHandler<Integer> bonusNumberInputHandler = InputConfiguration.createBonusNumberInputHandler(
                winningNumbers);
        int number = bonusNumberInputHandler.processInput();
        return BonusNumber.from(number);
    }
}
