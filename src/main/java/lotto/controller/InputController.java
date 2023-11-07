package lotto.controller;

import static lotto.constant.message.InputMessage.DELIMITER;

import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.LottoPublisher;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputController {
    public LottoPublisher getPurchasePrice() {
        try {
            return new LottoPublisher(InputView.requestPurchasePrice());
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception.getMessage());
            return getPurchasePrice();
        }
    }

    public WinningNumber getWinningNumber() {
        List<String> inputNumbers = Arrays.asList(InputView.requestWinningNumber().split(DELIMITER.getMessage(), -1));
        try {
            return new WinningNumber(inputNumbers);
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception.getMessage());
            return getWinningNumber();
        }
    }

    public BonusNumber getBonusNumber(List<Integer> winningNumbers) {
        try {
            return new BonusNumber(InputView.requestBonusNumber(), winningNumbers);
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }
}
