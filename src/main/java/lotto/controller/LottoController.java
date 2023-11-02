package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.io.InputManager;
import lotto.io.OutputView;
import lotto.service.LottoService;

public class LottoController {

    private final OutputView outputView;
    private final InputManager inputManager;
    private final LottoService lottoService;

    public LottoController(
            final OutputView outputView,
            final InputManager inputManager,
            final LottoService lottoService) {
        this.outputView = outputView;
        this.inputManager = inputManager;
        this.lottoService = lottoService;
    }

    public void run() {
        createPurchaseAmount();
        purchase();
    }

    private void createPurchaseAmount() {
        outputView.printPurchaseAmountRequest();
        final PurchaseAmount purchaseAmount = inputManager.readPurchaseAmount();
        lottoService.savePurchaseAmount(purchaseAmount);
    }

    private void purchase() {
        final Lottos lottos = lottoService.purchase();
        outputView.printLottos(lottos);
    }
}
