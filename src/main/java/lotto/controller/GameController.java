package lotto.controller;

import lotto.domain.LottoStore;
import lotto.domain.PurchaseCount;
import lotto.view.InputView;

public class GameController {

    private final InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void proceedGame() {
        int userPurchaseAmount = inputView.readPurchaseAmount();
        LottoStore lottoStore = new LottoStore(userPurchaseAmount);
        while (lottoStore.isOpen()) {
            lottoStore.issueLotto();
        }
    }
}
