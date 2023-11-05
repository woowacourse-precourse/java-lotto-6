package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView;
    OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        issueLotto();
        getWinningNumbers();
        printLottoResult();
    }

    private void issueLotto() {
    }

    private void getWinningNumbers() {
    }

    private void printLottoResult() {
    }
}
