package lotto.controller;

import lotto.generator.RandomUniqueListGenerator;
import lotto.model.LottoOwner;
import lotto.model.Lottos;
import lotto.model.PurchasePrice;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printEnterPurchaseAmount();
        PurchasePrice purchasePrice = PurchasePrice.from(inputView.getPurchaseAmount());
        Lottos lottos = Lottos.of(purchasePrice, new RandomUniqueListGenerator());
        LottoOwner lottoOwner = LottoOwner.of(purchasePrice, lottos);
        outputView.printLottosInfo(lottoOwner.getLottoInfo());
    }
}
