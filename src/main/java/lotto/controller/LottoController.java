package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoService = new LottoService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
    }

    private PurchaseAmount getPurchaseAmount() {
        try {
            int input = inputView.inputPurchaseAmount();
            return new PurchaseAmount(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getPurchaseAmount();
        }
    }
}