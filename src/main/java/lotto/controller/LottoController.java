package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();
    private LottoManager manager;

    public void run() {
        purchaseLotto();
        determineWinningLotto();
        makeStatistics();
    }

    private void purchaseLotto() {
        int numOfLottos = input.readPurchaseAmount() / Lotto.PRICE;
        output.printPurchaseAmount(numOfLottos);

        manager = LottoManager.of(numOfLottos, new RandomLottoGenerator());
        output.printLottos(manager.getPurchaseLottos());
    }


    private void determineWinningLotto() {
    }


    private void makeStatistics() {
    }
}
