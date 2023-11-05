package lotto.controller;

import lotto.model.LottoOwner;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printEnterPurchaseAmount();
        LottoOwner lottoOwner = LottoOwner.from(inputView.getPurchaseAmount());
    }
}
