package lotto.controller;

import static lotto.constant.message.InputMessage.DELIMITER;
import static lotto.constant.message.InputMessage.WINNING_NUMBER;

import java.util.Arrays;
import java.util.List;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputController {
    public static WinningNumber getWinningNumber() {
        List<String> inputNumbers = Arrays.asList(InputView.requestWinningNumber().split(DELIMITER.getMessage(), -1));
        try {
            return new WinningNumber(inputNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getWinningNumber();
        }
    }
}
