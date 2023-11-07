package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoStorage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Game {

    private InputView inputView;
    private OutputView outputView;

    public Game() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        init();
    }

    private void init() {
        int purchasePrice = inputView.requestPurchasePrice();
        LottoGenerator.generateLotto(purchasePrice);
        List<Lotto> purchaseLotto = LottoStorage.getLotto();
        outputView.printPurchaseLotto(purchaseLotto);

        inputView.requestWinningNumber();
        inputView.requestBonusNumber();
    }
}
