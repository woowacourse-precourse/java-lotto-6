package lotto.controller;

import lotto.generator.RandomUniqueListGenerator;
import lotto.model.LottoOwner;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printEnterPurchaseAmount();
        Long purchaseAmount = inputView.getPurchaseAmount();
        Lottos lottos = Lottos.of(purchaseAmount, new RandomUniqueListGenerator());
        LottoOwner lottoOwner = LottoOwner.from(purchaseAmount, lottos);
    }
}
