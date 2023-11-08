package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        int lottoPurchase = getPurchase();
        createLottoPlayer();
        createLottoList();
        getPlayerNumbers();
        displayResult();
    }

    private int getPurchase() {
        outputView.printLottoPurchaseInputMessage();
        int lottoPurchase = inputView.requestLottoPurchase();
        return lottoPurchase;
    }

    private void createLottoPlayer() {
    }

    private void createLottoList() {
    }

    private void getPlayerNumbers() {
    }

    private void displayResult() {
    }
}
