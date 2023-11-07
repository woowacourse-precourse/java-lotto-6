package lotto.controller;

import lotto.model.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {

    private InputView inputView;
    private OutputView outputView;

    public Game() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        init();
    }

    private void init() {
        int purchasePrice = inputView.inputPurchasePrice();
        LottoGenerator.generateLotto(purchasePrice);

        inputView.inputWinningNumber();
        inputView.inputBonusNumber();
    }
}
