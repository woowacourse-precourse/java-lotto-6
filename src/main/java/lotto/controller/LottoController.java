package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        initPurchaseAmount();
    }

    private void initPurchaseAmount() {
        try {
            lottoService.initPurchaseAmount(InputView.inputPurchaseAmount());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            initPurchaseAmount();
        }
    }

}
