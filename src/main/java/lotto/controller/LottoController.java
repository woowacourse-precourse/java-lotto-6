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

    private void createLottoList(LottoPlayer lottoPlayer) {
        int lottoCount = lottoPlayer.getLottoCount();
        outputView.printLottoPurchaseCountMessage(lottoCount);
        for (int i=0; i<lottoCount; i++) {
            createLotto();
        }
    }

    private void createLotto() {}

    private void getPlayerNumbers() {
    }

    private void displayResult() {
    }
}
