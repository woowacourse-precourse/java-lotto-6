package lotto.controller;

import lotto.domain.WinningLotto;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningLottoInputHandler {
    private final InputView inputView;
    private final OutputView outputView;

    private WinningLottoInputHandler(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static WinningLottoInputHandler create(InputView inputView, OutputView outputView) {
        return new WinningLottoInputHandler(inputView, outputView);
    }

    public WinningLotto createWinningLotto() {
        WinningNumbers winningNumbers = readWinningNumbersFromUser();
        outputView.printAskBonusNumber();
        while (true) {
            try {
                int bonusNumberInput = inputView.readBonusNumber();
                return WinningLotto.create(winningNumbers, bonusNumberInput);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumbers readWinningNumbersFromUser() {
        outputView.printAskWinningNumbers();
        while (true) {
            try {
                String winningNumbersInput = inputView.readWinningNumbers();
                return WinningNumbers.from(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
