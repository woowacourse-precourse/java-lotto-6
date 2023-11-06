package lotto.controller;

import lotto.model.LottoPlayer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.askForPurchaseAmount();
        int amount = inputView.getPurchaseAmount();

        LottoPlayer lottoPlayer = new LottoPlayer(amount);
        lottoPlayer.buyLottos();
    }
}
