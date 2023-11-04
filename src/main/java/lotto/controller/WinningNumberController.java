package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;
import lotto.util.Parser;

import java.util.List;

public class WinningNumberController {
    private final Parser parser = new Parser();

    public void setInputToWinningNumbers(WinningNumbers winningNumbers, String playerInput) {
        List<Integer> inputNumbers = parser.stringListToNumberList(playerInput);
        winningNumbers.setWinningNumbers(inputNumbers);
    }

    public void setInputToBonusNumber(BonusNumber bonusNumber, String playerInput) {
        int inputNumber = parser.inputToNumber(playerInput);
        bonusNumber.setBonusNumber(inputNumber);
    }
}
