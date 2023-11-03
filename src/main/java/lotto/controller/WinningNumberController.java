package lotto.controller;

import lotto.domain.WinningNumber;
import lotto.util.Parser;

import java.util.List;

public class WinningNumberController {
    private final Parser parser = new Parser();

    public void setInputToWinningNumbers(WinningNumber winningNumber, String playerInput) {
        List<Integer> inputNumbers = parser.stringListToNumberList(playerInput);
        winningNumber.setWinningNumbers(inputNumbers);
    }

    public void setInputToBonusNumber(WinningNumber winningNumber, String playerInput) {
        int inputNumber = parser.inputToNumber(playerInput);
        winningNumber.setBonusNumber(inputNumber);
    }
}
