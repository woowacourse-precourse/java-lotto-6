package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String price = inputView.enterLottoPrice();
        try {
            lottoService.issueLotto(price);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
            return;
        }
        showPurchasedLotto();
    }

    private void showPurchasedLotto() {
        outputView.showPurchasedLotto(lottoService.findAllLotto());
    }
}
