package lotto.controller;

import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoCompareSite {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void access() {
        outputView.printInputWinningNumbersMessage();
        WinningNumber winningNumber = inputView.readWinningNumber();
    }
}
