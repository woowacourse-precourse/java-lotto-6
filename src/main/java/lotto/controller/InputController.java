package lotto.controller;

import static lotto.constant.message.InputMessage.DELIMITER;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoAmount;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputController {
    public static LottoAmount getPurchasePrice() {
        try {
            return new LottoAmount(InputView.requestPurchasePrice());
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception.getMessage());
            return getPurchasePrice();
        }
    }

    public static WinningNumber getWinningNumber() {
        List<String> inputNumbers = Arrays.asList(InputView.requestWinningNumber().split(DELIMITER.getMessage(), -1));
        try {
            return new WinningNumber(inputNumbers);
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception.getMessage());
            return getWinningNumber();
        }
    }
}
