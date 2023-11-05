package lotto.controller;

import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;

    public LottoController(final LottoService lottoService, final InputView inputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
    }

    public void play() {
        PurchaseAmount purchaseAmount = askPurchaseAmount();
        Lottos lottos = lottoService.generateLottos(purchaseAmount);
    }

    private PurchaseAmount askPurchaseAmount() {
        return PurchaseAmount.from(inputView.askPurchaseAmount());
    }
}
