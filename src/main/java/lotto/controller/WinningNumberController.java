package lotto.controller;

import lotto.domain.WinningNumber;
import lotto.util.Parser;

public class WinningNumberController {
    private final Parser parser = new Parser();
    public void setWinningNumbers(WinningNumber winningNumber) {
        winningNumber.setWinningNumbers(parser.stringListToNumberList());
    }

    public void setBonusNumber(WinningNumber winningNumber) {
        winningNumber.setBonusNumber(parser.inputToNumber());
    }
}
