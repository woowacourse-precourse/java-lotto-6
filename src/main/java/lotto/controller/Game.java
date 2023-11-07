package lotto.controller;

import lotto.model.LottoGenerator;
import lotto.view.InputView;

public class Game {

    private InputView inputView;

    public Game() {
        this.inputView = new InputView();
        init();
    }

    private void init() {
        int purchasePrice = inputView.inputPurchasePrice();
        LottoGenerator.generateLotto(purchasePrice);

        inputView.inputWinningNumber();
        inputView.inputBonusNumber();
    }
}
