package lotto.controller;

import lotto.LottoPlayer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        LottoPlayer lottoPlayer = createLottoPlayer(getPurchase());
        createLottoList();
        getPlayerNumbers();
        displayResult();
    }

    private int getPurchase() {
        outputView.printLottoPurchaseInputMessage();
        int lottoPurchase = inputView.requestLottoPurchase();
        return lottoPurchase;
    }

    private LottoPlayer createLottoPlayer(int initialAmount) {
        LottoPlayer lottoPlayer = new LottoPlayer(initialAmount);
        return lottoPlayer;
    }

    private void createLottoList() {
    }

    private void getPlayerNumbers() {
    }

    private void displayResult() {
    }
}
